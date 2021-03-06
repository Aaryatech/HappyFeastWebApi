package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetCategoryReport {
	
	@Id
	private int billDetailsId; 
	private String catName; 
	private int catId;
	private int quantity;
	private float total;
	private float payableAmt;
	public int getBillDetailsId() {
		return billDetailsId;
	}
	public void setBillDetailsId(int billDetailsId) {
		this.billDetailsId = billDetailsId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getPayableAmt() {
		return payableAmt;
	}
	public void setPayableAmt(float payableAmt) {
		this.payableAmt = payableAmt;
	}
	@Override
	public String toString() {
		return "GetCategoryReport [billDetailsId=" + billDetailsId + ", catName=" + catName + ", catId=" + catId
				+ ", quantity=" + quantity + ", total=" + total + ", payableAmt=" + payableAmt + "]";
	}
	
	

}
