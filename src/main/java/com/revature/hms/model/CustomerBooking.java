package com.revature.hms.model;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBooking {

	@Id
	private String customerUserName;
	
	@Column(nullable= false)
	private String customerName;
	
	@Column(nullable=false, unique=true)
	private String customerMobileno;
	
	@Column(nullable=false, unique=true)
	private String customerEmailId;
	
	@Column(nullable=false)
	private String roomType;
	
	@Column(nullable=false)
	private int numberOfMembers;
	
	@Column(nullable=false)
	private int numberOfRooms;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar customerCheckIn;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar customerCheckOut;
	
	@Column
	private int roomNo;
	
	@Column(nullable=false)
	private String bookingStatus;
	
	@Column(nullable=false)
	private int customerPayment;
}
