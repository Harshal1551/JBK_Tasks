package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.TravelGuide;
import com.tka.repository.TravelRepository;

@Service
public class TravelService {
	
	@Autowired
	private TravelRepository travelRepo;

	public TravelGuide addDestination(TravelGuide destination) {
		
		return travelRepo.save(destination);
	}

	public TravelGuide getDestinationById(int id) {

		return travelRepo.findById(id).orElse(null);
	}

	public List<TravelGuide> getAllDestinations() {
		
		return travelRepo.findAll();
	}

	public TravelGuide updateDestination(TravelGuide destination) {
		
		if(travelRepo.existsById(destination.getDestinationId())) {
			return travelRepo.save(destination);
		}
		
		return null;
	}
	
	
	

	
	
	
}
