package com.revature.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hms.model.BookingTable;
import com.revature.hms.service.BookingService;

@RestController
@RequestMapping("/Bookings")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/save")
	public ResponseEntity<String> addBooking(@RequestBody BookingTable bookingTable){
		
		ResponseEntity<String> responseEntity = null;
		bookingService.addBooking(bookingTable);
		responseEntity = new ResponseEntity<String>("Booking added successfully",HttpStatus.OK);
		return responseEntity;
		
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<String> deleteBooking(String username){
		ResponseEntity<String> responseEntity = null;

		bookingService.deleteBooking(username);
		responseEntity = new ResponseEntity<String>("Booking deleted", HttpStatus.OK);
		return responseEntity;
	}
	
}


