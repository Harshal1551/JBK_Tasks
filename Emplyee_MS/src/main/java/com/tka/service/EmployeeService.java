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

    // Add Employee
    public Employee_MS addEmployee(Employee_MS employee) {
        return employeeRepository.save(employee);
    }

    // Get Employee By ID
    public Employee_MS getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Update Employee
    public Employee_MS updateEmployee(Employee_MS employee) {
        return employeeRepository.save(employee);
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    // Get All Employees
    public List<Employee_MS> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By Role
    public List<Employee_MS> getEmployeesByRole(String roleName) {
        return employeeRepository.findByRole(roleName);
    }

    // Get Employee By Salary
    public List<Employee_MS> getEmployeesBySalaryMoreThan(double salAmt) {
        return employeeRepository.findBySalaryGreaterThan(salAmt);
    }
}