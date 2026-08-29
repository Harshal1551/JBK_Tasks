package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.entity.Voter;
import com.tka.service.VoterService;

@Controller
public class VoterController {

	@Autowired
	private VoterService voterservice;

	// 1. Open Login Page
	@GetMapping("/")
	public String loginPage() {

		return "login";
	}

	// 2. Login
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {

		Voter voter = voterservice.login(username, password);

		if (voter != null) {

			return "redirect:/home";

		} else {

			model.addAttribute("error", "Invalid username or password");

			return "login";
		}
	}

	// 3. Home Page
	@GetMapping("/home")
	public String homePage() {

		return "home";
	}

	// 4. Open Register Voter Page
	@GetMapping("/register")
	public String registerPage(Model model) {

		model.addAttribute("voter", new Voter());

		return "registerVoter";
	}

	// 5. Register Voter
	@PostMapping("/register-voter")
	public String registerVoter(@ModelAttribute Voter voter, Model model) {

		voterservice.registerVoter(voter);

		model.addAttribute("message", "Voter registered successfully");

		model.addAttribute("voter", voter);

		return "registerVoter";
	}

	// 6. Open View Voter Page
	@GetMapping("/view-voter")
	public String viewVoterPage() {

		return "viewVoter";
	}

	// 7. Search Voter By ID
	@PostMapping("/search-voter")
	public String searchVoter(@RequestParam String voterId, Model model) {

		Voter voter = voterservice.viewVoter(voterId);

		if (voter != null) {

			model.addAttribute("voter", voter);

		} else {

			model.addAttribute("error", "Voter not found");
		}

		return "viewVoter";
	}

	// 8. View All Voters
	@GetMapping("/view-all-voters")
	public String viewAllVoters(Model model) {

		List<Voter> voters = voterservice.viewAllVoters();

		model.addAttribute("voters", voters);

		return "viewAllVoters";
	}

	// 9. Open Update Voter Page
	@GetMapping("/update-voter/{voterId}")
	public String updateVoterPage(@PathVariable String voterId, Model model) {

		Voter voter = voterservice.viewVoter(voterId);

		if (voter != null) {

			model.addAttribute("voter", voter);

		} else {

			model.addAttribute("error", "Voter not found");

		}

		return "updateVoter";
	}
	
	

	// 10. Update Voter
	@PostMapping("/update-voter")
	public String updateVoter(@ModelAttribute Voter voter, Model model) {

		voterservice.updateVoter(voter);

		model.addAttribute("message", "Voter updated successfully");

		return "updateVoter";
	}

	// 11. Delete Voter
	@GetMapping("/delete-voter")
	public String deleteVoterPage() {

		return "viewVoter";
	}

	@PostMapping("/delete-voter")
	public String deleteVoter(@RequestParam String voterId, Model model) {

		String message = voterservice.deleteVoter(voterId);

		model.addAttribute("message", message);

		return "viewVoter";
	}

}
