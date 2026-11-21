package com.detailinglab.car_detailing_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detailinglab.car_detailing_api.dto.CustomerRequest;
import com.detailinglab.car_detailing_api.entity.Customer;
import com.detailinglab.car_detailing_api.services.CustomerService;



@RestController
@RequestMapping("/api/customers")
public class CustomerController {
  private final CustomerService customerService ;
  
  public CustomerController(CustomerService customerService) {
      this.customerService = customerService;
  }

  @PostMapping
  public Customer create(
          @RequestBody CustomerRequest request) {

      return customerService.create(request);
  }

  @GetMapping
  public List<Customer> getAll() {
      return customerService.getAll();
  }

  @GetMapping("/{id}")
  public Customer getById(@PathVariable Long id) {
      return customerService.getById(id);
  }
  
  @DeleteMapping("/{id}")
  public void delete(
          @PathVariable Long id) {

      customerService.delete(id);
  }
}
