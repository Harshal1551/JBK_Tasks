package com.tka.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee_MS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int eid;
	
    private String name;
    private String role;
    private LocalDate doj;
    private double salary;
}
	

