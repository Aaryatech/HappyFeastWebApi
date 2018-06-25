package com.ats.feastwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_bill_setting")
public class TableSetting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int billSettingId;
	
	@Column(name = "bill_no")
	private String billNo;
	
	@Column(name = "venue_id")
	private int venueId;

	public int getBillSettingId() {
		return billSettingId;
	}

	public void setBillSettingId(int billSettingId) {
		this.billSettingId = billSettingId;
	}
 
	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	@Override
	public String toString() {
		return "TableSetting [billSettingId=" + billSettingId + ", billNo=" + billNo + ", venueId=" + venueId + "]";
	}
	
	

}
