
package com.studentmanagement.core.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.studentmanagement.core.model.User;

import com.studentmanagement.core.repository.StudentRepository;

import com.studentmanagement.core.repository.service.UserService;
import com.studentmanagement.core.utils.VerifyRecaptcha;

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
	public String postLogin(@ModelAttribute User user,Model model,HttpSession session,@RequestParam("g-recaptcha-response") String recaptchaCode) throws IOException {
		if(VerifyRecaptcha.verify(recaptchaCode)) {
			
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr=userService.userLogin(user.getUsername(),user.getPassword());
		
		if(usr!=null) {
			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(200);
			
			return "Home";
		}else {
			model.addAttribute("message","invalid username!");
			return "Login";	
		}
		}
		model.addAttribute("message","Are you Robot!");
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

	
}