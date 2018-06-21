package com.ats.feastwebapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_order")
public class Order {

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
	private String orderDate;
	@Column(name = "order_date_time")
	private String orderDateTime;
	@Column(name = "del_status")
	private int delStatus;

	@Transient
	List<OrderDetails> orderDetailList;

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

	public List<OrderDetails> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetails> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", tableNo=" + tableNo + ", billStatus="
				+ billStatus + ", orderDate=" + orderDate + ", orderDateTime=" + orderDateTime + ", delStatus="
				+ delStatus + ", orderDetailList=" + orderDetailList + "]";
	}

}
