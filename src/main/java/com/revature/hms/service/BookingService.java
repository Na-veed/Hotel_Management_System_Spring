package com.revature.hms.service;

import com.revature.hms.model.BookingTable;

public interface BookingService {
	
	public boolean addBooking(BookingTable bookingTable);
	
	public boolean deleteBooking(String username);

}
