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
	private int itemId;
	private int offerIsRunning;
	private Date fromDate;
	private Date toDate;
	private String fromTime;
	private String toTime;
	private int rateApplicable;
	private int delStatus;

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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOfferIsRunning() {
		return offerIsRunning;
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

	public int getRateApplicable() {
		return rateApplicable;
	}

	public void setRateApplicable(int rateApplicable) {
		this.rateApplicable = rateApplicable;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", offerName=" + offerName + ", offerDesc=" + offerDesc + ", itemId="
				+ itemId + ", offerIsRunning=" + offerIsRunning + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", fromTime=" + fromTime + ", toTime=" + toTime + ", rateApplicable=" + rateApplicable
				+ ", delStatus=" + delStatus + "]";
	}

}
