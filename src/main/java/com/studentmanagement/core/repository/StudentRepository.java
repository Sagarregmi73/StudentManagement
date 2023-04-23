package com.studentmanagement.core.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import com.studentmanagement.core.model.Student;
import com.studentmanagement.core.model.User;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	@Transactional
	@Modifying
	@Query(value = "UPDATE User SET imageProfile = :originalFilename WHERE id = :id")
	
	

	void setProfile(int id, String originalFilename);

	

	
	
}
