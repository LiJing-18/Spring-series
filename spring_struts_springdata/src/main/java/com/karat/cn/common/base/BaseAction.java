package com.karat.cn.common.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.karat.cn.common.json.GsonJson;
import com.karat.cn.mongo.dao.impl.RepositoryDaoImplExtra;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * action 返回类型
	 */
	public final static String JSON = "json";
	
	@Resource
	protected RepositoryDaoImplExtra repositoryDaoExtra;


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

}
