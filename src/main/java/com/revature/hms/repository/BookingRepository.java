package com.revature.hms.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.hms.model.BookingTable;

public interface BookingRepository extends CrudRepository<BookingTable, String>{

}
