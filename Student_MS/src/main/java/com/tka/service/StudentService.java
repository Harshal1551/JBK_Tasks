package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.entity.Student;
import com.tka.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepo;
	
	// 1. User Login
	public String login(String username, String password) {

	    Student student = studentrepo.findByUsernameAndPassword(username, password);

	    if (student != null) {
	        return "Login successful";
	    }

	    return "Please register first";
	}

	// 2. Register Student
	public Student registerStudent(Student student) {
		return studentrepo.save(student);
	}

	// 3. Get Student By ID
	public Student studentById(int id) {
		return studentrepo.findById(id).get();
	}

	// 4. Get All Students
	public List<Student> allStudents() {
		
		return studentrepo.findAll();
	}
	

	// 5. Get Student By Full Name
	public List<Student> studentByFullName(String fullname) {
		
		return studentrepo.findByFullname(fullname);
	}

	// 6. Update Student
	public Student updateStudent(Student student) {

	    Student oldStudent = studentrepo.findById(student.getId()).get();

	    oldStudent.setFullname(student.getFullname());
	    oldStudent.setCourse(student.getCourse());
	    oldStudent.setCity(student.getCity());
	    oldStudent.setPercentage(student.getPercentage());
	    oldStudent.setUsername(student.getUsername());
	    oldStudent.setPassword(student.getPassword());

	    return studentrepo.save(oldStudent);
	}

	// 7. Delete Student
	public String deleteStudent(int id) {

	    studentrepo.deleteById(id);

	    return "Student deleted successfully";
	}

	// 8. Get Students By Course
	public List<Student> studentByCourse(String course) {
		
		return studentrepo.findByCourse(course);
	}

	
	// 9. Get Topper Student
	public Student topperStudent() {
		// TODO Auto-generated method stub
		return studentrepo.findTopByOrderByPercentageDesc();
	}

	// 10. Get Second Topper Student
	public Student secondTopperStudent() {

	    List<Student> students = studentrepo.findTop2ByOrderByPercentageDesc();

	    return students.get(1);
	}

	
	
}
