package com.studentmanagement.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.core.model.User;
import com.studentmanagement.core.repository.StudentRepository;

import com.studentmanagement.core.repository.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private StudentRepository studentRepo;
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user,Model model,HttpSession session) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr=userService.userLogin(user.getUsername(),user.getPassword());
		
		if(usr!=null) {
			session.setAttribute("activeuser", usr);
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
	public String postSignup(@ModelAttribute User user , Model model) {
		
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			userService.userSignup(user);
			
			return "Login";
			
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	//usercontroller has updated
}
