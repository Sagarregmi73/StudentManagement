package com.studentmanagement.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	@GetMapping("/controller/login/admin")
	public String getAdminLogin() {

		return "AdminLogin";
	}

	@PostMapping("/controller/login/admin")
	public String postAdminLogin(@RequestParam String admin, @RequestParam String password, Model model,
			HttpSession session) {
		

			if (admin.matches("sagar007") && password.matches("980058")) {
				
				session.setAttribute("adminlogin", "logedin");
				session.setMaxInactiveInterval(200);
				return "AdminDashboard";
				
			}
			
				model.addAttribute("message", "invalid User");
				return "AdminLogin";
	}

		


	@GetMapping("/controller/login/admin/profile")
	public String getAdminProfile(HttpSession session) {
		if (session.getAttribute("adminlogin") == null) {
			return "AdminLogin";
		}
		return "AdminProfile";
	}
	


}
