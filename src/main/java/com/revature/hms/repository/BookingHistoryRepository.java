package com.revature.hms.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.hms.model.CustomerBookingHistory;

public interface BookingHistoryRepository extends CrudRepository<CustomerBookingHistory, String> {

	
	@Modifying
	@Query(value="insert into CustomerBookingHistory VALUES(:customerUserName, :customerName, :customerMobileNo, :customerEmailId,:roomType,:numberOfRooms,:numberOfMembers, :customerCheckIn, :customerCheckOut,:roomNo, :bookingStatus, :customerPayment)", nativeQuery= true)
    @Transactional
	public void modifyingQueryInsertCustomerBookingHistory(@Param("customerUserName") String customerUserName,@Param("customerName") String customerName, @Param("customerMobileNo")String customerMobileNo, @Param("customerEmailId")String customerEmailId,@Param("roomType")int roomType, @Param("numberOfRooms")int numberOfRooms,@Param("numberOfMembers")int numberOfMembers, @Param("customerCheckIn") Calendar customerCheckIn, @Param("customerCheckOut") Calendar customerCheckOut,@Param("roomNo")int roomNo, @Param("bookingStatus")String bookingStatus, @Param("customerPayment")int customerPayment);

}

