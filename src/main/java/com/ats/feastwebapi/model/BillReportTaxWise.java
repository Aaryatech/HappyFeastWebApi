package com.ats.feastwebapi.model;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BillReportTaxWise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_details_id")
	private int billDetailsId;
	
	@Column(name = "bill_id")
	private int billId;
	
	@Column(name = "bill_no")
	private int billNo;
	
	@Column(name = "bill_date")
	private Date billDate;
	
	@Column(name = "tax")
	private float tax;
	
	@Column(name = "taxable_amount")
	private float taxableAmount;
	
	@Column(name = "total_tax")
	private float totalTax;

	public int getBillDetailsId() {
		return billDetailsId;
	}

	public void setBillDetailsId(int billDetailsId) {
		this.billDetailsId = billDetailsId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(float taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	@Override
	public String toString() {
		return "BillReportTaxWise [billDetailsId=" + billDetailsId + ", billId=" + billId + ", billNo=" + billNo
				+ ", billDate=" + billDate + ", tax=" + tax + ", taxableAmount=" + taxableAmount + ", totalTax="
				+ totalTax + "]";
	}
	
	

}
