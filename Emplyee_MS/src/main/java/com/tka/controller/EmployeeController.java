package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Employee_MS;
import com.tka.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Add Employee
    @PostMapping("/add-employee")
    public Employee_MS addEmployee(@RequestBody Employee_MS employee) {
        return employeeService.addEmployee(employee);
    }

    // Get Employee By ID
    @GetMapping("/get-employee/{id}")
    public Employee_MS getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/update-employee")
    public Employee_MS updateEmployee(@RequestBody Employee_MS employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete Employee
    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    // Get All Employees
    @GetMapping("/get-all-employees")
    public List<Employee_MS> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employees By Role
    @GetMapping("/get-employees-by-role/{roleName}")
    public List<Employee_MS> getEmployeesByRole(@PathVariable String roleName) {
        return employeeService.getEmployeesByRole(roleName);
    }

    // Get Employees By Salary More Than
    @GetMapping("/get-employees-by-salary/{salAmt}")
    public List<Employee_MS> getEmployeesBySalaryMoreThan(@PathVariable double salAmt) {
        return employeeService.getEmployeesBySalaryMoreThan(salAmt);
    }
}