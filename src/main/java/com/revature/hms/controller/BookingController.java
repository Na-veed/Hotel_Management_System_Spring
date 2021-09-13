package com.revature.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.hms.model.CustomerBooking;
import com.revature.hms.model.CustomerBookingHistory;
import com.revature.hms.service.BookingHistoryService;
import com.revature.hms.service.BookingService;

@Controller
@RequestMapping("booking")
public class BookingController {

	
	@Autowired
	private BookingHistoryService bookingHistoryService;
	
	@Autowired
	private BookingService bookingService;
	
	/*
	 * @PostMapping public ResponseEntity<String>addBookingHistory(@RequestBody
	 * CustomerBookingHistory customerBookingHistory){ ResponseEntity<String>
	 * responseEntity = null; String message=null; CustomerBooking customerBooking =
	 * new CustomerBooking(); String bookingStatus = "out" ;
	 * //bookingService.getCustomerByBookingStatus(bookingStatus);
	 * bookingHistoryService.addCustomerBookingHistory(customerBookingHistory);
	 * if(customerBooking.getBookingStatus().equals(bookingStatus)) {
	 * bookingService.deleteCustomerBookingByBookingStatus(bookingStatus); }
	 * responseEntity =new ResponseEntity<String>(message,HttpStatus.OK); return
	 * responseEntity; }
	 */
	
	@PutMapping("{customerName}")
	public ResponseEntity addBookingHistory(@PathVariable("customerName") String customerName ){
		ResponseEntity responseEntity= null;
		System.out.println("in controller");
		//String message=nul
		bookingHistoryService.addToHistory(customerName);
		
		return responseEntity;
	}
}
