package com.karat.cn.controller.wx.vo.member;

/**
 * 返回前端的vo
 */
public class ResponseMember {
	//状态码
	private String code;
	//请求描述
	private String msg;
	// 会员信息
	private VoMemberData voMemberData;
	
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
	public VoMemberData getVoMemberData() {
		return voMemberData;
	}
	public void setVoMemberData(VoMemberData voMemberData) {
		this.voMemberData = voMemberData;
	}

}
