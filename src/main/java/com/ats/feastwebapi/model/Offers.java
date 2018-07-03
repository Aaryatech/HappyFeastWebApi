package com.ats.feastwebapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_offers")
public class Offers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int offerId;

	private String offerName;
	private String offerDesc;
	private String itemId;
	private int offerIsRunning;
	private Date fromDate;
	private Date toDate;
	private String fromTime;
	private String toTime;
	private int offerType;
	private int delStatus;
	private int isActive;
	private int isParsalRegular;
	private int offerBuyQty;
	private int offerFreeQty;
	private float offerPer;
	private int offerDatewiseDaywise;
	private String offerDay;

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

	public int getOfferIsRunning() {
		return offerIsRunning;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setOfferIsRunning(int offerIsRunning) {
		this.offerIsRunning = offerIsRunning;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public int getOfferType() {
		return offerType;
	}

	public void setOfferType(int offerType) {
		this.offerType = offerType;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsParsalRegular() {
		return isParsalRegular;
	}

	public void setIsParsalRegular(int isParsalRegular) {
		this.isParsalRegular = isParsalRegular;
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

	public String getOfferDay() {
		return offerDay;
	}

	public void setOfferDay(String offerDay) {
		this.offerDay = offerDay;
	}

	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", offerName=" + offerName + ", offerDesc=" + offerDesc + ", itemId="
				+ itemId + ", offerIsRunning=" + offerIsRunning + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", fromTime=" + fromTime + ", toTime=" + toTime + ", offerType=" + offerType + ", delStatus="
				+ delStatus + ", isActive=" + isActive + ", isParsalRegular=" + isParsalRegular + ", offerBuyQty="
				+ offerBuyQty + ", offerFreeQty=" + offerFreeQty + ", offerPer=" + offerPer + ", offerDatewiseDaywise="
				+ offerDatewiseDaywise + ", offerDay=" + offerDay + "]";
	}

}
