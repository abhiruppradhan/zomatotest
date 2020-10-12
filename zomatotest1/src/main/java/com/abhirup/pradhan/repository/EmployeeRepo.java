package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhirup.pradhan.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {
	@Query("select e from Employee e where e.employee_Id = ?1")
	public Employee getValueByEmployee_Id(String id);
}
