package com.ats.feastwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_bill_details")
public class BillDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_details_id")
	private int billDetailsId;
	@Column(name = "bill_id")
	private int billId;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "del_status")
	private int delStatus;
	@Column(name = "item_id")
	private int item_id;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "rate")
	private float rate;
	@Column(name = "sgst")
	private float sgst;
	@Column(name = "cgst")
	private float cgst;
	@Column(name = "total")
	private float total;
	@Column(name = "taxable_amount")
	private float taxableAmt;
	@Column(name = "total_tax")
	private float totalTax;

	public int getItem_id() {
		return item_id;
	}

	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getRate() {
		return rate;
	}

	public float getSgst() {
		return sgst;
	}

	public float getCgst() {
		return cgst;
	}

	public float getTotal() {
		return total;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public int getBillDetailsId() {
		return billDetailsId;
	}

	public int getBillId() {
		return billId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setBillDetailsId(int billDetailsId) {
		this.billDetailsId = billDetailsId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "BillDetails [billDetailsId=" + billDetailsId + ", billId=" + billId + ", orderId=" + orderId
				+ ", delStatus=" + delStatus + ", item_id=" + item_id + ", itemName=" + itemName + ", quantity="
				+ quantity + ", rate=" + rate + ", sgst=" + sgst + ", cgst=" + cgst + ", total=" + total
				+ ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax + "]";
	}

}
