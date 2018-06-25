package com.ats.feastwebapi.model;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_table")
public class TableBean {

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
	
	@Column(name = "venue_id")
	private int venueId;
	
	public int getTableId() {
		return tableId;
	}
	public int getTableNo() {
		return tableNo;
	}
	public String getTableName() {
		return tableName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public int getIsActive() {
		return isActive;
	}
	public int getUserId() {
		return userId;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	@Override
	public String toString() {
		return "TableBean [tableId=" + tableId + ", tableNo=" + tableNo + ", tableName=" + tableName + ", isDelete="
				+ isDelete + ", isActive=" + isActive + ", userId=" + userId + ", updatedDate=" + updatedDate + "]";
	}

}
