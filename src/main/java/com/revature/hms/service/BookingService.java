package com.revature.hms.service;

import java.util.List;

import com.revature.hms.model.BookingTable;

public interface BookingService {
	
	public boolean addBooking(BookingTable bookingTable);
	
	public boolean deleteBooking(String username);
	
	public List<BookingTable> getBookings();

}
