package com.ats.feastwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_parcel_order_detail")
public class ParcelOrderDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parcel_order_detail_id")
	private int parcelOrderDetailId;
	
	@Column(name = "parcel_order_id")
	private int parcelOrderId;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "rate")
	private float rate;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "is_mixer")
	private int isMixer;
	
	@Column(name = "remark")
	private String remark;

	public int getParcelOrderDetailId() {
		return parcelOrderDetailId;
	}

	public void setParcelOrderDetailId(int parcelOrderDetailId) {
		this.parcelOrderDetailId = parcelOrderDetailId;
	}

	public int getParcelOrderId() {
		return parcelOrderId;
	}

	public void setParcelOrderId(int parcelOrderId) {
		this.parcelOrderId = parcelOrderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsMixer() {
		return isMixer;
	}

	public void setIsMixer(int isMixer) {
		this.isMixer = isMixer;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ParcelOrderDetails [parcelOrderDetailId=" + parcelOrderDetailId + ", parcelOrderId=" + parcelOrderId
				+ ", itemId=" + itemId + ", quantity=" + quantity + ", rate=" + rate + ", status=" + status
				+ ", isMixer=" + isMixer + ", remark=" + remark + "]";
	}
	
	

}
