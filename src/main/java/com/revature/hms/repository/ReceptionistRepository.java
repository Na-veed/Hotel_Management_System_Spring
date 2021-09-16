package com.revature.hms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.hms.model.Receptionist;


public interface ReceptionistRepository  extends JpaRepository<Receptionist, Integer> {

	public Optional<Receptionist> findByReceptionistIdAndReceptionistPassword(int receptionistId, String receptionistPassword);
	
	public List<Receptionist> findByReceptionistEmail(String receptionistEmail);

}
