package com.tka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tka.entity.Employee_MS;

public interface EmployeeRepository extends JpaRepository<Employee_MS, Integer> {

    // Check whether email already exists
    boolean existsByEmail(String email);

    // Check duplicate email during UPDATE
    boolean existsByEmailAndEmployeeIdNot(
            String email,
            int employeeId);

    // Search employees by name
    List<Employee_MS> findByNameContainingIgnoreCase(String name);

    // Search employees by department
    List<Employee_MS> findByDepartmentIgnoreCase(String department);

    // Count employees by department
    long countByDepartmentIgnoreCase(String department);

    // Employees having salary greater than given amount
    List<Employee_MS> findBySalaryGreaterThan(double salary);

    // Calculate average salary
    @Query("SELECT AVG(e.salary) FROM Employee_MS e")
    Double findAverageSalary();
}