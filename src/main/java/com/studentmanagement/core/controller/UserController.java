package com.studentmanagement.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
	@GetMapping("/signup")
	public String getSignup() {
		return "signup";
	}
}
