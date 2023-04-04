package com.studentmanagement.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_tbl")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(unique = true)
private String admin;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAdmin() {
	return admin;
}
public void setAdmin(String admin) {
	this.admin = admin;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
