package com.eagle.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.entity.Bill;
import com.eagle.service.BillService;


@RestController
@RequestMapping("/eagle")
public class BillRestController {
	
	@Autowired
	BillService billService;
	
	@GetMapping("/bills")
	public List<Bill> getAllBills() {
		
		return billService.getAllBills();

	}
	
	@GetMapping("/bill/{billId}")
	public Bill getBill(@PathVariable int billId) {
		
		if(billId<0) {
			throw new BrandIsNegativeException("Bill Id cannot be negative:"+billId);
		}
		return billService.getBill(billId);
		
	}
	
}
