package com.revature.hms.service;

import java.util.List;

import com.revature.hms.model.CustomerBooking;

public interface BookingService {
	
	
	public List<CustomerBooking> getCustomerByBookingStatus(String bookingStatus);
	
	public boolean deleteCustomerBookingByBookingStatus(String bookingStatus);

}
