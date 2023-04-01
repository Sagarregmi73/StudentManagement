package com.studentmanagement.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String emailId) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailId);

		msg.setSubject("reset Password");
		msg.setText("To reset password follow to this Link " + "http://localhost:8080/reset_password");

		mailSender.send(msg);
	}
}
