package com.revature.hms.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.hms.model.Wallet;
import com.revature.hms.service.WalletService;

@RestController
@RequestMapping("/Reception")
public class ReceptionController {

	@Autowired
	WalletService walletService;

	@PostMapping("/save")
	public ResponseEntity<String> addWallet(@RequestBody Wallet wallet) {

		ResponseEntity<String> responseEntity = null;
		walletService.addWallet(wallet);
		responseEntity = new ResponseEntity<String>("wallet added successfully", HttpStatus.OK);
		return responseEntity;

	}

	@SuppressWarnings("deprecation")
	@PutMapping("/refund/{price}/{username}/{dateIn}")
	ResponseEntity<Boolean> addMoneyForCancellation(@PathVariable("price") int price,
			@PathVariable("username") String username,
			@PathVariable("dateIn") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateIn) throws ParseException {
		ResponseEntity<Boolean> responseEntity = null;

		System.out.println(dateIn);

		int monthDifference = dateIn.getMonth() - new Date().getMonth();
		System.out.println(monthDifference);

		int dateDifference = (dateIn.getDate() - new Date().getDate()) + 31;
		System.out.println(dateDifference);

		if (monthDifference != 0 && dateDifference >= 31) {
			int amount = (price / 100) * 10;
			walletService.addMoneyForCancellation(username, amount);
			responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}

		else if (monthDifference != 0 && dateDifference >= 15) {
			int amount = (price / 100) * 5;
			walletService.addMoneyForCancellation(username, amount);
			responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}

		else if (monthDifference == 0 && (dateDifference > 0 && dateDifference < 15)) {

			int amount = 0;
			walletService.addMoneyForCancellation(username, amount);
			responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		
		else {
			responseEntity = new ResponseEntity<Boolean>(false, HttpStatus.OK);

		}

		return responseEntity;

	}

	@PutMapping("/payment/{status}/{username}/{price}")
	ResponseEntity<Boolean> deductMoneyFromCheckOut(@PathVariable("price") int price,
			@PathVariable("username") String username, @PathVariable("status") String status) {

		System.out.println(status);
		ResponseEntity<Boolean> responseEntity = null;
		if (status.compareToIgnoreCase("booked") == 0) {
			System.out.println(price);
			price = (price / 100) * 10;
			walletService.deductMoney(username, price);
			responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else if (status.compareToIgnoreCase("IN") == 0) {
			price = (price / 100) * 40;
			walletService.deductMoney(username, price);
			responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else if (status.compareToIgnoreCase("OUT") == 0) {
			price = (price / 100) * 50;
			walletService.deductMoney(username, price);
			responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

}
