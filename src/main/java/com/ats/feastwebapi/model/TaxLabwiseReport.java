package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaxLabwiseReport {

	@Id
	private float cgst;
	private float sgst;
	private float igst;
	private float totalTax;

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

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	@Override
	public String toString() {
		return "TaxLabwiseReport [cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", totalTax=" + totalTax + "]";
	}

}
