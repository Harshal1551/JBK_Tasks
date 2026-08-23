package com.tka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	
	private String e_name;
	private String department;
    private double monthlySalary;
    private int experienceYears;
    private double performanceScore;
    private String status;
	
}
