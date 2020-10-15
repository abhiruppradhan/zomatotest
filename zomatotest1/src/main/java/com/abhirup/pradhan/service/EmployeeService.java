package com.abhirup.pradhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhirup.pradhan.model.Employee;
import com.abhirup.pradhan.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;
	
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
	}	
	
	public void editEmployee(Employee emp) {
		empRepo.save(emp);
	}
	
	public void deleteEmployee(String id) {
		empRepo.deleteById(id);
	}
	
	public Employee getEmployee(String id) {
		Employee emp = empRepo.getValueByEmployee_Id(id);
		if(emp != null) {
			return emp;
		}else {
			return null;
		}
	}
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
}
