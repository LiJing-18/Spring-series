package com.karat.cn.action.back;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.karat.cn.common.base.BaseAction;
import com.karat.cn.common.qiniu.QiniuUtil;
import com.karat.cn.common.util.Validate;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 图片上传接口
 */
@Namespace("")
@ParentPackage("jshop")
public class ImgTAction extends BaseAction implements ServletRequestAware, ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ImgTAction.class);
	private final static String DIR = "Uploads";
	private final static String SVNDIR = ".svn";
	private File file;
	private File fileupload;
	private String uploadFileName;
	private String allfilename;
	private String qqfile;
	private String directoryname;
	private String filestrs;
	private HttpServletResponse response;
	private HttpServletRequest request;

	private String query;
	private String qtype;
	private int total = 0;
	private int rp;
	private int page = 1;
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private String creatorid;
	private String imgdirpath;
	private boolean sucflag;

	/**
	 * 异步图片
	 * @return
	 */
	@Action(value = "ajaxFileUploads", results = { @Result(name = "json", type = "json") })
	public String ajaxFileUploads() {
		String filename = request.getHeader("X-File-Name");
		String filepath = QiniuUtil.getFilePathByDate(filename);
		
		PrintWriter writer = null;
		InputStream inputStream = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			writer = response.getWriter();
			inputStream = request.getInputStream();
			byte[] data = IOUtils.toByteArray(inputStream);
			Map<String, String> map = QiniuUtil.upload(data, filepath);
			String code = map.get("code");
			if ("200".equals(code)) {
				response.setStatus(HttpServletResponse.SC_OK);
				System.out.println(map.get("path"));
				writer.print("{success:'" + map.get("path") + "'}");
			}
		} catch (IOException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: " + ex.getMessage());
		} finally {
			try {
				inputStream.close();
			} catch (IOException ignored) {

			}
		}
		writer.flush();
		writer.close();
		return "json";
	}


	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getAllfilename() {
		return allfilename;
	}

	public void setAllfilename(String allfilename) {
		this.allfilename = allfilename;
	}

	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getQqfile() {
		return qqfile;
	}

	public void setQqfile(String qqfile) {
		this.qqfile = qqfile;
	}

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

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getImgdirpath() {
		return imgdirpath;
	}

	public void setImgdirpath(String imgdirpath) {
		this.imgdirpath = imgdirpath;
	}

	public String getDirectoryname() {
		return directoryname;
	}

	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}

	public String getFilestrs() {
		return filestrs;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setFilestrs(String filestrs) {
		this.filestrs = filestrs;
	}
}