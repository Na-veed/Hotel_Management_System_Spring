package com.revature.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hms.model.BookingTable;
import com.revature.hms.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public boolean addBooking(BookingTable bookingTable) {
		// TODO Auto-generated method stub
		bookingRepository.save(bookingTable);
		
		return true;
	}

	@Override
	public boolean deleteBooking(String username) {
		// TODO Auto-generated method stub
		bookingRepository.deleteById(username);
		return false;
	}

}
