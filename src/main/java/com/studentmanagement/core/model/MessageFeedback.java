package com.studentmanagement.core.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="message_tbl")
public class MessageFeedback {
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String message;
private String applicationRef;
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate applyDate;

public String getApplicationRef() {
	return applicationRef;
}
public void setApplicationRef(String applicationRef) {
	this.applicationRef = applicationRef;
}
public LocalDate getApplyDate() {
	return applyDate;
}
public void setApplyDate(LocalDate applyDate) {
	this.applyDate = applyDate;
}
public String getMessage() {
	
	return message;
}
public void setMessage(String message) {
	this.message = message;
}




}
