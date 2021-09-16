package com.revature.hms.service;

import java.util.List;

import com.revature.hms.model.Receptionist;

public interface ReceptionistService {

	
	public boolean addReceptionist(Receptionist receptionist);
	
	public boolean receptionistLogin(int receptionistId, String receptionistPassword);
	
    public boolean isReceptionistExists(int receptionistId);
	
	public boolean updateReceptionist(Receptionist receptionist);
	
	public Receptionist viewDetails(int receptionistId);
	
    public List<Receptionist> viewAllReceptionists();
	
	public String generatePassword(int min, int max);
	
	public List<Receptionist> getReceptionistByEmail(String receptionistEmail);
}
