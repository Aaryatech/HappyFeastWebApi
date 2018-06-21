package com.ats.feastwebapi.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OrderList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int orderId;

	private int userId;

	private int tableNo;

	private int billStatus;

	private String orderDate;

	private String orderDateTime;

	private int delStatus;

	private int orderDetailsId;

	private int itemId;

	private int quantity;

	private float rate;

	private int status;

	private int isMixer;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public int getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(int billStatus) {
		this.billStatus = billStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsMixer() {
		return isMixer;
	}

	public void setIsMixer(int isMixer) {
		this.isMixer = isMixer;
	}

	@Override
	public String toString() {
		return "OrderList [orderId=" + orderId + ", userId=" + userId + ", tableNo=" + tableNo + ", billStatus="
				+ billStatus + ", orderDate=" + orderDate + ", orderDateTime=" + orderDateTime + ", delStatus="
				+ delStatus + ", orderDetailsId=" + orderDetailsId + ", itemId=" + itemId + ", quantity=" + quantity
				+ ", rate=" + rate + ", status=" + status + ", isMixer=" + isMixer + "]";
	}

}
