package com.eagle.rest;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.entity.Distributor;
import com.eagle.service.DistributorService;

@RestController
@RequestMapping("/eagle")
public class DistributorRestController {
	
	@Autowired
	private DistributorService distributorService;


	@GetMapping("/distributors")
	public List<Distributor> getAllDistributors() {
		List<Distributor> allDistributors = distributorService.getAllDistributors();
		return allDistributors;
	}
	
	@GetMapping("/distributor/{distributorId}")
	public Distributor getDistributor(@PathVariable int distributorId) {
		if(distributorId<0) {
			throw new DistributorNotFoundException("Distributor:"+distributorId+" not found!");
		}
		
		Distributor distributor = distributorService.getDistributor(distributorId);
		return distributor;
	}
	
	

}
