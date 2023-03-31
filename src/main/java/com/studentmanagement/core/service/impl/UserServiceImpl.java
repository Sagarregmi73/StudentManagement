package com.studentmanagement.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.repository.UserRepository;
import com.studentmanagement.core.repository.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignup(Student student) {
		// TODO Auto-generated method stub
		userRepo.save(student);

	}

	@Override
	public Student userLogin(String un, String psw) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameAndPassword(un, psw);
	}

}
