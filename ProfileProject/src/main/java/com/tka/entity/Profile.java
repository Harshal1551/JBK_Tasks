package com.tka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Profile {
	
	@Id
    private String fname;
	
    private String lname;
    private String phone;
    private String city;
    private String address;
	

}
