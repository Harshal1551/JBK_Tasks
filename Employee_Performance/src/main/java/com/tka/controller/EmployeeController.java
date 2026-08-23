package com.tka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Employee;
import com.tka.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeservice;
	
	// API 1 - Add Employee
    @PostMapping
    public Map<String, Object> addEmployee(@RequestBody Employee employee) {

        return employeeservice.addEmployee(employee);
    }
    
 // API 2 - Get Employees By Department
    @GetMapping("/department/{department}")
    public List<Map<String, Object>> employeesByDepartment(
            @PathVariable String department) {

        return employeeservice.employeesByDepartment(department);
    }
    
    
 // API 3 - Calculate Employee Performance Bonus
    @GetMapping("/{employeeId}/bonus")
    public Map<String, Object> employeeBonus(
            @PathVariable int employeeId) {

        return employeeservice.employeeBonus(employeeId);
    }
    
 // API 4 - Department Performance Summary
    @GetMapping("/summary/{department}")
    public Map<String, Object> departmentSummary(
            @PathVariable String department) {

        return employeeservice.departmentSummary(department);
    }

}
