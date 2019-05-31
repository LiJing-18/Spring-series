package com.karat.cn.model;

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
	 * 国
	 */
	private String country;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 创建时间
	 */
	private String createdDate;


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

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}

