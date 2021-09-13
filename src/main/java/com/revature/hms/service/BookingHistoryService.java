package com.revature.hms.service;

import java.util.List;

import com.revature.hms.model.CustomerBookingHistory;

public interface BookingHistoryService {

	public boolean addCustomerBookingHistory(CustomerBookingHistory customerBookingHistory);
	
	public boolean addToHistory(String customerName);
}
