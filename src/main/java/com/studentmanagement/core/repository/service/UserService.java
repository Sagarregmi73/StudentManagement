package com.studentmanagement.core.repository.service;

import java.time.LocalDate;
import java.util.List;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.model.User;

public interface UserService {
void userSignup(User user);
User userLogin(String username,String password);
List <User> getUser();

User getUserById(int id);

}
