package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetCatInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catId;
	private String catName;
	private String catDesc;
	private String catImage;
	private int count;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "GetCatInfo [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + ", catImage=" + catImage
				+ ", count=" + count + "]";
	}

}
