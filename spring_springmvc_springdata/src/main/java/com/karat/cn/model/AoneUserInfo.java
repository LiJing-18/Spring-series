package com.karat.cn.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 后台管理人员信息
 * @author 开发
 *
 */
@Document(collection = "aoneUserInfo")
public class AoneUserInfo implements Serializable{
	
	private static final long serialVersionUID = -146333027048378376L;
	
	/**
	 * id
	 */
	@Id
	private String userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 账户状态(0:未激活" 1:激活  2:锁定)
	 */
	@Indexed
	private String userState;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
