package com.abhirup.pradhan.model;

import javax.persistence.*;
import java.util.*;
@Entity
public class Order {
	@Id
	private int order_Id;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Restaurant restaurant;
	@OneToMany
	private List<Product> product = new ArrayList<Product>();
	private Date date;
	@ManyToOne
	private Employee employee;
	private int delivery;
	private int price;
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
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [order_Id=" + order_Id + ", customer=" + customer + ", restaurant=" + restaurant + ", product="
				+ product + ", date=" + date + ", employee=" + employee + ", delivery=" + delivery + ", price=" + price
				+ "]";
	}
	
}
