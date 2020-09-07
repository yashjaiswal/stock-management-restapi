package com.eagle.rest;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.eagle.entity.Brand;
import com.eagle.service.BrandService;

@RestController
@RequestMapping("/eagle")
public class BrandRestController {

	@Autowired
	BrandService brandService;

	@GetMapping("/brands")
	public List<Brand> getAllBrands() {
		
		return brandService.getAllBrands();

	}
	
	@GetMapping("/brand/{brandId}")
	public Brand getBrand(@PathVariable int brandId) {
		
		if(brandId<0) {
			throw new BrandIsNegativeException("Brand Id cannot be negative:"+brandId);
		}
		return brandService.getBrand(brandId);
		
	}
	
	/*@GetMapping("/brandValue/{brandId}")
	public ResponseEntity<String> getTotalBrandValue(@PathVariable int brandId) {
		
		//TO DO
	}*/
	
	
	
	//Below method is used to add a new brand. When adding a new brand, it will have all the fields: distributor id, categories, their cost and the stock.
	/*@PostMapping("/brand")
	public Brand addBrand(@RequestBody Brand brand) {
	
	}*/
	

}
