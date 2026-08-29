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
public class Voter {

	@Id
	private String voterId;
	
	private String name;
	private int age;
	private String gender;
	private String email;
	private String mobile;
	private String address;
	private String username;
	private String password;
	
	
}
