package com.ats.feastwebapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TableList {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "table_id")
	private int tableId;
	
	@Column(name = "table_no")
	private int tableNo;
	
	@Column(name = "table_name")
	private String tableName;
	
	@Column(name = "is_delete")
	private int isDelete;
	
	@Column(name = "is_active")
	private int isActive;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Transient
	private float totalAmt;
	
	@Transient
	private int OrderId;

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	@Override
	public String toString() {
		return "TableList [tableId=" + tableId + ", tableNo=" + tableNo + ", tableName=" + tableName + ", isDelete="
				+ isDelete + ", isActive=" + isActive + ", userId=" + userId + ", updatedDate=" + updatedDate
				+ ", totalAmt=" + totalAmt + ", OrderId=" + OrderId + "]";
	}
	
	
	
	
	

}
