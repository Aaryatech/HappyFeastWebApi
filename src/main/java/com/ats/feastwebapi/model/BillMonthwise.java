package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillMonthwise {
	@Id
	private int billId;
	private String month; 
	private float grandTotal;
	private float taxableAmount;
	private float taxAmt;
	private float payableAmount;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public float getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	public float getTaxableAmount() {
		return taxableAmount;
	}
	public void setTaxableAmount(float taxableAmount) {
		this.taxableAmount = taxableAmount;
	}
	public float getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}
	public float getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(float payableAmount) {
		this.payableAmount = payableAmount;
	}
	@Override
	public String toString() {
		return "BillMonthwise [billId=" + billId + ", month=" + month + ", grandTotal=" + grandTotal
				+ ", taxableAmount=" + taxableAmount + ", taxAmt=" + taxAmt + ", payableAmount=" + payableAmount + "]";
	}
	
	
 
}
