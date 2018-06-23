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
	private int billNo;

	public int getBillSettingId() {
		return billSettingId;
	}

	public void setBillSettingId(int billSettingId) {
		this.billSettingId = billSettingId;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	@Override
	public String toString() {
		return "TableSetting [billSettingId=" + billSettingId + ", billNo=" + billNo + "]";
	}
	
	

}
