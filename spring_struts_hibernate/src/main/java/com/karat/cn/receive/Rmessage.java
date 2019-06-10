package com.karat.cn.receive;

import java.sql.Timestamp;

public class Rmessage {

	private String msgId;
	private String msgName;
	private String msgPhone;
	private String msgContent;
	private Timestamp msgTime;
	private String msgIp;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgName() {
		return msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	public String getMsgPhone() {
		return msgPhone;
	}

	public void setMsgPhone(String msgPhone) {
		this.msgPhone = msgPhone;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Timestamp getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Timestamp msgTime) {
		this.msgTime = msgTime;
	}

	public String getMsgIp() {
		return msgIp;
	}

	public void setMsgIp(String msgIp) {
		this.msgIp = msgIp;
	}

}
