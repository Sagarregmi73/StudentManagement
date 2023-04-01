package com.studentmanagement.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.core.repository.UserRepository;
import com.studentmanagement.core.utils.EmailUtils;

@Controller
public class ForgetPasswordController {
	@Autowired
	private EmailUtils emailUtil;
	@Autowired
	private UserRepository userRepo;
	@GetMapping("/reset")
public String getResetForm() {
		
	return "resetForm";
}
	@PostMapping("/reset")
	public String postResetForm(@RequestParam String emailId,Model model) {
		model.addAttribute("message", "succesfully sent mail!");
		emailUtil.sendEmail(emailId);
		return "resetForm";
		
	}	
	
	@GetMapping("/reset_password")
	public String getResetPassword() {
		return "ForgetPassword";
	}

	@PostMapping("/reset_password")
	public String postResetPassword(@RequestParam String username, @RequestParam String password,Model model) {
		
		if (userRepo.findByUsername(username) != null) {
			model.addAttribute("message", "successfully updated password");
			password = DigestUtils.md5DigestAsHex(password.getBytes());
			userRepo.setNewPassword(username, password);
			return "Login";
		}
		model.addAttribute("message", "something went wrong");
		return "ForgetPassword";
	}
}
		


