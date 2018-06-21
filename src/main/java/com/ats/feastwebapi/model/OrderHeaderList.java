package com.ats.feastwebapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OrderHeaderList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "table_no")
	private int tableNo;
	
	@Column(name = "bill_status")
	private int billStatus;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "order_date_time")
	private String orderDateTime;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "order_total")
	float orderTotal;
	
	@Transient
	List<OrderDetailsList> orderDetailsList;

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
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
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

	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	public List<OrderDetailsList> getOrderDetailsList() {
		return orderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetailsList> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}

	@Override
	public String toString() {
		return "OrderHeaderList [orderId=" + orderId + ", userId=" + userId + ", tableNo=" + tableNo + ", billStatus="
				+ billStatus + ", orderDate=" + orderDate + ", orderDateTime=" + orderDateTime + ", delStatus="
				+ delStatus + ", orderTotal=" + orderTotal + ", orderDetailsList=" + orderDetailsList + "]";
	}
	
	

}
