package com.abhirup.pradhan.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhirup.pradhan.model.Product;
import com.abhirup.pradhan.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {
	@Query("select r from Restaurant r where r.restaurant_Id = ?1")
	public Restaurant getValueByRestaurant_Id(String id);
}
