package com.detailinglab.car_detailing_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.detailinglab.car_detailing_api.entity.Vehicle;


public interface VehicleRepository    extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByCustomerId(Long customerId);
}
