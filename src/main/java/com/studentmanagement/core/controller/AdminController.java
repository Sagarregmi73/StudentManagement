package com.studentmanagement.core.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.core.model.Admin;
import com.studentmanagement.core.repository.AdminRepository;

@Controller
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;

	@GetMapping("/controller/login/admin")
	public String getAdminLogin() {

		return "AdminLogin";
	}

	@PostMapping("/controller/login/admin")
	public String postAdminLogin(@RequestParam String admin, @RequestParam String password, Model model,
			HttpSession session) {
		Admin admusrs = adminRepo.findByAdminAndPassword(admin, password);

		if (admusrs != null) {
			// admusrs.setPassword(DigestUtils.md5DigestAsHex(admusrs.getPassword().getBytes()));
			return "AdminDashboard";

		} else {
			if (admin.matches("sagar007") && password.matches("980058")) {

				Admin adm = new Admin();
				adm.setAdmin(admin);
				adm.setPassword(password);
				// adm.setPassword(DigestUtils.md5DigestAsHex(adm.getPassword().getBytes()));

				adminRepo.save(adm);
				Admin admusr = adminRepo.findByAdminAndPassword(admin, password);
				if (admusr != null) {
					session.setAttribute("adminlogin", admusr);
					session.setMaxInactiveInterval(200);
					return "AdminDashboard";
				}

				model.addAttribute("message", "invalid User");
				return "AdminLogin";
			}

		}

		model.addAttribute("message", "invalid admin");
		return "AdminLogin";
	}

	@GetMapping("/controller/login/admin/profile")
	public String getAdminProfile(HttpSession session, Model model) {
		if (session.getAttribute("adminlogin") == null) {
			return "AdminLogin";
		}
		return "AdminProfile";
	}

}
