package com.studentmanagement.core.repository.service;

import com.studentmanagement.core.model.Student;

public interface UserService {
void userSignup(Student student);
Student userLogin(String username,String password);

}
