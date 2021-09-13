package com.revature.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hms.model.CustomerBooking;
import com.revature.hms.model.CustomerBookingHistory;
import com.revature.hms.repository.BookingHistoryRepository;
import com.revature.hms.repository.BookingRepository;

@Service 
public class BookingHistoryServiceImpl implements BookingHistoryService{

	@Autowired
	private BookingHistoryRepository bookingHistoryRepository;
	
	@Autowired
	private BookingRepository bookingRepository;

//	@Autowired
//	private CustomerBookingHistory customerBookingHistory;
	@Override
	public boolean addCustomerBookingHistory(CustomerBookingHistory customerBookingHistory) {
		CustomerBookingHistory customerBooking = new CustomerBookingHistory();
		String bookingStatus = customerBooking.getBookingStatus();
		customerBooking = (CustomerBookingHistory) bookingRepository.findByBookingStatus(bookingStatus);
		customerBooking = bookingHistoryRepository.save(customerBookingHistory);
		return true;
	}

	@Override
	public boolean addToHistory(String customerName) {
		// TODO Auto-generated method stub
		CustomerBooking customerBooking = new CustomerBooking();
//		String bookingStatus = "out";
		System.out.println("in service before ");
		customerBooking =  bookingRepository.findByCustomerName(customerName);
		System.out.println("in service after ");
		bookingHistoryRepository.modifyingQueryInsertCustomerBookingHistory(customerBooking.getCustomerId(), customerBooking.getCustomerName(), customerBooking.getCustomerMobileno(), customerBooking.getCustomerEmailId(), customerBooking.getCustomerCheckIn(), customerBooking.getCustomerCheckOut(), customerBooking.getBookingStatus(), customerBooking.getCustomerPayment());	
		return true;
	}

}

