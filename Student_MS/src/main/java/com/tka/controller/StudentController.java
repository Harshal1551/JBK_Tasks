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

import com.tka.entity.Student;
import com.tka.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;

	// 1. User Login
	@GetMapping("/login/{username}/{password}")
	public String login(@PathVariable String username, @PathVariable String password) {
		return studentservice.login(username, password);
	}
	
	// 2. Register Student
	@PostMapping("/register-student")
	public Student registerStudent(@RequestBody Student student) {
		return studentservice.registerStudent(student);
	}
	
	// 3. Get Student By ID
	@GetMapping("/student/{id}")
	public Student studentById(@PathVariable int id) {
		return studentservice.studentById(id);
	}
	
	 // 4. Get All Students
	@GetMapping("/all-students")
	public List<Student> allStudents(){
		return studentservice.allStudents();	
	}
	
	// 5. Get Student By Full Name
	@GetMapping("student-name/{fullname}")
	public List<Student> studentByFullName(@PathVariable String fullname){
		return studentservice.studentByFullName(fullname);
	}
	
	 // 6. Update Student
	@PutMapping("/update-student")
	public Student updateStudent(@RequestBody Student student) {
		return studentservice.updateStudent(student);
		
	}
	
	// 7. Delete Student
	@DeleteMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentservice.deleteStudent(id);
	}
	
	// 8. Get Students By Course
	@GetMapping("/course/{course}")
	public List<Student> studentByCourse(@PathVariable String course){
		return studentservice.studentByCourse(course);
	}
	
	 // 9. Get Topper Student
	@GetMapping("/topper")
	public Student topperStudent() {
		return studentservice.topperStudent();
	}
	
	// 10. Get Second Topper Student
	@GetMapping("/second-topper")
	public Student secondTopperStudent() {
		return studentservice.secondTopperStudent();
	}
	
		
}
