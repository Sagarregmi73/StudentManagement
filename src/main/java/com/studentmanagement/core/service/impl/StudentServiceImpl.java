package com.studentmanagement.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.repository.StudentRepository;
import com.studentmanagement.core.repository.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
@Autowired
	private StudentRepository studentRepo;
	@Override
	public void addStudentDetail(Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
	
	}

	@Override
	public void deleteStudentDetail(int id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
		
	}

	@Override
	public void updateStudentDetail(Student student) {
		// TODO Auto-generated method stub
		
		studentRepo.save(student);
		
	}

	@Override
	public List<Student> getStudentDetails() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentRepo.getById(id);
	}

	



	
}
