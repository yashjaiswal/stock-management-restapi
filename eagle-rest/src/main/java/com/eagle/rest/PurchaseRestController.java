package com.eagle.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.entity.Purchase;
import com.eagle.service.PurchaseService;

@RestController
@RequestMapping("/eagle")
public class PurchaseRestController {


	@Autowired
	PurchaseService purchaseService;
	
	@GetMapping("/purchase/{billId}")
	public List<Purchase> getPurchaseByBill(@PathVariable int billId) {
		List<Purchase> purchases = purchaseService.getPurchaseByBill(billId);

		
	return purchases;
	}

	
}
