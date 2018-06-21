package com.ats.feastwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_table_cat")
public class TableCat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "table_cat_id")
	private int tableCatId;

	@Column(name = "table_cat_name")
	private String tableCatName;

	@Column(name = "table_cat_desc")
	private String tableCatDesc;

	@Column(name = "is_active")
	private int isActive;

	public int getTableCatId() {
		return tableCatId;
	}

	public void setTableCatId(int tableCatId) {
		this.tableCatId = tableCatId;
	}

	public String getTableCatName() {
		return tableCatName;
	}

	public void setTableCatName(String tableCatName) {
		this.tableCatName = tableCatName;
	}

	public String getTableCatDesc() {
		return tableCatDesc;
	}

	public void setTableCatDesc(String tableCatDesc) {
		this.tableCatDesc = tableCatDesc;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "TableCat [tableCatId=" + tableCatId + ", tableCatName=" + tableCatName + ", tableCatDesc="
				+ tableCatDesc + ", isActive=" + isActive + "]";
	}

}
