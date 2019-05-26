package com.karat.cn.action.wx.vo;

public class ReMemberMsg {
	
	private String code;
	private String msg;
	// 会员信息
	private VoMemberData voMemberData;
	private String redPacket;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRedPacket() {
		return redPacket;
	}
	public void setRedPacket(String redPacket) {
		this.redPacket = redPacket;
	}
	public VoMemberData getVoMemberData() {
		return voMemberData;
	}
	public void setVoMemberData(VoMemberData voMemberData) {
		this.voMemberData = voMemberData;
	}

}
