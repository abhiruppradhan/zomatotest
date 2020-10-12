package com.abhirup.pradhan.model;

import javax.persistence.*;
import java.util.*;
@Entity
public class OrderDet {
	@Id
	private int order_Id;
	private Date date;
	private int delivery;
	private double price;
	@ManyToOne
	@JoinColumn(name="customer_Id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="restaurant_Id")
	private Restaurant restaurant;
	@OneToMany
	private Set<Product> product = new HashSet<Product>();
	@ManyToOne
	@JoinColumn(name="employee_Id")
	private Employee employee;
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}

