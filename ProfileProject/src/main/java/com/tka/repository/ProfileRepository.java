package com.tka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, String> {

	Profile findByFname(String fname);

	List<Profile> findAllByCity(String city); 
	
	

	
}
