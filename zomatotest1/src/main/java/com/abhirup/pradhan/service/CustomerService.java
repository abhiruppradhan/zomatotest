package com.abhirup.pradhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhirup.pradhan.model.Customer;
import com.abhirup.pradhan.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo crepo;
	
	public void editCustomer(Customer cus) {
		crepo.save(cus);
	}

	public void addCustomer(Customer cus) {
		crepo.save(cus);
	}
	
	public void deleteCustomer(String id) {
		crepo.deleteById(id);
	}
	
	public Customer getCustomer(String id) {
		return crepo.getOne(id);
	}
	
	public List<Customer> getCustomers(){
		return crepo.findAll();
	}
}
