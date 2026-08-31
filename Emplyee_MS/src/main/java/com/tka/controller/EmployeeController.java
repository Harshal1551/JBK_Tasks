package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tka.entity.Employee_MS;
import com.tka.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// =====================================================
	// HOME PAGE
	// =====================================================

	@GetMapping("/")
	public String homePage(Model model) {

		// Total employees
		long totalEmployees = employeeService.getTotalEmployees();

		// IT employees
		long itEmployees = employeeService.getEmployeesByDepartmentCount("IT");

		// Average salary
		Double averageSalary = employeeService.getAverageSalary();

		// Employees with salary > 50,000
		List<Employee_MS> highSalaryEmployees = employeeService.getEmployeesBySalaryMoreThan50000();

		// Send data to index.html

		model.addAttribute("totalEmployees", totalEmployees);

		model.addAttribute("itEmployees", itEmployees);

		model.addAttribute("averageSalary", averageSalary);

		model.addAttribute("highSalaryEmployees", highSalaryEmployees);

		return "index";
	}

	// =====================================================
	// ADD EMPLOYEE PAGE
	// =====================================================

	@GetMapping("/employees/add")
	public String addEmployeePage(Model model) {

		model.addAttribute("employee", new Employee_MS());

		return "add-employee";
	}

	// =====================================================
	// SAVE EMPLOYEE
	// =====================================================

	@PostMapping("/employees/save")
	public String saveEmployee(Employee_MS employee, RedirectAttributes redirectAttributes) {

		try {

			employeeService.addEmployee(employee);

			redirectAttributes.addFlashAttribute("successMessage", "Employee added successfully!");

			return "redirect:/employees";

		} catch (RuntimeException e) {

			redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());

			return "redirect:/employees/add";
		}
	}

	// =====================================================
	// EMPLOYEE LIST
	// =====================================================

	@GetMapping("/employees")
	public String employeeList(Model model) {

		List<Employee_MS> employees = employeeService.getAllEmployees();

		model.addAttribute("employees", employees);

		return "employee-list";
	}

	// =====================================================
	// SEARCH PAGE
	// =====================================================

	@GetMapping("/employees/search")
	public String searchPage() {

		return "search-employee";
	}

	// =====================================================
	// SEARCH BY ID
	// =====================================================

	@GetMapping("/employees/search/id")
	public String searchById(@RequestParam int id, Model model) {

		Employee_MS employee = employeeService.getEmployeeById(id);

		model.addAttribute("employee", employee);

		if (employee == null) {

			model.addAttribute("errorMessage", "Employee not found with ID: " + id);
		}

		return "search-employee";
	}

	// =====================================================
	// SEARCH BY NAME
	// =====================================================

	@GetMapping("/employees/search/name")
	public String searchByName(@RequestParam String name, Model model) {

		List<Employee_MS> employees = employeeService.searchByName(name);

		model.addAttribute("employees", employees);

		if (employees.isEmpty()) {

			model.addAttribute("errorMessage", "No employee found with name: " + name);
		}

		return "search-employee";
	}

	// =====================================================
	// SEARCH BY DEPARTMENT
	// =====================================================

	@GetMapping("/employees/search/department")
	public String searchByDepartment(@RequestParam String department, Model model) {

		List<Employee_MS> employees = employeeService.searchByDepartment(department);

		model.addAttribute("employees", employees);

		if (employees.isEmpty()) {

			model.addAttribute("errorMessage", "No employees found in department: " + department);
		}

		return "search-employee";
	}

	// =====================================================
	// SALARY > 50,000
	// =====================================================

	@GetMapping("/employees/high-salary")
	public String highSalaryEmployees(Model model) {

		List<Employee_MS> employees = employeeService.getEmployeesBySalaryMoreThan50000();

		model.addAttribute("employees", employees);

		return "employee-list";
	}

	// =====================================================
	// EDIT EMPLOYEE PAGE
	// =====================================================

	@GetMapping("/employees/edit/{id}")
	public String editEmployee(@PathVariable int id, Model model) {

		Employee_MS employee = employeeService.getEmployeeById(id);

		if (employee == null) {

			return "redirect:/employees";
		}

		model.addAttribute("employee", employee);

		return "edit-employee";
	}

	// =====================================================
	// UPDATE EMPLOYEE
	// =====================================================

	@PostMapping("/employees/update")
	public String updateEmployee(Employee_MS employee, Model model, RedirectAttributes redirectAttributes) {

		try {

			employeeService.updateEmployee(employee);

			redirectAttributes.addFlashAttribute("successMessage", "Employee updated successfully!");

			return "redirect:/employees";

		} catch (RuntimeException e) {

			model.addAttribute("employee", employee);

			model.addAttribute("errorMessage", e.getMessage());

			return "edit-employee";
		}
	}

	// =====================================================
	// DELETE EMPLOYEE
	// =====================================================

	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttributes) {

		try {

			employeeService.deleteEmployee(id);

			redirectAttributes.addFlashAttribute("successMessage", "Employee deleted successfully!");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("errorMessage", "Error while deleting employee.");
		}

		return "redirect:/employees";
	}

}