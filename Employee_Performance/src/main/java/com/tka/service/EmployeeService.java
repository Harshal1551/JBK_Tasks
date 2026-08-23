package com.tka.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.Employee;
import com.tka.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeerepo;

	// API 1 - Add Employee
	public Map<String, Object> addEmployee(Employee employee) {

	    Map<String, Object> result = new HashMap<>();

	    // Validation 1 - Employee name
	    if (employee.getE_name() == null || employee.getE_name().trim().isEmpty()) {

	        result.put("message", "Employee name must not be empty");

	        return result;
	    }

	    // Validation 2 - Monthly salary
	    if (employee.getMonthlySalary() <= 15000) {

	        result.put("message", "Monthly salary must be greater than 15000");

	        return result;
	    }

	    // Validation 3 - Performance score
	    if (employee.getPerformanceScore() < 0 ||
	        employee.getPerformanceScore() > 10) {

	        result.put("message", "Performance score must be between 0 and 10");

	        return result;
	    }

	    // Validation 4 - Experience years
	    if (employee.getExperienceYears() < 0) {

	        result.put("message", "Experience years cannot be negative");

	        return result;
	    }

	    // Save employee
	    Employee savedEmployee = employeerepo.save(employee);

	    result.put("message", "Employee added successfully");
	    result.put("employeeId", savedEmployee.getE_id());
	    result.put("employeeName", savedEmployee.getE_name());

	    return result;
	}

	// API 2 - Get Employees By Department
	public List<Map<String, Object>> employeesByDepartment(String department) {

	    List<Employee> employees = employeerepo.findByDepartment(department);

	    List<Map<String, Object>> result = new ArrayList<>();

	    for (Employee employee : employees) {

	        Map<String, Object> data = new HashMap<>();

	        double annualSalary = employee.getMonthlySalary() * 12;

	        data.put("employeeId", employee.getE_id());
	        data.put("employeeName", employee.getE_name());
	        data.put("department", employee.getDepartment());
	        data.put("monthlySalary", employee.getMonthlySalary());
	        data.put("annualSalary", annualSalary);
	        data.put("performanceScore", employee.getPerformanceScore());

	        result.add(data);
	    }

	    return result;
	}
	

	// API 3 - Calculate Employee Performance Bonus
	public Map<String, Object> employeeBonus(int id) {

	    Employee employee = employeerepo.findById(id).get();

	    double bonusPercentage = 0;

	    if (employee.getPerformanceScore() >= 9) {

	        bonusPercentage = 20;

	    } else if (employee.getPerformanceScore() >= 8) {

	        bonusPercentage = 15;

	    } else if (employee.getPerformanceScore() >= 7) {

	        bonusPercentage = 10;

	    } else {

	        bonusPercentage = 0;
	    }

	    double bonusAmount =
	            employee.getMonthlySalary() * bonusPercentage / 100;

	    double salaryAfterBonus =
	            employee.getMonthlySalary() + bonusAmount;

	    Map<String, Object> result = new HashMap<>();

	    result.put("employeeId", employee.getE_id());
	    result.put("employeeName", employee.getE_name());
	    result.put("monthlySalary", employee.getMonthlySalary());
	    result.put("performanceScore", employee.getPerformanceScore());
	    result.put("bonusPercentage", bonusPercentage);
	    result.put("bonusAmount", bonusAmount);
	    result.put("salaryAfterBonus", salaryAfterBonus);

	    return result;
	}

	
	// API 4 - Department Performance Summary
	public Map<String, Object> departmentSummary(String department) {

	    List<Employee> employees = employeerepo.findByDepartment(department);

	    int totalEmployees = employees.size();

	    int activeEmployees = 0;

	    double totalMonthlySalary = 0;

	    double totalPerformanceScore = 0;

	    Employee highestPaidEmployee = employees.get(0);

	    Employee bestPerformingEmployee = employees.get(0);

	    for (Employee employee : employees) {

	        // Count Active employees
	        if (employee.getStatus().equalsIgnoreCase("Active")) {

	            activeEmployees++;
	        }

	        // Total salary
	        totalMonthlySalary =
	                totalMonthlySalary + employee.getMonthlySalary();

	        // Total performance score
	        totalPerformanceScore =
	                totalPerformanceScore + employee.getPerformanceScore();

	        // Highest paid employee
	        if (employee.getMonthlySalary()
	                > highestPaidEmployee.getMonthlySalary()) {

	            highestPaidEmployee = employee;
	        }

	        // Best performing employee
	        if (employee.getPerformanceScore()
	                > bestPerformingEmployee.getPerformanceScore()) {

	            bestPerformingEmployee = employee;
	        }
	    }

	    double averageSalary =
	            totalMonthlySalary / totalEmployees;

	    double averagePerformanceScore =
	            totalPerformanceScore / totalEmployees;

	    Map<String, Object> result = new HashMap<>();

	    result.put("department", department);
	    result.put("totalEmployees", totalEmployees);
	    result.put("activeEmployees", activeEmployees);
	    result.put("totalMonthlySalary", totalMonthlySalary);
	    result.put("averageSalary", averageSalary);
	    result.put("averagePerformanceScore", averagePerformanceScore);
	    result.put("highestPaidEmployee",
	            highestPaidEmployee.getE_name());
	    result.put("bestPerformingEmployee",
	            bestPerformingEmployee.getE_name());

	    return result;
	}

}
