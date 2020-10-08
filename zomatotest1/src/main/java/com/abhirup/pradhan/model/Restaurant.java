package com.abhirup.pradhan.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Restaurant {
	@Id
	private int restaurant_Id;
	private String restaurant_Name;
	private String restaurant_Address;
	private int restaurant_Phn;
	@ManyToMany(mappedBy="Product")
	private List<Product> restaurant_Products = new ArrayList<Product>();
	private int restaurant_Open;
	
	@Override
	public String toString() {
		return "Restaurant [restaurant_Id=" + restaurant_Id + ", restaurant_Name=" + restaurant_Name
				+ ", restaurant_Address=" + restaurant_Address + ", restaurant_Phn=" + restaurant_Phn
				+ ", restaurant_Products=" + restaurant_Products + ", restaurant_Open=" + restaurant_Open + "]";
	}
	
	public int getRestaurant_Id() {
		return restaurant_Id;
	}
	public void setRestaurant_Id(int restaurant_Id) {
		this.restaurant_Id = restaurant_Id;
	}
	public String getRestaurant_Name() {
		return restaurant_Name;
	}
	public void setRestaurant_Name(String restaurant_Name) {
		this.restaurant_Name = restaurant_Name;
	}
	public String getRestaurant_Address() {
		return restaurant_Address;
	}
	public void setRestaurant_Address(String restaurant_Address) {
		this.restaurant_Address = restaurant_Address;
	}
	public int getRestaurant_Phn() {
		return restaurant_Phn;
	}
	public void setRestaurant_Phn(int restaurant_Phn) {
		this.restaurant_Phn = restaurant_Phn;
	}
	public List<Product> getRestaurant_Products() {
		return restaurant_Products;
	}
	public void setRestaurant_Products(List<Product> restaurant_Products) {
		this.restaurant_Products = restaurant_Products;
	}
	public int getRestaurant_Open() {
		return restaurant_Open;
	}
	public void setRestaurant_Open(int restaurant_Open) {
		this.restaurant_Open = restaurant_Open;
	}
	
}
