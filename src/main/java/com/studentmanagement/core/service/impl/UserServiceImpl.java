package com.studentmanagement.core.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.core.model.User;
import com.studentmanagement.core.repository.UserRepository;
import com.studentmanagement.core.repository.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignup(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);

	}

	@Override
	public User userLogin(String un, String psw) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameAndPassword(un, psw);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.getById(id);
	}

	@Override
	public void updateUserDetail(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}



	



}
