package com.studentmanagement.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.model.User;
import com.studentmanagement.core.repository.service.StudentService;
import com.studentmanagement.core.repository.service.UserService;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@GetMapping("/home")
public String getHome(HttpSession session,Model model) {
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
public String getProfile(@RequestParam int id,HttpSession session,Model model) {
	if(session.getAttribute("activeuser")== null ) {
		
		return "index";
	}
	//model.addAttribute("stuDetails", studentService.getStudentById(id));
	model.addAttribute("userObjList", userService.getUserById(id));
	
	return "Profile";
}
	@GetMapping("/applyApplication")
public String getApplyApplication(HttpSession session) {
	if(session.getAttribute("activeuser")== null ) {
		return "index";
	}
	return "applyApplication";
}
	
	

	
}
