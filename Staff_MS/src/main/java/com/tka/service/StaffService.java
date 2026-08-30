package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.Staff;
import com.tka.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffrepo;

	// Login

	public String login(String username, String password) {

	    Staff staff = staffrepo.findByUsername(username);

	    if (staff == null) {

	        return "USER_NOT_FOUND";
	    }

	    if (staff.getPassword().equals(password)) {

	        return "LOGIN_SUCCESS";
	    }

	    return "INVALID_PASSWORD";
	}

	// Register Staff

	public String registerStaff(Staff staff) {
		if (staffrepo.existsById(staff.getStaffid())) {
			return "Staff ID already exists";
		}
		staffrepo.save(staff);
		return "Staff registered successfully";
	}

	// View Staff By ID

	public Staff viewStaff(String staffid) {

		return staffrepo.findById(staffid).orElse(null);

	}

	// View All Staff

	public List<Staff> viewAllStaff() {

	    return staffrepo.findAll();

	}
	
	// Update Staff

	public String updateStaff(Staff staff) {

	    if (staffrepo.existsById(staff.getStaffid())) {

	        staffrepo.save(staff);

	        return "Staff updated successfully";

	    }

	    return "Staff not found";
	}
	
	// Delete Staff

	public String deleteStaff(String staffid) {

	    if (staffrepo.existsById(staffid)) {

	        staffrepo.deleteById(staffid);

	        return "Staff deleted successfully";

	    }

	    return "Staff not found";
	}
	
	
	
}