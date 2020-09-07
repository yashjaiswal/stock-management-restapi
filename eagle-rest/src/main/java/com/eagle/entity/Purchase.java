package com.eagle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(PurchaseCompositeKey.class)
@Table(name="Purchase")
public class Purchase {

	  
	@Id
	@ManyToOne
	@JoinColumn(name="billId")
	private Bill bill;
	
	@Id
	@ManyToOne
	@JoinColumn(name="brandId")
	private Brand brand;
	  
	@Id
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	  
	@Column(name="quantity")  
	private int quantity;
	  
	@Column(name="purchasePrice")  
	private int purchasePrice;

	public int getBill() {
		return bill.getBillId();
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getBrand() {
		return brand.getBrandId();
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getCategory() {
		return category.getCategoryId();
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	  
	  
}
