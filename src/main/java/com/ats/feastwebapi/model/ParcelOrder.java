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
@Table(name = "t_parcel_order")
public class ParcelOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parcel_order_id")
	private int parcelOrderId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "bill_status")
	private int billStatus;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@Column(name = "order_date_time")
	private String orderDateTime;
	
	@Column(name = "del_status")
	private int delStatus;

	@Transient
	List<ParcelOrderDetails> parcelOrderDetailsList;

	public int getParcelOrderId() {
		return parcelOrderId;
	}

	public void setParcelOrderId(int parcelOrderId) {
		this.parcelOrderId = parcelOrderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public List<ParcelOrderDetails> getParcelOrderDetailsList() {
		return parcelOrderDetailsList;
	}

	public void setParcelOrderDetailsList(List<ParcelOrderDetails> parcelOrderDetailsList) {
		this.parcelOrderDetailsList = parcelOrderDetailsList;
	}

	@Override
	public String toString() {
		return "ParcelOrder [parcelOrderId=" + parcelOrderId + ", userId=" + userId + ", name=" + name + ", mobileNo="
				+ mobileNo + ", billStatus=" + billStatus + ", orderDate=" + orderDate + ", orderDateTime="
				+ orderDateTime + ", delStatus=" + delStatus + ", parcelOrderDetailsList=" + parcelOrderDetailsList
				+ "]";
	}
	
	

}
