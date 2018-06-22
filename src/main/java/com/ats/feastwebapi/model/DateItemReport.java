package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DateItemReport {
	@Id
	private int billId;
	private String itemName;
	private String billDate;
	private int quantity;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "DateItemReport [billId=" + billId + ", itemName=" + itemName + ", billDate=" + billDate + ", quantity="
				+ quantity + "]";
	}

}
