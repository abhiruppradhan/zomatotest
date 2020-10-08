package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhirup.pradhan.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}
