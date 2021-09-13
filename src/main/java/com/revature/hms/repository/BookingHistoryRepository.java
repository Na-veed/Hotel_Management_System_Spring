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

public interface BookingHistoryRepository extends CrudRepository<CustomerBookingHistory, Integer> {

	
	/*
	 * @Query("select new com.revature.hms.model.CustomerBookingHistory(cb.customerId_int, cb.customerName_txt, cb.customerPassword_txt, cb.customerMobileno_txt, cb.customerEmailId_txt, cb.customerCheckIn, cb.customerCheckOut, cb.bookingStatus, cb.customerPayment) "
	 * ) public List<CustomerBookingHistory>
	 * getCustomerBooking(@Param("bookingStatus") String bookingStatus);
	 * @Query(value="insert into CustomerBookingHistory(customerId,customerName,customerMobileNo,customerEmailId,customerCheckIn,customerCheckOut,bookingStatus,customerPayment ) VALUES(:customerId, :customerName, :customerMobileNo, :customerEmailId, :customerCheckIn, :customerCheckOut, :bookingStatus, :customerPayment)", nativeQuery= true)

	 */
	 // new com.boarding.boardinghistory.resource.EmpBoardingHistory**(...
		/*
		 * @Query("insert into CustomerBookingHistory(SELECT cb from com.revature.hms.model.CustomerBooking cb where bookingStatus=:bookingStatus)"
		 * ) public int findByBookingStatus(String bookingStatus);
		 * 
		 * @Query("insert into CustomerBookingHistory values(customerId:customerId, customerName:customerName, customerMobileno:customerMobileno, customerEmailId:customerEmailId, customerCheckIn:customerCheckIn,customerCheckOut:customerCheckOut,bookingStatus:bookingStatus,customerPayment:customerPayment) "
		 * )
		 */
	
	//public CustomerBooking  findByCustomerName(String customerName)
	
	@Modifying
@Query(value="insert into CustomerBookingHistory VALUES(:customerId, :customerName, :customerMobileNo, :customerEmailId, :customerCheckIn, :customerCheckOut, :bookingStatus, :customerPayment)", nativeQuery= true)
    @Transactional
	public void modifyingQueryInsertCustomerBookingHistory(@Param("customerId") int customerId, @Param("customerName") String customerName, @Param("customerMobileNo")String customerMobileNo, @Param("customerEmailId")String customerEmailId, @Param("customerCheckIn") Calendar customerCheckIn, @Param("customerCheckOut") Calendar customerCheckOut, @Param("bookingStatus")String bookingStatus, @Param("customerPayment")int customerPayment);

}

