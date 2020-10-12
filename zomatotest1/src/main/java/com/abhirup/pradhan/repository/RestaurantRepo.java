package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhirup.pradhan.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {

}
