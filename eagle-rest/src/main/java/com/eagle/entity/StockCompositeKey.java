package com.eagle.entity;

import java.io.Serializable;

public class StockCompositeKey implements Serializable{


	private Brand brand;
	
	private Category category;
	
	public StockCompositeKey() {
		
	}

	
	
	public StockCompositeKey(Brand brand, Category category) {
		this.brand = brand;
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	
	
}
