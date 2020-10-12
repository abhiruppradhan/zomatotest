package com.abhirup.pradhan.model;
import javax.persistence.*;

import java.util.*;

@Entity
public class Product {
	@Id
	private int product_Id;
	private String product_Name;
	private String product_Description;
	private double product_Price;
	@ManyToMany
	private Set<Restaurant> restaurant = new HashSet<Restaurant>();
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Description() {
		return product_Description;
	}
	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}
	public double getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}
	public Set<Restaurant> getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Set<Restaurant> restuarant) {
		this.restaurant = restuarant;
	}
	
}
