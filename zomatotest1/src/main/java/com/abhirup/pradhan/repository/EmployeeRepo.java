package com.abhirup.pradhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhirup.pradhan.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
