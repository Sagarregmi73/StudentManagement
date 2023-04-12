package com.studentmanagement.core.repository.service;

import java.util.List;

import com.studentmanagement.core.model.Applyapplication;


public interface ApplicationService {
	void addStudentApplication(Applyapplication applyapplication);
	void deleteStudentApplication(int id);
	void updateStudentApplication(Applyapplication applyapplication);
	List <Applyapplication> getStudentApplication();

	Applyapplication getStudentApplicationById(int id);

}
