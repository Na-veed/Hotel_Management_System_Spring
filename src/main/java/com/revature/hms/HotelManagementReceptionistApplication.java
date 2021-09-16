package com.revature.hms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class HotelManagementReceptionistApplication {

	@Autowired
	private static JavaMailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementReceptionistApplication.class, args);
	}
	@Autowired
	public  HotelManagementReceptionistApplication(JavaMailSender s) {
		this.mailSender = s;
	}

	public void sendMail(String from, String toReceiver, String subject, String message) {
	
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(from);
		msg.setTo(toReceiver);
		msg.setSubject(subject);
		msg.setText(message);
		mailSender.send(msg);
		
	}
}
