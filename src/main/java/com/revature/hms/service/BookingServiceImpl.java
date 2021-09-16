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
	
//	@Override
//	public List<CustomerBooking> getCustomerByBookingStatus(String bookingStatus) {
//		return bookingRepository.findByBookingStatus(bookingStatus);
//		
//	}
	@Override
	public boolean deleteByUserName(String userName) {
		bookingRepository.deleteByUserName(userName);
		return true;
		
	}

	@Override
	public CustomerBooking findByUserName(String userName) {
		// TODO Auto-generated method stub
		CustomerBooking customerBooking=bookingRepository.findByUserName(userName);
		return customerBooking;
	}
	
	
	

}
