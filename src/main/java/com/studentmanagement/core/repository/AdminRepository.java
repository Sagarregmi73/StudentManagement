package com.studentmanagement.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.studentmanagement.core.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByAdminAndPassword(String adm, String psw);
}
