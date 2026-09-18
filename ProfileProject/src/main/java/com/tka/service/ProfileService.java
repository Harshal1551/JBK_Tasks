package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tka.entity.Profile;
import com.tka.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
    private ProfileRepository profilerepo;

	public Profile searchByName(String fname) {
		
		return profilerepo.findByFname(fname);
	}

	public Profile addProfile(Profile profile) {
		
		return profilerepo.save(profile);
	}

	public Profile updateProfile(Profile profile) {

        if (profilerepo.existsById(profile.getFname())) {

            return profilerepo.save(profile);

        }

        return null;
    }
	
	

	public String deleteProfile(String fname) {

	    if (profilerepo.existsById(fname)) {

	    	profilerepo.deleteById(fname);

	        return "Profile deleted successfully";
	    }

	    return "Profile not found";
	}
	
	
	public List<Profile> sortByFname() {

	    return profilerepo.findAll(
	            Sort.by("fname").ascending());

	}

	public List<Profile> getAllByCity(String city) {
		
		return profilerepo.findAllByCity(city);
	}
	
	
	

	

}
