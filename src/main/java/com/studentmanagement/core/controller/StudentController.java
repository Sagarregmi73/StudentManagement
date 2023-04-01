package com.studentmanagement.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.repository.service.StudentService;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/home")
public String getHome(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "Home";
}
	@GetMapping("/blog")
public String getBlog(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "Blog";
}
	@GetMapping("/notification")
public String getNotification(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "Notification";
}
	@GetMapping("/fees")
public String getFees(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "Fees";
}
	@GetMapping("/profile")
public String getProfile(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "Profile";
}
	@GetMapping("/applyApplication")
public String getApplyApplication(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "applyApplication";
}
	@GetMapping("/addStudentDetail")
public String getaddStudentDetail(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "AddStudentDetail";
}
	
	@PostMapping("/addStudentDetail")
	public String postaddStudentDetail(@ModelAttribute Student student,HttpSession session) {
		Student stu=studentService.getStudentDetails();
if(stu!=null) {
			
			session.setAttribute("activestudent", stu);
			session.setMaxInactiveInterval(200);
			
			//model.addAttribute("uname",usr.getFname());
			return "index";
		}
		studentService.addStudentDetail(student);
		return "AddStudentDetail";
	}
	
}
