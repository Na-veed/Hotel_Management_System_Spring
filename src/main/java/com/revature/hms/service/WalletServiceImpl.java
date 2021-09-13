package com.revature.hms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hms.model.Wallet;
import com.revature.hms.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	public WalletRepository walletRepository;

	@Override
	public boolean addWallet(Wallet wallet) {
		// TODO Auto-generated method stub
		walletRepository.save(wallet);
		return true;
	}

	@Override
	public boolean deleteWallet(String username) {
		// TODO Auto-generated method stub
		walletRepository.deleteById(username);
		;
		return true;
	}

	@Transactional
	@Override
	public boolean addMoneyForCancellation(String username, int price) {
		// TODO Auto-generated method stub
		walletRepository.addMoneyforCancellation(username, price);
		return true;
	}

	@Override
	@Transactional
	public boolean deductMoney(String username, int money) {
		// TODO Auto-generated method stub
		walletRepository.deductMoneyFromWallet(username, money);
		return true;
	}

}
