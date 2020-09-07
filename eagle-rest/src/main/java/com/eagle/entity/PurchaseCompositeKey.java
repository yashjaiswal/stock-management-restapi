package com.eagle.entity;

import java.io.Serializable;

public class PurchaseCompositeKey implements Serializable{
	
	private Bill bill;
	private Brand brand;
	private Category category;
	
	public PurchaseCompositeKey() {
		
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
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

	public PurchaseCompositeKey(Bill bill, Brand brand, Category category) {
		this.bill = bill;
		this.brand = brand;
		this.category = category;
	}
	
	

}
