package com.revature.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hms.HotelManagementReceptionistApplication;
import com.revature.hms.model.Receptionist;
import com.revature.hms.service.BookingHistoryService;
import com.revature.hms.service.BookingService;
import com.revature.hms.service.ReceptionistService;

@RestController
@RequestMapping("bookingController")
@CrossOrigin(origins="http://localhost/4200")
public class ReceptionistController {

	@Autowired
	private ReceptionistService receptionistService;
	
	@Autowired
	private BookingHistoryService bookingHistoryService;
	
	@Autowired
	private HotelManagementReceptionistApplication mailApplication;
	
	@Autowired
	private BookingService bookingService;
	
	@PutMapping("{customerUserName}")
	public ResponseEntity<String> addBookingHistory(@PathVariable("customerUserName") String customerUserName ){
		ResponseEntity<String> responseEntity= null;
		String message=null;
		bookingHistoryService.addToHistory(customerUserName);	
		bookingService.deleteByUserName(customerUserName);
		responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;
}
	
	@PutMapping("{receptionistId}")
	public ResponseEntity<String> updateMyProfile(@RequestBody Receptionist receptionist){
	   ResponseEntity<String> responseEntity = null;
	   int receptionistId= receptionist.getReceptionistId();
	   String message= null;
	   if(receptionistService.isReceptionistExists(receptionistId)) {
		   receptionistService.updateReceptionist(receptionist); 
		   //Receptionist receptionist1 = receptionistService.viewDetails(receptionistId);
		   message="Receptionist with ReceptionistId " +receptionistId + " details has been Updated Successfully ";
		   responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
	   }
	   else {
		   message="Receptionist with ReceptionistId" +receptionistId+ "does not exist";
		   responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
	   }
	   return responseEntity;
	}
	
	@GetMapping("/searchByReceptionistIdAndReceptionistPassword/{receptionistId}/{receptionistPassword}")
	public ResponseEntity<Receptionist> adminLogin(@PathVariable("receptionistId") int receptionistId, @PathVariable("receptionistPassword") String receptionistPassword){
		
			 ResponseEntity<Receptionist> responseEntity=null;
			 Receptionist receptionist =new Receptionist();
			 boolean res=false;		
			 res=receptionistService.receptionistLogin(receptionistId, receptionistPassword);
			 if(res) {
		     receptionist= receptionistService.viewDetails(receptionistId);
			 responseEntity=new ResponseEntity<Receptionist> (receptionist,HttpStatus.OK);
			 System.out.println("logged successfully");
			 } 
			 else {
			 responseEntity=new ResponseEntity<Receptionist> (receptionist,HttpStatus.OK);
			 System.out.println("Your login details are not matched");
			 }
			
			 return responseEntity;
			  
			
		}
	
	@GetMapping("/searchByReceptionistId/{receptionistId}")
	public ResponseEntity<Receptionist> getDoctorById(@PathVariable("receptionistId") int receptionistId){
		ResponseEntity<Receptionist> responseEntity = null;
		Receptionist receptionist = new Receptionist();
		if(receptionistService.isReceptionistExists(receptionistId)) {
			 receptionist= receptionistService.viewDetails(receptionistId);
			 responseEntity = new ResponseEntity<Receptionist>(receptionist, HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<Receptionist>(receptionist, HttpStatus.OK);

		}
		return responseEntity;
	}
}
