package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Profile;
import com.tka.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profileproject/search/name/{fname}")
	public Profile searchByName(@PathVariable String fname) {
		
		return profileService.searchByName(fname); 
	}
	
	@PostMapping("/profileproject/add")
	public Profile addProfile(@RequestBody Profile profile) {
	  
		return profileService.addProfile(profile);
	}
	
	

	@PutMapping("/profileproject/update")  
	public Profile updateProfile(
	        @RequestBody Profile profile) {

	    return profileService.updateProfile(profile);

	}
	
	
	@DeleteMapping("/profileproject/delete/{fname}")
	public String deleteProfile(@PathVariable String fname) {

	    return profileService.deleteProfile(fname);
	}
	
	@GetMapping("/profileproject/sort/fname")
	public List<Profile> sortByFname() {

	    return profileService.sortByFname();

	}
	
	@GetMapping("/profileproject/search/city/{city}")
	public List<Profile> getAllByCity(
	        @PathVariable String city) {

	    return profileService.getAllByCity(city);

	}
	
	
	
	
}
