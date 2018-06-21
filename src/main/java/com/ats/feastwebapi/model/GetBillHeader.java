package com.ats.feastwebapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetBillHeader {

	@Id
	private int billNo;

	private Date billDate;
	private float cgst;
	private float sgst;
	private float taxableAmount;
	private float discount;
	private float grandTotal;
	private float payableAmount;

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(float taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public float getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(float payableAmount) {
		this.payableAmount = payableAmount;
	}

	@Override
	public String toString() {
		return "GetBillHeader [billNo=" + billNo + ", billDate=" + billDate + ", cgst=" + cgst + ", sgst=" + sgst
				+ ", taxableAmount=" + taxableAmount + ", discount=" + discount + ", grandTotal=" + grandTotal
				+ ", payableAmount=" + payableAmount + "]";
	}

}
