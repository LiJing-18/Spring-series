package com.karat.cn.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Document(collection = "user")
 * 这个注解和Hibernate的注解Entiry非常相似，
 * 就是定义一个文档，对象MongoDB存储的Collection（表）的名称是user
 * @Id
 * 指该字段是主键，不能缺少
 * @Field("username")
 * 指该字段映射MongoDB的实际字段，如果一致可以省略、
 *
 * @author 开发
 */
@Document(collection="user")
public class User {

	/**
	 * 主键
	 */
	@Id
	private String id;
	/**
	 * 用户名
	 */
	@Field("userName")
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 创建时间
	 */
	private String createTime;
	
	public User() {
		super();
	}
	public User( String userName, String passWord, String createTime) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.createTime = createTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
	     return "User [id=" + id + ", userName=" + userName + ", passWord="
	                 + passWord + ", createTime=" + createTime + "]";
    }
	
}
