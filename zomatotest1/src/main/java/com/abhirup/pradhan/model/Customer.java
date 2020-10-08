package com.abhirup.pradhan.model;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	private int customer_Id;
	private String customer_Name;
	private String customer_Address;
	private int customer_Phn;
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getCustomer_Address() {
		return customer_Address;
	}
	public void setCustomer_Address(String customer_Address) {
		this.customer_Address = customer_Address;
	}
	public int getCustomer_Phn() {
		return customer_Phn;
	}
	public void setCustomer_Phn(int customer_Phn) {
		this.customer_Phn = customer_Phn;
	}
	@Override
	public String toString() {
		return "Customer [customer_Id=" + customer_Id + ", customer_Name=" + customer_Name + ", customer_Address="
				+ customer_Address + ", customer_Phn=" + customer_Phn + "]";
	}
	
}
