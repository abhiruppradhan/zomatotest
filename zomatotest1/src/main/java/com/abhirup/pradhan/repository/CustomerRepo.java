package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhirup.pradhan.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,String>{
	@Query("select c from Customer c where c.customer_Id = ?1")
	public Customer getValueByCustomer_Id(String id);
}
