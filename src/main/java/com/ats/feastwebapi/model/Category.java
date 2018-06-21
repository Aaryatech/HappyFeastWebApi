package com.ats.feastwebapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_catgory")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;
	@Column(name = "cat_name")
	private String catName;
	@Column(name = "cat_desc")
	private String catDesc;
	@Column(name = "cat_image")
	private String catImage;
	@Column(name = "del_status")
	private int delStatus;
	@Column(name = "userId")
	private int userId;
	@Column(name = "updated_date")
	private Date updatedDate;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getCatImage() {
		return catImage;
	}

	public void setCatImage(String catImage) {
		this.catImage = catImage;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getUserId() {
		return userId;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + ", catImage=" + catImage
				+ ", delStatus=" + delStatus + ", userId=" + userId + ", updatedDate=" + updatedDate + "]";
	}

}
