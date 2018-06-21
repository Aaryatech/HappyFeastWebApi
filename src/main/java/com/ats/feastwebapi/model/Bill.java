package com.ats.feastwebapi.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id")
	private int billId;
	@Column(name = "bill_date")
	private Date billDate;
	@Column(name = "del_status")
	private int delStatus;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "enter_by")
	private int enterBy;
	@Column(name = "bill_close")
	private int billClose;
	@Column(name = "discount")
	private float discount;
	@Column(name = "grand_total")
	private float grandTotal;
	@Column(name = "payable_amount")
	private float payableAmt;
	@Column(name = "table_no")
	private int tableNo;
	@Column(name = "bill_no")
	private int billNo;

	private float cgst;
	private float sgst;
	private float taxableAmount;

	@Transient
	List<BillDetails> billDetails;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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

	public int getEnterBy() {
		return enterBy;
	}

	public void setEnterBy(int enterBy) {
		this.enterBy = enterBy;
	}

	public int getBillClose() {
		return billClose;
	}

	public void setBillClose(int billClose) {
		this.billClose = billClose;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(float payableAmt) {
		this.payableAmt = payableAmt;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(float taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public List<BillDetails> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetails> billDetails) {
		this.billDetails = billDetails;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", delStatus=" + delStatus + ", userId=" + userId
				+ ", enterBy=" + enterBy + ", billClose=" + billClose + ", discount=" + discount + ", grandTotal="
				+ grandTotal + ", payableAmt=" + payableAmt + ", tableNo=" + tableNo + ", billNo=" + billNo + ", cgst="
				+ cgst + ", sgst=" + sgst + ", taxableAmount=" + taxableAmount + ", billDetails=" + billDetails + "]";
	}

}
