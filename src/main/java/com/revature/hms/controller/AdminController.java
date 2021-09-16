package com.revature.hms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hms.HotelManagementReceptionistApplication;
import com.revature.hms.model.Admin;
import com.revature.hms.model.Receptionist;
import com.revature.hms.service.AdminService;
import com.revature.hms.service.ReceptionistService;
@RestController
@RequestMapping("adminController")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	ReceptionistService receptionistService;
	
	@Autowired
	private HotelManagementReceptionistApplication mailApplication;
	
	@Autowired
	AdminService adminService;
    
	@PostMapping("/addReceptionist")
	public ResponseEntity<String> addReceptionist (@RequestBody Receptionist receptionist)
		throws AddressException, MessagingException, IOException
	{
		ResponseEntity<String> responseEntity = null;
		String message = null;
		String from = "Taj-Restaurant";
		 String subject="Registration Status";
		 int receptionistId = receptionist.getReceptionistId();
		 if(receptionistService.isReceptionistExists(receptionistId))
		{
		    message = "Receptionist with " +receptionistId+ " already exists";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			
		}
		else
		{
			receptionistService.addReceptionist(receptionist);
			int receptionistId1 = receptionist.getReceptionistId();
			 Receptionist receptionist1 = receptionistService.viewDetails(receptionistId1);
				String toReceiver = receptionist1.getReceptionistEmail();
				message = "Congrajulations! and Hearty Welcome to the Taj Restaurant,"+
						"\n Dear "+receptionist1.getReceptionistName()+" ,admin has registered your details successfully"+
						"\n Please use  this details for login"+  
						"\n  ReceptionistId: "+receptionist1.getReceptionistId() +
				          "\n ReceptionistPassword: "+receptionist1.getReceptionistPassword()+
				          "\n And your salary details are below: "+
				          "\n Salary: " +receptionist1.getSalary()+
				          "\n Wishing u all the best";
				mailApplication.sendMail(from, toReceiver, subject, message);
				responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			
		}
		System.out.println(receptionist);
		return responseEntity;
	}
	
	@PutMapping
	public ResponseEntity<String> updateMyProfile(@RequestBody Receptionist receptionist){
	   ResponseEntity<String> responseEntity = null;
	   int receptionistId= receptionist.getReceptionistId();
	   String message= null;
	   String from = "Taj-Restaurant";
	   String subject="Registration Status";
	   if(receptionistService.isReceptionistExists(receptionistId)) {
		   receptionistService.updateReceptionist(receptionist);
		   Receptionist receptionist1 = receptionistService.viewDetails(receptionistId);
		   String toReceiver = receptionist1.getReceptionistEmail();
		   message="Receptionist with ReceptionistId " +receptionistId + " details has been Updated "+
		           "\n Here is your Salary and WorkExperience Details check it "+
		           "\n ReceptionistSalary:" +receptionist1.getSalary()+
				   "\n WorkExperience: "+receptionist1.getExperience();   
		   mailApplication.sendMail(from, toReceiver, subject, message);
		   responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
	   }
	   else {
		   message="Receptionist with ReceptionistId" +receptionistId+ "does not exist";
		   responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
	   }
	   return responseEntity;
	}
	
	@GetMapping("/searchByAdminIdAndAdminPassword/{adminId}/{adminPassword}")
	public ResponseEntity<Admin> adminLogin(@PathVariable("adminId") int adminId, @PathVariable("adminPassword") String adminPassword){
		
			 ResponseEntity<Admin> responseEntity=null;
			Admin admin =new Admin();
			 boolean res=false;		
			 res=adminService.adminLogin(adminId,adminPassword);
			 if(res) {
			admin=adminService.getAdminById(adminId); 
			responseEntity=new ResponseEntity<Admin> (admin,HttpStatus.OK);
			 System.out.println("logged successfully");
			 } 
			 else {
			 responseEntity=new ResponseEntity<Admin> (admin,HttpStatus.OK);
			 System.out.println("Your login details are not matched");
			 }
			
			 return responseEntity;
			  	
		}
		/*
		 * @GetMapping("/getAllReceptionists") public ResponseEntity<List<Receptionist>>
		 * getAllReceptionists(@RequestParam(required = false) String
		 * receptionistEmail){ ResponseEntity<List<Receptionist>> responseEntity = null;
		 * List<Receptionist> receptionist= new ArrayList<Receptionist>();
		 * if(receptionistEmail == null) { receptionist =
		 * receptionistService.getReceptionistByEmail(receptionistEmail); responseEntity
		 * = new ResponseEntity<List<Receptionist>>(receptionist, HttpStatus.OK); } else
		 * { receptionist = receptionistService.viewAllReceptionists(); }
		 * 
		 * if(receptionist.size() == 0) { responseEntity = new
		 * ResponseEntity<List<Receptionist>>(receptionist, HttpStatus.OK); } else {
		 * 
		 * responseEntity = new ResponseEntity<List<Receptionist>>(receptionist,
		 * HttpStatus.OK); } return responseEntity; }
		 */
	
}
