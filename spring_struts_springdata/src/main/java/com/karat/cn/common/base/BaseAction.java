package com.karat.cn.common.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

import com.karat.cn.common.json.GsonJson;
import com.karat.cn.mongo.dao.impl.RepositoryDaoImplExtra;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String query;// text
	private String qtype;// select
	private String sortname;// 排序字段
	private String sortorder;// 排序方式
	/**
	 * action 返回类型
	 */
	public final static String JSON = "json";

	public final static String STACK_DEFAULT = "stack_default";
	
	@Resource
	protected RepositoryDaoImplExtra repositoryDaoExtra;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public void doOutput(Object obj) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();

		String jsonstr = GsonJson.parseDataToJson(obj);

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
			
		PrintWriter out = response.getWriter();
		out.write(jsonstr);
		out.flush();
		out.close();
	}

	public <T> T decodParams(Class<T> c) {
		ServletRequest request = ServletActionContext.getRequest();

		JsonObject obj = new JsonObject();
		Map<String, String[]> params = request.getParameterMap();

		if (params != null && params.size() > 0) {
			for (Entry<String, String[]> entry : params.entrySet()) {
				if (entry.getValue() != null && entry.getValue().length > 0) {
					obj.addProperty(entry.getKey(), entry.getValue()[0]);
				}
			}
		}

		return GsonJson.parseJsonToData(obj, c);
	}

}
