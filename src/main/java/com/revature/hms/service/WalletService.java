package com.revature.hms.service;

import com.revature.hms.model.Wallet;

public interface WalletService {

	public boolean addWallet(Wallet wallet);
	
	public boolean deleteWallet(String username);
	
	public boolean addMoneyForCancellation(String username, int amount);

	boolean deductMoney(String username, int money);
	
}
