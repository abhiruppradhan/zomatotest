package com.abhirup.pradhan.model;
import javax.persistence.*;

import java.util.*;

@Entity
public class Product {
	@Id
	private int product_Id;
	private String product_Name;
	private String product_Description;
	private int product_Price;
	@ManyToMany
	private List<Restaurant> restuarant = new ArrayList<Restaurant>();
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
	public int getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}
	public List<Restaurant> getRestuarant() {
		return restuarant;
	}
	public void setRestuarant(List<Restaurant> restuarant) {
		this.restuarant = restuarant;
	}
	@Override
	public String toString() {
		return "Product [product_Id=" + product_Id + ", product_Name=" + product_Name + ", product_Description="
				+ product_Description + ", product_Price=" + product_Price
				+ ", restuarant=" + restuarant + "]";
	}
	
}
