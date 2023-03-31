package com.studentmanagement.core.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.core.model.Student;

public interface UserRepository extends JpaRepository<Student, Integer>{
Student findByUsernameAndPassword(String un,String psw);
}
