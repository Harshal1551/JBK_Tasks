package com.tka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String>{

	Staff findByUsernameAndPassword(String username, String password);
	
	Staff findByUsername(String username);

	
}
