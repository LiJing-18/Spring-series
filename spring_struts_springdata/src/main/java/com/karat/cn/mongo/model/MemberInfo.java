package com.karat.cn.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 用户信息
 * @author 开发
 *
 */
@Document (collection = "memberInfo")
public class MemberInfo {
	/**
	 * id
	 */
	@Id
	private String id;
	/**
	 * 用户标识
	 */
	private String openId;
	/**
	 * 用户统一标识(针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的)
	 */
	@Indexed
	private String unionid;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 用户头像链接
	 */
	private String headImgUrl;
	/**
	 * 性别(1:男性,2:女性,0:未知)
	 */
	private int sex;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 创建时间(2018-05-03 13:05:20)
	 */
	private String createdDate;
	/**
	 * 等级(当前导购为一批导购时存1,为二批导购时存上级导购id,为普通用户时存0)
	 */
	private String leval;
	/**
	 * 积分
	 */
	private String integrate;
	/**
	 * 用户身份(0:普通用户1:预备导购2:导购)
	 */
	private String identity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLeval() {
		return leval;
	}
	public void setLeval(String leval) {
		this.leval = leval;
	}
	public String getIntegrate() {
		return integrate;
	}
	public void setIntegrate(String integrate) {
		this.integrate = integrate;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
}

