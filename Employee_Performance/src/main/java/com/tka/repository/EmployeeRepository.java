package com.tka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// API 2 - Get Employees By Department
    List<Employee> findByDepartment(String department);
}
