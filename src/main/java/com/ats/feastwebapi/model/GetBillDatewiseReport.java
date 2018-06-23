package com.ats.feastwebapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetBillDatewiseReport {
	@Id
	private int billId; 
	private Date billDate; 
	private float total;
	private float payableAmount;
	
	
	public float getTotal() {
		return total;
	}

	public Date getBillDate() {
		return billDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy") 
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public void setTotal(float total) {
		this.total = total;
	} 

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public float getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(float payableAmount) {
		this.payableAmount = payableAmount;
	}

	@Override
	public String toString() {
		return "GetBillDatewiseReport [billId=" + billId + ", billDate=" + billDate + ", total=" + total
				+ ", payableAmount=" + payableAmount + "]";
	}

	 

}
