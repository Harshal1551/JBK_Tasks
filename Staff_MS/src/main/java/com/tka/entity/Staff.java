package com.tka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Staff {

	@Id
	private String staffid;

	private String name;
	private int age;
	private String email;
	private String department;
	private double salary;
	private String mobile;
	private String username;
	private String password;

}
