package com.abhirup.pradhan.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Restaurant {
	@Id
	private String restaurant_Id;
	private String restaurant_Name;
	private String restaurant_Address;
	private String restaurant_Password;
	@Column(length=10)
	private String restaurant_Phn;
	@OneToMany
	private Set<Product> product = new HashSet<Product>();
	@OneToMany(mappedBy="restaurant")
	private Set<OrderDet> orderdet = new HashSet<OrderDet>();
	private int restaurant_Open;
	private int active;
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getRestaurant_Id() {
		return restaurant_Id;
	}
	
	public Set<OrderDet> getOrderdet() {
		return orderdet;
	}

	public void setOrderdet(Set<OrderDet> orderdet) {
		this.orderdet = orderdet;
	}

	public void setRestaurant_Id(String restaurant_Id) {
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
	public String getRestaurant_Phn() {
		return restaurant_Phn;
	}
	public void setRestaurant_Phn(String restaurant_Phn) {
		this.restaurant_Phn = restaurant_Phn;
	}
	public int getRestaurant_Open() {
		return restaurant_Open;
	}
	public void setRestaurant_Open(int restaurant_Open) {
		this.restaurant_Open = restaurant_Open;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public String getRestaurant_Password() {
		return restaurant_Password;
	}

	public void setRestaurant_Password(String restaurant_Password) {
		this.restaurant_Password = restaurant_Password;
	}
	
}
