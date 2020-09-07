package com.eagle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Stock")
@IdClass(StockCompositeKey.class)
public class Stock {
	
	@ManyToOne
	@JoinColumn(name="brandId")
	@Id
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	@Id
	private Category category;
	
	@Column(name="sellingPrice")
	private int sellingPrice;
	
	@Column(name="quantity")
	private int quantity;
	
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
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
