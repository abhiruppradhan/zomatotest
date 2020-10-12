package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhirup.pradhan.model.OrderDet;

public interface OrderRepo extends JpaRepository<OrderDet, Integer> {

}
