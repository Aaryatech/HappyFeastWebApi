package com.ats.feastwebapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_desc")
	private String itemDesc;
	@Column(name = "item_image")
	private String itemImage;
	@Column(name = "item_mrp_game")
	private float mrpGame;
	@Column(name = "item_mrp_regular")
	private float mrpRegular;
	@Column(name = "item_mrp_special")
	private float mrpSpecial;
	@Column(name = "item_opening_rate")
	private float openingRate;
	@Column(name = "item_max_rate")
	private float maxRate;
	@Column(name = "item_min_rate")
	private float minRate;
	@Column(name = "current_stock")
	private int currentStock;
	@Column(name = "cat_id")
	private int catId;
	@Column(name = "sgst")
	private float sgst;
	@Column(name = "cgst")
	private float cgst;
	@Column(name = "is_mixer_applicable")
	private int isMixerApplicable;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "updated_date")
	private Date updatedDate;
	@Column(name = "del_status")
	private int delStatus;
	@Column(name = "min_stock")
	private int minStock;

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public String getItemImage() {
		return itemImage;
	}

	public float getMrpGame() {
		return mrpGame;
	}

	public float getMrpRegular() {
		return mrpRegular;
	}

	public float getMrpSpecial() {
		return mrpSpecial;
	}

	public float getOpeningRate() {
		return openingRate;
	}

	public float getMaxRate() {
		return maxRate;
	}

	public float getMinRate() {
		return minRate;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public int getCatId() {
		return catId;
	}

	public float getSgst() {
		return sgst;
	}

	public float getCgst() {
		return cgst;
	}

	public int getIsMixerApplicable() {
		return isMixerApplicable;
	}

	public int getUserId() {
		return userId;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public void setMrpGame(float mrpGame) {
		this.mrpGame = mrpGame;
	}

	public void setMrpRegular(float mrpRegular) {
		this.mrpRegular = mrpRegular;
	}

	public void setMrpSpecial(float mrpSpecial) {
		this.mrpSpecial = mrpSpecial;
	}

	public void setOpeningRate(float openingRate) {
		this.openingRate = openingRate;
	}

	public void setMaxRate(float maxRate) {
		this.maxRate = maxRate;
	}

	public void setMinRate(float minRate) {
		this.minRate = minRate;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public void setIsMixerApplicable(int isMixerApplicable) {
		this.isMixerApplicable = isMixerApplicable;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemImage="
				+ itemImage + ", mrpGame=" + mrpGame + ", mrpRegular=" + mrpRegular + ", mrpSpecial=" + mrpSpecial
				+ ", openingRate=" + openingRate + ", maxRate=" + maxRate + ", minRate=" + minRate + ", currentStock="
				+ currentStock + ", catId=" + catId + ", sgst=" + sgst + ", cgst=" + cgst + ", isMixerApplicable="
				+ isMixerApplicable + ", userId=" + userId + ", updatedDate=" + updatedDate + ", delStatus=" + delStatus
				+ ", minStock=" + minStock + "]";
	}

}
