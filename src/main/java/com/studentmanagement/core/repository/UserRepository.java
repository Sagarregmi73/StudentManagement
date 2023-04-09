package com.studentmanagement.core.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.studentmanagement.core.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
User findByUsernameAndPassword(String un,String psw);
User findByUsername(String un);



@Transactional
@Modifying
@Query(value = "UPDATE User SET password = :psw WHERE username = :un")
void setNewPassword(String un, String psw);

}
