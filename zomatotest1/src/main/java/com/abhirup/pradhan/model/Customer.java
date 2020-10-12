package com.abhirup.pradhan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Customer {
	@Id
	private String customer_Id;
	private String customer_Name;
	private String customer_Address;
	@Column(length=10)
	private String customer_Phn;
	private String customer_Password;
	@OneToMany(mappedBy="customer")
	private Set<OrderDet> orderdet = new HashSet<OrderDet>();
	
	public Set<OrderDet> getOrderdet() {
		return orderdet;
	}
	public void setOrderdet(Set<OrderDet> orderdet) {
		this.orderdet = orderdet;
	}
	public String getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
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
	public String getCustomer_Phn() {
		return customer_Phn;
	}
	public void setCustomer_Phn(String customer_Phn) {
		this.customer_Phn = customer_Phn;
	}
	public String getCustomer_Password() {
		return customer_Password;
	}
	public void setCustomer_Password(String customer_Password) {
		this.customer_Password = customer_Password;
	}
	
}
