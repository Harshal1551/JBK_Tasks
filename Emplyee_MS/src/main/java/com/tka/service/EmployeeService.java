package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.Employee_MS;
import com.tka.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// =====================================================
	// ADD EMPLOYEE
	// =====================================================

	public Employee_MS addEmployee(Employee_MS employee) {

		// Employee name validation
		if (employee.getName() == null || employee.getName().trim().isEmpty()) {

			throw new RuntimeException("Employee name cannot be empty");
		}

		// Salary validation
		if (employee.getSalary() <= 10000) {

			throw new RuntimeException("Salary must be greater than 10,000");
		}

		// Mobile validation
		if (employee.getMobile() == null || !employee.getMobile().matches("\\d{10}")) {

			throw new RuntimeException("Mobile number must contain exactly 10 digits");
		}

		// Email validation
		if (employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {

			throw new RuntimeException("Email cannot be empty");
		}

		// Check duplicate email
		if (employeeRepository.existsByEmail(employee.getEmail())) {

			throw new RuntimeException("Email already exists");
		}

		return employeeRepository.save(employee);
	}

	// =====================================================
	// GET EMPLOYEE BY ID
	// =====================================================

	public Employee_MS getEmployeeById(int id) {

		return employeeRepository.findById(id).orElse(null);
	}

	// =====================================================
	// UPDATE EMPLOYEE
	// =====================================================

	public Employee_MS updateEmployee(Employee_MS employee) {

		// Employee name validation
		if (employee.getName() == null || employee.getName().trim().isEmpty()) {

			throw new RuntimeException("Employee name cannot be empty");
		}

		// Salary validation
		if (employee.getSalary() <= 10000) {

			throw new RuntimeException("Salary must be greater than 10,000");
		}

		// Mobile validation
		if (employee.getMobile() == null || !employee.getMobile().matches("\\d{10}")) {

			throw new RuntimeException("Mobile number must contain exactly 10 digits");
		}

		// Email validation
		if (employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {

			throw new RuntimeException("Email cannot be empty");
		}

		// Check duplicate email
		boolean emailExists = employeeRepository.existsByEmailAndEmployeeIdNot(employee.getEmail(),
				employee.getEmployeeId());

		if (emailExists) {

			throw new RuntimeException("Email already belongs to another employee");
		}

		return employeeRepository.save(employee);
	}

	// =====================================================
	// DELETE EMPLOYEE
	// =====================================================

	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);
	}

	// =====================================================
	// GET ALL EMPLOYEES
	// =====================================================

	public List<Employee_MS> getAllEmployees() {

		return employeeRepository.findAll();
	}

	// =====================================================
	// SEARCH BY NAME
	// =====================================================

	public List<Employee_MS> searchByName(String name) {

		return employeeRepository.findByNameContainingIgnoreCase(name);
	}

	// =====================================================
	// SEARCH BY DEPARTMENT
	// =====================================================

	public List<Employee_MS> searchByDepartment(String department) {

		return employeeRepository.findByDepartmentIgnoreCase(department);
	}

	// =====================================================
	// SALARY GREATER THAN 50,000
	// =====================================================

	public List<Employee_MS> getEmployeesBySalaryMoreThan50000() {

		return employeeRepository.findBySalaryGreaterThan(50000);
	}

	// =====================================================
	// AVERAGE SALARY
	// =====================================================

	public Double getAverageSalary() {

		Double average = employeeRepository.findAverageSalary();

		if (average == null) {
			return 0.0;
		}

		return average;
	}

	// =====================================================
	// TOTAL EMPLOYEES
	// =====================================================

	public long getTotalEmployees() {

		return employeeRepository.count();
	}

	// =====================================================
	// COUNT EMPLOYEES BY DEPARTMENT
	// =====================================================

	public long getEmployeesByDepartmentCount(String department) {

		return employeeRepository.countByDepartmentIgnoreCase(department);
	}

}