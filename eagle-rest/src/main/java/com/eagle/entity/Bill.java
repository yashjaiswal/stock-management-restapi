package com.eagle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="billId")
	private int billId;
	
	@Column(name="receiptNumber")
	private int receiptNumber;
	
	@JoinColumn(name="distributorId")
	@ManyToOne
	private Distributor distributor;
	
	@Column(name="isBillPaid")
	private boolean isBillPaid;
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(int receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	
	public boolean isBillPaid() {
		return isBillPaid;
	}
	public void setBillPaid(boolean isBillPaid) {
		this.isBillPaid = isBillPaid;
	}
	public int getDistributor() {
		return distributor.getDistributorId();
	}
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
	
	
	
	
}
