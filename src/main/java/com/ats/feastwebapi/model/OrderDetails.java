package com.ats.feastwebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_details_id")
	private int orderDetailsId;
	@Column(name = "order_id")
	private int orderId;
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

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", orderId=" + orderId + ", itemId=" + itemId
				+ ", quantity=" + quantity + ", rate=" + rate + ", status=" + status + ", isMixer=" + isMixer + "]";
	}

}
