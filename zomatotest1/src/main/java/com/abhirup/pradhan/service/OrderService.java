package com.abhirup.pradhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhirup.pradhan.model.OrderDet;
import com.abhirup.pradhan.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo orderRepo;
	
	public void addOrder(OrderDet neworder) {
		neworder.setOrder_Id(orderRepo.count()+1);
		orderRepo.save(neworder);
	}
	public void editOrder(OrderDet neworder) {
		orderRepo.save(neworder);
	}
	
	public List<OrderDet> getOrders(){
		return orderRepo.findAll();
	}
	
	public OrderDet getOrder(long id){
		return orderRepo.getOne(id);
	}
	
}
