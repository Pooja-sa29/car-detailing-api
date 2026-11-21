package com.detailinglab.car_detailing_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.detailinglab.car_detailing_api.dto.CustomerRequest;
import com.detailinglab.car_detailing_api.entity.Customer;
import com.detailinglab.car_detailing_api.repository.CustomerRepository;


@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	 public CustomerService(CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }
	 
	  // Create customer
	    public Customer create(CustomerRequest request) {

	        // Check whether mobile already exists
	        if (customerRepository.findByMobile(request.getMobile()).isPresent()) {
	            throw new RuntimeException(
	                    "Customer with this mobile number already exists"
	            );
	        }

	        Customer customer = new Customer();

	        customer.setName(request.getName());
	        customer.setMobile(request.getMobile());

	        return customerRepository.save(customer);
	    }
	    
	    // Get all customers
	    public List<Customer> getAll() {
	        return customerRepository.findAll();
	    }

	    // Get customer by ID
	    public Customer getById(Long id) {

	        return customerRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Customer not found with id: " + id
	                        )
	                );
	    }

	    // Update customer
	    public Customer update(
	            Long id,
	            CustomerRequest request) {

	        Customer customer = getById(id);

	        customer.setName(request.getName());
	        customer.setMobile(request.getMobile());

	        return customerRepository.save(customer);
	    }

	    // Delete customer
	    public void delete(Long id) {

	        Customer customer = getById(id);

	        customerRepository.delete(customer);
	    }
}
