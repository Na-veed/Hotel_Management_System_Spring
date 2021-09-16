package com.revature.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;
@Data
@Entity
@Table(name = "receptionists")
public class Receptionist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int receptionistId;
	
	private String receptionistName;
	
	private String receptionistPassword;
	
	private int receptionistAge;
	
	private String receptionistPhoneNumber;
	
	private String receptionistEmail;
	
	private String address;
	
	private String experience;
	
	private int salary;
}
