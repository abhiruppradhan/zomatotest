package com.abhirup.pradhan.service;

import java.util.ArrayList;
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
		emp.setWorking(1);
		empRepo.save(emp);
	}	
	
	public void editEmployee(Employee emp) {
		empRepo.save(emp);
	}
	
	public void deleteEmployee(String id) {
		Employee emp = empRepo.getOne(id);
		emp.setWorking(0);
		empRepo.save(emp);
	}
	
	public Employee getEmployee(String id) {
		return empRepo.getOne(id);
	}
	
	public List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<Employee>();
		for(Employee e : empRepo.findAll()) {
			if(e.getWorking()==1) {
				list.add(e);
			}
		}
		return list;
	}
}
