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
public class CategoryWithItemList {
	
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
	
	@Transient
	private List<Item> itemList;

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

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "CategoryWithItemList [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + ", catImage="
				+ catImage + ", delStatus=" + delStatus + ", userId=" + userId + ", updatedDate=" + updatedDate
				+ ", itemList=" + itemList + "]";
	}
	
	

}
