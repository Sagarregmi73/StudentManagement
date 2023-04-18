package com.studentmanagement.core.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate dob;
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate joindate;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="address_tbl")
private Address address;

private String department;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="message_tbl")
private MessageFeedback messageFeedback;
private double courseFee;
private double fineDue;
private String courseDuration;
private int semister;

private double feeDue;

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


public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public MessageFeedback getMessageFeedback() {
	return messageFeedback;
}



public void setMessageFeedback(MessageFeedback messageFeedback) {
	this.messageFeedback = messageFeedback;
}
public double getCourseFee() {
	return courseFee;
}

public void setCourseFee(double courseFee) {
	this.courseFee = courseFee;
}

public double getFineDue() {
	return fineDue;
}

public void setFineDue(double fineDue) {
	this.fineDue = fineDue;
}

public String getCourseDuration() {
	return courseDuration;
}

public void setCourseDuration(String courseDuration) {
	this.courseDuration = courseDuration;
}

public int getSemister() {
	return semister;
}

public void setSemister(int semister) {
	this.semister = semister;
}

public double getFeeDue() {
	return feeDue;
}

public void setFeeDue(double feeDue) {
	this.feeDue = feeDue;
}


}
