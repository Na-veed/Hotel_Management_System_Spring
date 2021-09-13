package com.revature.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hms.model.CustomerBooking;
import com.revature.hms.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public boolean deleteCustomerBookingByBookingStatus(String bookingStatus) {
		bookingRepository.deleteCustomerBookingByBookingStatus(bookingStatus);
		return true;
	}
	@Override
	public List<CustomerBooking> getCustomerByBookingStatus(String bookingStatus) {
		return bookingRepository.findByBookingStatus(bookingStatus);
		
	}
	

}
