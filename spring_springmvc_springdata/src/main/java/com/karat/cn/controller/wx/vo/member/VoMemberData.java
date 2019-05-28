package com.karat.cn.controller.wx.vo.member;

/**
 * 组装的数据
 */
public class VoMemberData {
	/**
	 * 会员id
	 */
	private String memberId;
	/**
	 * 会员昵称
	 */
	private String nickname;
	/**
	 * 会员头像
	 */
	private String headImgUrl;
	/**
	 * 等级
	 */
	private String leavl;
	/**
	 * 积分
	 */
	private String redPacket;

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getRedPacket() {
		return redPacket;
	}
	public void setRedPacket(String redPacket) {
		this.redPacket = redPacket;
	}
	
}
