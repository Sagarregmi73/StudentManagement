
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

import com.studentmanagement.core.model.Student;
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
	public String postSignup(@ModelAttribute User user,@ModelAttribute Student student, Model model,MultipartFile image) {
	student.getUser().setImageProfile(image.getOriginalFilename());
		   //user.setImageProfile(image.getOriginalFilename());
//student.setUser(user);
student.getUser().setPassword(DigestUtils.md5DigestAsHex(student.getUser().getPassword().getBytes()));
//user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
//	
//			userService.userSignup(user);
			studentRepo.save(student);
		
			
			
			if(!image.isEmpty()) {
//				//image size validation
//				if(image.getSize()>=2097152) {
//					model.addAttribute("message","File size is to large.Max size is 2MB");
//					return "UploadForm";
//				}
				try {
					Files.copy(image.getInputStream(),Path.of("src/main/resources/static/image/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING );
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return "Login";
			
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	
	
	
	
}