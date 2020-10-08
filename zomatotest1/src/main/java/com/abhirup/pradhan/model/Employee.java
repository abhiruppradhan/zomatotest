package com.abhirup.pradhan.model;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	private int employee_Id;
	private String employee_Name;
	private int employee_Phn;
	private String employee_Address;
	private String employee_Location;
	private int stars;
	private int active;
	public int getEmployee_Id() {
		return employee_Id;
	}
	public String getEmployee_Address() {
		return employee_Address;
	}
	public void setEmployee_Address(String employee_Address) {
		this.employee_Address = employee_Address;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getEmployee_Name() {
		return employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}
	public int getEmployee_Phn() {
		return employee_Phn;
	}
	public void setEmployee_Phn(int employee_Phn) {
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
	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name=" + employee_Name + ", employee_Phn="
				+ employee_Phn + ", employee_Location=" + employee_Location + ", stars=" + stars + ", active=" + active
				+ "]";
	}
	
}
