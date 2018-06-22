package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemWiseReport {
	
	@Id
	private String itemName;
	private String chargable;
	private String NC1;
	private String NC2;
	private String NC3;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getChargable() {
		return chargable;
	}
	public void setChargable(String chargable) {
		this.chargable = chargable;
	}
	public String getNC1() {
		return NC1;
	}
	public void setNC1(String nC1) {
		NC1 = nC1;
	}
	public String getNC2() {
		return NC2;
	}
	public void setNC2(String nC2) {
		NC2 = nC2;
	}
	public String getNC3() {
		return NC3;
	}
	public void setNC3(String nC3) {
		NC3 = nC3;
	}
	@Override
	public String toString() {
		return "ItemWiseReport [itemName=" + itemName + ", chargable=" + chargable + ", NC1=" + NC1 + ", NC2=" + NC2
				+ ", NC3=" + NC3 + "]";
	}
	
	
	

}
