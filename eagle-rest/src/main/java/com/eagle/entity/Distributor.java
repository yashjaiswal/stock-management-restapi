package com.eagle.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Distributor")
public class Distributor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="distributorId")
	private int distributorId;
	
	@Column(name="distributorName")
	private String distributorName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private int zip;
	
	@Column(name="state")
	private String state;
	
	@Column(name="contactNumber")
	private BigInteger contactNumber;
	
	public Distributor(){
		
	}


	public int getDistributorId() {
		return distributorId;
	}


	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}


	public String getDistributorName() {
		return distributorName;
	}


	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public BigInteger getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(BigInteger contactNumber) {
		this.contactNumber = contactNumber;
	}

	
}
