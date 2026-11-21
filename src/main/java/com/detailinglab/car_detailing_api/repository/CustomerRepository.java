package com.detailinglab.car_detailing_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.detailinglab.car_detailing_api.entity.Customer;



public interface CustomerRepository   extends JpaRepository<Customer, Long> {

    Optional<Customer> findByMobile(String mobile);
}