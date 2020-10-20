package com.abhirup.pradhan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	private String employee_Id;
	private String employee_Name;
	@Column(length=10)
	private String employee_Phn;
	private String employee_Address;
	private String employee_Location;
	private int stars;
	private int active;
	private int working;
	private String employee_Password;
	@OneToMany(mappedBy="employee")
	private Set<OrderDet> orderdet = new HashSet<OrderDet>();
	
	public Set<OrderDet> getOrderdet() {
		return orderdet;
	}
	public void setOrderdet(Set<OrderDet> orderdet) {
		this.orderdet = orderdet;
	}
	public String getEmployee_Id() {
		return employee_Id;
	}
	public String getEmployee_Address() {
		return employee_Address;
	}
	public void setEmployee_Address(String employee_Address) {
		this.employee_Address = employee_Address;
	}
	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getEmployee_Name() {
		return employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}
	public String getEmployee_Phn() {
		return employee_Phn;
	}
	public void setEmployee_Phn(String employee_Phn) {
		this.employee_Phn = employee_Phn;
	}
	public String getEmployee_Location() {
		return employee_Location;
	}
	public void setEmployee_Location(String employee_Location) {
		this.employee_Location = employee_Location;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getEmployee_Password() {
		return employee_Password;
	}
	public void setEmployee_Password(String employee_Password) {
		this.employee_Password = employee_Password;
	}
	public int getWorking() {
		return working;
	}
	public void setWorking(int working) {
		this.working = working;
	}
	
}
