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

import com.tka.entity.Staff;
import com.tka.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffservice;

	// 1. Open Login Page
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	
	// Login

	@PostMapping("/login")
	public String login(
	        @RequestParam String username,
	        @RequestParam String password,
	        Model model) {

	    String result =
	            staffservice.login(username, password);


	    if (result.equals("LOGIN_SUCCESS")) {

	        return "redirect:/home";
	    }


	    if (result.equals("USER_NOT_FOUND")) {

	        model.addAttribute(
	                "error",
	                "User does not exist. Please register.");

	        return "login";
	    }


	    model.addAttribute(
	            "error",
	            "Invalid username or password");

	    return "login";
	}

	// 3. Home Page
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}

	// 3. Open Register Staff Page

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("staff", new Staff());
		return "registerStaff";
	}
	
	// 4. Register Staff

	@PostMapping("/register-staff")
	public String registerStaff(
	        @ModelAttribute Staff staff,
	        Model model) {

	    String message = staffservice.registerStaff(staff);

	    model.addAttribute("message", message);

	    if (message.equals("Staff registered successfully")) {

	        model.addAttribute("staff", new Staff());

	    } else {

	        model.addAttribute("staff", staff);

	    }

	    return "registerStaff";
	}

	// 4. Open View Staff Page

	@GetMapping("/view-staff")
	public String viewStaffPage() {

		return "viewStaff";
	}
	
	// Search Staff By ID

	@PostMapping("/search-staff")
	public String searchStaff(
	        @RequestParam String staffid,
	        Model model) {

	    Staff staff = staffservice.viewStaff(staffid);

	    if (staff != null) {

	        model.addAttribute("staff", staff);

	    } else {

	        model.addAttribute(
	                "error",
	                "Staff not found");

	    }

	    return "viewStaff";
	}

	// 5. Open View All Staff Page

	@GetMapping("/view-all-staff")
	public String viewAllStaff(Model model) {

	    List<Staff> staffList =
	            staffservice.viewAllStaff();

	    model.addAttribute("staffList", staffList);

	    return "viewAllStaff";
	}


	// Open Update Staff Page

	@GetMapping("/update-staff/{staffid}")
	public String updateStaffPage(
	        @PathVariable String staffid,
	        Model model) {

	    Staff staff = staffservice.viewStaff(staffid);

	    if (staff != null) {

	        model.addAttribute("staff", staff);

	        return "updateStaff";

	    }

	    model.addAttribute(
	            "error",
	            "Staff not found");

	    return "viewStaff";
	}
	
	// Update Staff

	@PostMapping("/update-staff")
	public String updateStaff(
	        @ModelAttribute Staff staff,
	        Model model) {

	    String message =
	            staffservice.updateStaff(staff);

	    model.addAttribute("message", message);

	    if (message.equals("Staff updated successfully")) {

	        Staff updatedStaff =
	                staffservice.viewStaff(staff.getStaffid());

	        model.addAttribute("staff", updatedStaff);

	    } else {

	        model.addAttribute("staff", staff);

	    }

	    return "updateStaff";
	}
	
	
	// Delete Staff

	@PostMapping("/delete-staff")
	public String deleteStaff(
	        @RequestParam String staffid,
	        Model model) {

	    String message =
	            staffservice.deleteStaff(staffid);

	    model.addAttribute("message", message);

	    List<Staff> staffList =
	            staffservice.viewAllStaff();

	    model.addAttribute("staffList", staffList);

	    return "viewAllStaff";
	}

}
