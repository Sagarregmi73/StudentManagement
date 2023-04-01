package com.studentmanagement.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
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
	
}
