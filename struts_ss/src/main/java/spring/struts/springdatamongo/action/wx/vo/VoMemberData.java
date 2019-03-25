package spring.struts.springdatamongo.action.wx.vo;


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
	/**
	 * 总销售额
	 */
	private String remainMoney;
	/**
	 * 总销量
	 */
	private String orderSingNum;
	/**
	 * 总提成
	 */
	private String takeMoney;
	/**
	 * 可提现
	 */
	private String withdrawable;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 用户身份(0:普通用户1:导购)
	 */
	private String identity;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLeavl() {
		return leavl;
	}
	public void setLeavl(String leavl) {
		this.leavl = leavl;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getRemainMoney() {
		return remainMoney;
	}
	public void setRemainMoney(String remainMoney) {
		this.remainMoney = remainMoney;
	}
	public String getOrderSingNum() {
		return orderSingNum;
	}
	public void setOrderSingNum(String orderSingNum) {
		this.orderSingNum = orderSingNum;
	}
	public String getTakeMoney() {
		return takeMoney;
	}
	public void setTakeMoney(String takeMoney) {
		this.takeMoney = takeMoney;
	}
	public String getWithdrawable() {
		return withdrawable;
	}
	public void setWithdrawable(String withdrawable) {
		this.withdrawable = withdrawable;
	}
	
}
