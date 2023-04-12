package com.studentmanagement.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.core.model.Applyapplication;
import com.studentmanagement.core.repository.ApplicationRepository;
import com.studentmanagement.core.repository.service.ApplicationService;
@Service
public class ApplyapplicationImpl implements ApplicationService {
	@Autowired
private ApplicationRepository applicationRepo;
	@Override
	public void addStudentApplication(Applyapplication applyapplication) {
		applicationRepo.save(applyapplication);
		
	}

	@Override
	public void deleteStudentApplication(int id) {
		applicationRepo.deleteById(id);
	}

	@Override
	public void updateStudentApplication(Applyapplication applyapplication) {
		// TODO Auto-generated method stub
		applicationRepo.save(applyapplication);
	}

	@Override
	public List<Applyapplication> getStudentApplication() {
		// TODO Auto-generated method stub
		return applicationRepo.findAll();
	}

	@Override
	public Applyapplication getStudentApplicationById(int id) {
		// TODO Auto-generated method stub
		return applicationRepo.getById(id);
	}

}
