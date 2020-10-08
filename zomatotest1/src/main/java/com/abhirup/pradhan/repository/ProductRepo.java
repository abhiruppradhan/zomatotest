package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhirup.pradhan.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
