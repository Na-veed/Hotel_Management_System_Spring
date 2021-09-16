package com.revature.hms.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class BookingTable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	private String username;
	
	private int money;
	
	private String status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkInDate;

}
