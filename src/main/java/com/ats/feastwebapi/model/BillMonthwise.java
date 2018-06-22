package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillMonthwise {
	@Id
	private int billId;
	private float cgst;
	private float sgst;
	private float grandTotal;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
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

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "BillMonthwise [billId=" + billId + ", cgst=" + cgst + ", sgst=" + sgst + ", grandTotal=" + grandTotal
				+ "]";
	}

}
