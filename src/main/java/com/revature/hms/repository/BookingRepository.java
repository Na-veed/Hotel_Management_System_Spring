package com.revature.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.revature.hms.model.CustomerBooking;

public interface BookingRepository extends CrudRepository<CustomerBooking, Integer>{
	
	
	public int deleteCustomerBookingByBookingStatus(String bookingStatus);

	@Query("select cb from CustomerBooking cb where bookingStatus=:bookingStatus")
	public List<CustomerBooking> findByBookingStatus(String bookingStatus);

	public CustomerBooking findByCustomerName(String customerName);

}
