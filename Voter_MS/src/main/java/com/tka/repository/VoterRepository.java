package com.tka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, String>{
	
	Voter findByUsernameAndPassword(String username, String password);

}
