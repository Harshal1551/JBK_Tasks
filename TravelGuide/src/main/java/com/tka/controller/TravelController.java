package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.TravelGuide;
import com.tka.service.TravelService;

@RestController
public class TravelController {
	
	@Autowired
	private TravelService travelService;
	
	
	@PostMapping("/travel/add-destination")
	public TravelGuide addDestination(@RequestBody TravelGuide destination) {
		return travelService.addDestination(destination);
		
	}
	
	@GetMapping("/travel/destination/{id}")
	public TravelGuide getDestinationById(@PathVariable int id) {
		return travelService.getDestinationById(id);
		
	}
	
	@GetMapping("travel/all-destination")
	public List<TravelGuide> getAllDestinations() {
		return travelService.getAllDestinations();
	}
	
	@PutMapping("travel/update-destination")
	public TravelGuide updateDestination(@RequestBody TravelGuide destination) {
		return travelService.updateDestination(destination);
		
	}
	
	

}
