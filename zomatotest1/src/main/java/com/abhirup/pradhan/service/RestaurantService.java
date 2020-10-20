package com.abhirup.pradhan.service;

import java.util.ArrayList;
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
		restaurant.setActive(1);
		restRepo.save(restaurant);
	}
	
	public void editRestaurant(Restaurant restaurant) {
		restRepo.save(restaurant);
	}
	
	
	public void deleteRestaurant(String id) {
		Restaurant rest = getRestaurant(id);
		rest.setActive(0);
		restRepo.save(rest);
	}
	
	public List<Restaurant> getRestaurants(){
		List<Restaurant> list = new ArrayList<Restaurant>();
		for(Restaurant rest : restRepo.findAll()) {
			if(rest.getActive()==1) {
				list.add(rest);
			}
		}
		return list;
	}
	
	public Restaurant getRestaurant(String id) {
		return restRepo.getOne(id);
	}
}
