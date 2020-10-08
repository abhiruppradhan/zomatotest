package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhirup.pradhan.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
