package com.studentmanagement.core.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="student_tbl")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String fathername;
private String phone;
private String gender;
private String department;
@DateTimeFormat(pattern = "yyy-MM-dd")
private LocalDate dob;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFathername() {
	return fathername;
}
public void setFathername(String fathername) {
	this.fathername = fathername;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public LocalDate getJoindate() {
	return joindate;
}
public void setJoindate(LocalDate joindate) {
	this.joindate = joindate;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@DateTimeFormat(pattern = "yyy-MM-dd")
private LocalDate joindate;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="address_tbl")
private Address address;


}
