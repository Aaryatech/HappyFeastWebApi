package com.ats.feastwebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CancleMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int msgId;
	private String msgTitle;
	private int delStatus;

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "CancleMessage [msgId=" + msgId + ", msgTitle=" + msgTitle + ", delStatus=" + delStatus + "]";
	}

}
