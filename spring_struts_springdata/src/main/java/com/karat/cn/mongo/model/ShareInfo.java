package com.karat.cn.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 分享
 * @author 开发
 *
 */
@Document(collection = "shareInfo")
public class ShareInfo {
	/**
	 * id
	 */
	@Id
	private String id;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 图片
	 */
	private String imgUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
