package com.studentmanagement.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.core.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
