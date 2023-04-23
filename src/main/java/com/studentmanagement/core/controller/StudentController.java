package com.studentmanagement.core.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.studentmanagement.core.Application;

import com.studentmanagement.core.model.MessageFeedback;
import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.model.User;

import com.studentmanagement.core.repository.StudentRepository;
import com.studentmanagement.core.repository.UserRepository;
import com.studentmanagement.core.repository.service.MessageFeedbackService;
import com.studentmanagement.core.repository.service.StudentService;
import com.studentmanagement.core.repository.service.UserService;

@Controller
public class StudentController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageFeedbackService messageService;

	@GetMapping("/home")
	public String getHome(HttpSession session, Model model) {
		if (session.getAttribute("activeuser") == null) {
			return "index";
		}

		return "Home";
	}

	@GetMapping("/blog")
	public String getBlog(HttpSession session) {
		if (session.getAttribute("activeuser") == null) {
			return "index";
		}
		return "Blog";
	}

	@GetMapping("/notification")
	public String getNotification(HttpSession session) {
		if (session.getAttribute("activeuser") == null) {
			return "index";
		}
		return "Notification";
	}

	@GetMapping("/profile")
	public String getProfile(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("activeuser") == null) {

			return "index";
		}

		model.addAttribute("stuDetails", studentService.getStudentById(id));
		model.addAttribute("userObjList", userService.getUserById(id));

		return "Profile";
	}

	@GetMapping("/applyApplication")
	public String getApplyApplication(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("activeuser") == null) {
			return "index";
		}
		model.addAttribute("messageListObj", messageService.getMessageFeedbackById(id));

		return "applyApplication";
	}

	@PostMapping("/applyApplication")
	public String postApplyApplication(@ModelAttribute MessageFeedback message, HttpSession session, Model model,
			String applicationApprove) {
		if (session.getAttribute("activeuser") == null) {
			return "index";
		}

		messageService.addMessageFeedback(message);

		return "Home";

	}

	@GetMapping("/fees")
	public String getFees(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("activeuser") == null) {

			return "index";
		}

		model.addAttribute("stuDetails", studentService.getStudentById(id));
		model.addAttribute("userObjList", userService.getUserById(id));

		return "Fees";
	}

}
