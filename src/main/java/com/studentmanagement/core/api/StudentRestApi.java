package com.studentmanagement.core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.repository.service.StudentService;

@RestController
public class StudentRestApi {
	@Autowired
private StudentService studentService;
	@PostMapping("/api/student/add")
	public String addStudent(@RequestBody Student student) {
		studentService.addStudentDetail(student);
		return "added success";
	}
	
	@GetMapping("/api/student/list")
	public List<Student> getAllStudent(){
		
		return studentService.getStudentDetails();
	}
	
	@DeleteMapping("/api/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentDetail(id);
		return "deleted success";
	}
	
	@PutMapping("/api/student/update")
	public String updateStudent(@RequestBody Student student) {
		studentService.updateStudentDetail(student);
		return "updated success";
	}
	
	@GetMapping("/api/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
		
	}
	

}
