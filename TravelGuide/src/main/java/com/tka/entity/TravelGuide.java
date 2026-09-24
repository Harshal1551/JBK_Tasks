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
public class TravelGuide {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int destinationId;
	
	private String name;
	private String country;
	private String city;
	private String category;
	private int pricePerDay;
	private float rating;
	private boolean available;

}
