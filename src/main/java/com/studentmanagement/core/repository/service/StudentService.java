package com.studentmanagement.core.repository.service;

import java.util.List;

import com.studentmanagement.core.model.Student;

public interface StudentService {
void addStudentDetail(Student student);
void deleteStudentDetail(int id);
void updateStudentDetail(Student student);
List <Student> getStudentDetails();

}
