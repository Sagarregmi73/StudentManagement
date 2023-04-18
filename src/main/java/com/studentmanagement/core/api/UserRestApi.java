package com.studentmanagement.core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.core.model.User;
import com.studentmanagement.core.repository.service.UserService;

@RestController
public class UserRestApi {
	@Autowired
	private UserService userService;
		@PostMapping("/api/user/signup")
		public String userSignup(@RequestBody User user) {
			userService.userSignup(user);
			return "successfully signup";
		}
		
		@GetMapping("/api/user/list")
		public List<User> getAllUser(){
			
			return userService.getUser();
		}
		
//		@DeleteMapping("/api/student/delete/{id}")
//		public String deleteStudent(@PathVariable int id) {
//			studentService.deleteStudentDetail(id);
//			return "deleted success";
//		}
	
		@PutMapping("/api/user/update")
		public String updateUser(@RequestBody User user) {
			userService.updateUserDetail(user);
			return "updated success";
		}
		
		@GetMapping("/api/user/{id}")
		public User getUserById(@PathVariable int id) {
			return userService.getUserById(id);
			
		}
		@PostMapping("/api/user/login")
		public User userLogin(@RequestParam String un ,@RequestParam String psw ) {
			return userService.userLogin(un, psw);
			
		}
}
