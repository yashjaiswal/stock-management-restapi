package com.eagle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categoryId")
	private int categoryId;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@Column(name="quantity")
	private int quantity; //in milliliters
	
	public int getQuantity() {
		return quantity;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
