package com.ats.feastwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemWithOfferDaywise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "tax")
	private float tax;
	
	@Column(name = "rate")
	private float rate;
	
	@Column(name = "offer_id")
	private int offerId;
	
	@Column(name = "offer_name")
	private String offerName;
	
	@Column(name = "offer_desc")
	private String offerDesc;
	
	@Column(name = "offer_type")
	private int offerType;
	
	@Column(name = "offer_buy_qty")
	private int offerBuyQty;
	
	@Column(name = "offer_free_qty")
	private int offerFreeQty;
	
	@Column(name = "offer_per")
	private float offerPer;
	
	@Column(name = "offer_datewise_daywise")
	private int offerDatewiseDaywise;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDesc() {
		return offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	public int getOfferType() {
		return offerType;
	}

	public void setOfferType(int offerType) {
		this.offerType = offerType;
	}

	public int getOfferBuyQty() {
		return offerBuyQty;
	}

	public void setOfferBuyQty(int offerBuyQty) {
		this.offerBuyQty = offerBuyQty;
	}

	public int getOfferFreeQty() {
		return offerFreeQty;
	}

	public void setOfferFreeQty(int offerFreeQty) {
		this.offerFreeQty = offerFreeQty;
	}

	public float getOfferPer() {
		return offerPer;
	}

	public void setOfferPer(float offerPer) {
		this.offerPer = offerPer;
	}

	public int getOfferDatewiseDaywise() {
		return offerDatewiseDaywise;
	}

	public void setOfferDatewiseDaywise(int offerDatewiseDaywise) {
		this.offerDatewiseDaywise = offerDatewiseDaywise;
	}

	@Override
	public String toString() {
		return "ItemWithOfferDaywise [itemId=" + itemId + ", itemName=" + itemName + ", tax=" + tax + ", rate=" + rate
				+ ", offerId=" + offerId + ", offerName=" + offerName + ", offerDesc=" + offerDesc + ", offerType="
				+ offerType + ", offerBuyQty=" + offerBuyQty + ", offerFreeQty=" + offerFreeQty + ", offerPer="
				+ offerPer + ", offerDatewiseDaywise=" + offerDatewiseDaywise + "]";
	}
	
	

}
