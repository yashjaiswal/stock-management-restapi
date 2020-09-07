package com.eagle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Brand")
public class Brand {
	
	@Column(name="brandId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brandId;
	
	@Column(name="brandName")
	private String brandName;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@JoinColumn(name="distributorId")
	@ManyToOne
	private Distributor distributor;
	
	
	public Brand() {
		
	}


	public int getBrandId() {
		return brandId;
	}


	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public int getDistributor() {
		return distributor.getDistributorId();
	}


	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

}
