package com.tka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tka.entity.Voter;
import com.tka.repository.VoterRepository;

@Service
public class VoterService {

	private final VoterRepository voterrepo;

	VoterService(VoterRepository voterrepo) {
		this.voterrepo = voterrepo;
	}

	// 1. Login
	public Voter login(String username, String password) {

		Voter voter = voterrepo.findByUsernameAndPassword(username, password);

		return voter;
	}

	// 2. Register Voter
	public Voter registerVoter(Voter voter) {

		return voterrepo.save(voter);
	}

	// 3. View Voter By ID
	public Voter viewVoter(String voterId) {

		return voterrepo.findById(voterId).orElse(null);
	}

	// 4. View All Voters
	public List<Voter> viewAllVoters() {

		return voterrepo.findAll();
	}

	// 5. Update Voter
	public Voter updateVoter(Voter voter) {

		return voterrepo.save(voter);
	}

	// 6. Delete Voter
	public String deleteVoter(String voterId) {

		voterrepo.deleteById(voterId);

		return "Voter deleted successfully";
	}

}
