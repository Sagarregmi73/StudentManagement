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

import com.studentmanagement.core.repository.StudentRepository;
import com.studentmanagement.core.repository.UserRepository;
import com.studentmanagement.core.repository.service.MessageFeedbackService;
import com.studentmanagement.core.repository.service.StudentService;
import com.studentmanagement.core.repository.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MessageFeedbackService messageService;

	@GetMapping("/controller/login/admin")
	public String getAdminLogin(HttpSession session) {
		if (session.getAttribute("adminlogin") == null) {
			return "AdminLogin";
		}
		return "AdminDashboard";
	}

	@PostMapping("/controller/login/admin")
	public String postAdminLogin(@RequestParam String admin, @RequestParam String password, Model model,
			HttpSession session) {
		

			if (admin.matches("sagar007") && password.matches("980058")) {
				
				session.setAttribute("adminlogin", "sagar007");
				session.setMaxInactiveInterval(200);
				return "AdminDashboard";
				
			}
			
				model.addAttribute("message", "invalid User");
				return "AdminLogin";
	}


	@GetMapping("/controller/admin/profile")
	public String getAdminProfile(HttpSession session) {
		if (session.getAttribute("adminlogin") == null) {
			return "AdminLogin";
		}
		return "AdminProfile";
	}
	
	@GetMapping("/controller/admin/addStudentDetail")
	public String getaddStudentDetail(HttpSession session) {
		if(session.getAttribute("adminlogin")== null ) {
			return "AdminLogin";
		}
		return "AddStudentDetail";
	}
	@PostMapping("/addStudentDetail")
	public String postaddStudentDetail(@ModelAttribute Student student,HttpSession session) {
		if(session.getAttribute("adminlogin")== null ) {
			return "AdminLogin";
		}
		
		studentService.addStudentDetail(student);
	
		return "AddStudentDetail";
	}
	@GetMapping("/controller/admin/studentDetail")
	public String getStudentDetail(HttpSession session,Model model) {
		if(session.getAttribute("adminlogin")== null ) {
			return "AdminLogin";
		}
		model.addAttribute("userlist",userService.getUser() );
	
		return "studentDetail";
	}
	
	@PostMapping("/controller/admin/updateStudentDetail")
	public String updateStudentDetail(@ModelAttribute Student student,HttpSession session,Model model) {
		if(session.getAttribute("adminlogin")== null ) {
			return "AdminLogin";
		}
		//studentService.updateStudentDetail(student);
		studentRepo.save(student);
	//	model.addAttribute("message", "updated succesfully");
		return "redirect:/controller/admin/studentDetail";
	}
	@GetMapping("/controller/admin/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session) {
		if(session.getAttribute("adminlogin")==null) {
			return "AdminLogin";
		}
		
		
		studentService.deleteStudentDetail(id);
	//	messageService.deleteMessageFeedback(id);
		
		return "redirect:/controller/admin/studentDetail";
	}
	
	@GetMapping("/controller/admin/edit")
	public String editEmp(@RequestParam int id,HttpSession session,Model model) {
		if(session.getAttribute("adminlogin")==null) {
			return "AdminLogin";
		}
		
		model.addAttribute("userObjList",userService.getUserById(id));
	
model.addAttribute("studentObjList", studentService.getStudentById(id));
		return "editStudentDetails";
	}

	@GetMapping("/controller/admin/applicationMessage")
public String getApplicationMessage(HttpSession session,Model model) {
		if(session.getAttribute("adminlogin")==null) {
			return "AdminLogin";
		}
	
		model.addAttribute("messageObjList", messageService.getMessageFeedback());
	return "ApplicationMessage";
}
	

	@PostMapping("/controller/admin/applicationMessage")
public String postApplicationMessage(@RequestParam String applicationApprove,@RequestParam String applicationref,HttpSession session,Model model) {
		if(session.getAttribute("adminlogin")==null) {
			return "AdminLogin";
		}
	
	
	return "ApplicationMessage";
	}
	
	
	@GetMapping("/controller/admin/feedback")
public String getFeedbackDetails(@RequestParam int id,HttpSession session,Model model) {
		if(session.getAttribute("adminlogin")==null) {
			return "AdminLogin";
		}
		model.addAttribute("studentObjList", studentService.getStudentById(id));
	
	return "feedbackForm";
}
	
	@PostMapping("/controller/admin/feedback")
	public String postFeedbackDetails(@ModelAttribute Student student,HttpSession session,Model model) {
			if(session.getAttribute("adminlogin")==null) {
				return "AdminLogin";
			}
		
			studentRepo.save(student);
		
		return "redirect:/controller/admin/applicationMessage";
	}
	
	
}
//	@GetMapping("/controller/admin/addStudentDetail")
//	public String addMoreDetail(HttpSession session) {
//		if(session.getAttribute("adminlogin")==null) {
//			return "AdminLogin";
//		}
//		
//		return "AddStudentDetails";
//	}
//	
//
//	@PostMapping("/controller/admin/addStudentDetail")
//	
//	public String addMoreDetail(@ModelAttribute Student student,HttpSession session) {
//		if(session.getAttribute("adminlogin")==null) {
//			return "AdminLogin";
//		}
//		studentService.addStudentDetail(student);
//		return "redirect:/controller/admin/studentDetail";
//	}

