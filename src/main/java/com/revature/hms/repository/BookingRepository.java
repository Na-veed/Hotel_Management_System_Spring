package com.revature.hms.repository;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.revature.hms.model.CustomerBooking;

public interface BookingRepository extends CrudRepository<CustomerBooking, String>{
	
	

	public CustomerBooking findByUserName(String userName);

	@Transactional
	public String deleteByUserName(String userName);
	
}
