package com.eagle.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.entity.Stock;
import com.eagle.service.StockService;

@RestController
@RequestMapping("/eagle")
public class StockRestController {

	@Autowired
	StockService stockService;
	
	@GetMapping("/stocks")
	public List<Stock> getAllStocks(){
		return stockService.getAllStocks(); 
	}
	
	@GetMapping("/stock/{brandId}")
	public List<Stock> getStockSingleBrand(@PathVariable int brandId) {
		return stockService.getStockSingleBrand(brandId);
	}
}
