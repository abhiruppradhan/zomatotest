package com.abhirup.pradhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhirup.pradhan.model.Restaurant;
import com.abhirup.pradhan.repository.RestaurantRepo;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepo restRepo;
	
	public void addRestaurant(Restaurant restaurant) {
		restRepo.save(restaurant);
	}
	
	public void editRestaurant(Restaurant restaurant) {
		restRepo.save(restaurant);
	}
	
	public List<Restaurant> getRestaurants(){
		return restRepo.findAll();
	}
}
