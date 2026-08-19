package com.tka.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tka.entity.Employee_MS;

public interface EmployeeRepository extends JpaRepository<Employee_MS, Integer> {

    List<Employee_MS> findByRole(String role);
    List<Employee_MS> findBySalaryGreaterThan(double salary);
    
}