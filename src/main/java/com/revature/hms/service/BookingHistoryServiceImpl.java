package com.revature.hms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hms.model.CustomerBooking;
import com.revature.hms.model.CustomerBookingHistory;
import com.revature.hms.repository.BookingHistoryRepository;


@Service 
public class BookingHistoryServiceImpl implements BookingHistoryService{

	@Autowired
	private BookingHistoryRepository bookingHistoryRepository;
	
	@Autowired
	private BookingService bookingService;

	@Override
	public boolean addToHistory(String customerUserName) {
		CustomerBooking customerBooking = new CustomerBooking();
		customerBooking =  bookingService.findByUserName(customerUserName);
		CustomerBookingHistory customerBookingHistory=new CustomerBookingHistory(customerBooking.getCustomerUserName(),customerBooking.getCustomerName(), customerBooking.getCustomerMobileno(), customerBooking.getCustomerEmailId(),customerBooking.getRoomType(),customerBooking.getNumberOfRooms(),customerBooking.getNumberOfMembers(), customerBooking.getCustomerCheckIn(), customerBooking.getCustomerCheckOut(),customerBooking.getRoomNo(), customerBooking.getBookingStatus(), customerBooking.getCustomerPayment());
		bookingHistoryRepository.save(customerBookingHistory);
		return true;
	}

	

}

