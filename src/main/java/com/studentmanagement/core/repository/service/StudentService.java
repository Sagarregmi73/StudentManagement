package com.studentmanagement.core.repository.service;

import java.util.List;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.model.User;

public interface StudentService {
void addStudentDetail(Student student);
void deleteStudentDetail(int id);
void updateStudentDetail(Student student);
List <Student> getStudentDetails();
Student getStudentById(int id);

}
