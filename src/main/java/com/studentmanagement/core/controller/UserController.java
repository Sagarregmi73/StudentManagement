package com.studentmanagement.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.repository.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute Student student,Model model,HttpSession session) {
		
		student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
		Student stu=userService.userLogin(student.getUsername(),student.getPassword());
		if(stu!=null) {
			session.setAttribute("activeuser", stu);
			session.setMaxInactiveInterval(200);
			return "Home";
		}
		model.addAttribute("message","invalid username!");
		return "Login";
	}
	@GetMapping("/signup")
	public String getSignup() {
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute Student student) {
		
		student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
		userService.userSignup(student);
		return "Login";
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	//usercontroller has updated
}
