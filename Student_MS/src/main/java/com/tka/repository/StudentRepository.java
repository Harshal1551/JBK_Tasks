package com.tka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// 1. Login
	Student findByUsernameAndPassword(String username, String password);

	// 5. Student By Full Name
	List<Student> findByFullname(String fullname);

	// 8. Students By Course
	List<Student> findByCourse(String course);

	// 9. Topper Student
	Student findTopByOrderByPercentageDesc();
	
	// 10. Second Topper
    List<Student> findTop2ByOrderByPercentageDesc();
    

}
