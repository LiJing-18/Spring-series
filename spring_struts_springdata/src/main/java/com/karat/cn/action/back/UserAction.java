package com.karat.cn.action.back;

import com.karat.cn.common.base.BaseAction;
import com.karat.cn.common.enumeration.StaticKey;
import com.karat.cn.common.enumeration.UserEnum;
import com.karat.cn.common.util.MD5Code;
import com.karat.cn.mongo.model.AoneUserInfo;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 系统管理员接口
 * @author 开发
 *
 */
@Namespace("/bk/user")
@ParentPackage("jshop")
public class UserAction extends BaseAction {
	
	private static final long serialVersionUID = -2406908924345833379L;
	
	private String param;
	private AoneUserInfo aoneUserInfo;
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	
	private int rp;
	private int page = 1;
	private long total = 0;
	
	private String userId;
	private String userName;
	private String password;
	private String userState;
	
	private String message;
	private boolean sucflag;
	private boolean slogin = false;
	private boolean sauthority;
	private String basepath;
	
	/**
	 * 验证登陆
	 */
	@Action(value = "/checklogin", results = { @Result(name = "json", type = "json", params = { "includeProperties", "slogin" }) })
	public String checklogin() {
		AoneUserInfo admin = (AoneUserInfo) ActionContext.getContext().getSession().get(StaticKey.BACK_USER_SESSION_KEY);
		if (admin!=null) {
			this.setSlogin(false);
			return "json";
		} else {
			this.setSlogin(true);
			return "json";
		}
	}
	@Action(value = "/checkAuthorityException", results = { @Result(name = "json", type = "json", params = { "includeProperties", "sauthority" }) })
	public String checkAuthorityException(){
		String authorityE=(String) ActionContext.getContext().getSession().get(StaticKey.AUTHORITYEXCEPTION);
		if(authorityE!=null){
			if(StaticKey.ONE.equals(authorityE)){
				this.setSauthority(true);
				ActionContext.getContext().getSession().remove(StaticKey.AUTHORITYEXCEPTION);
				return "json";
			}
		}else{
			this.setSauthority(false);
			return "json";
		}
		return "json";
	}
	/**
	 * 管理员登陆
	 * @return
	 * @throws Exception
	 */
	@Action(value = "/adminlogin", results = { @Result(name = "success", type = "redirect", location = "/admin/index.jsp?session=${param}"), @Result(name = "input", type = "redirect", location = "/admin/login.jsp?msg=${param}") })
	public String adminlogin() throws Exception {
		if(StringUtils.isBlank(this.getUserName())){
			this.setParam(StaticKey.ONE);
			return INPUT;
		}
		if(StringUtils.isBlank(this.getPassword())){
			this.setParam(StaticKey.ONE);
			return INPUT;
		}
			
		Query query = new Query();
		MD5Code md5 = new MD5Code();
		
		query.addCriteria(Criteria.where("userName").is(this.getUserName().toLowerCase(Locale.CHINA).trim()));
		query.addCriteria(Criteria.where("password").is(md5.getMD5ofStr(this.getPassword())));
		query.addCriteria(Criteria.where("userState").is(UserEnum.UserState.ACTIVE.getState()));
		AoneUserInfo userInfo = repositoryDaoExtra.findOne(query, AoneUserInfo.class);
		
		if (userInfo != null) {
			//TODO
			if(StaticKey.ONE.equals(userInfo.getUserState())){
					doSysIndexInit(userInfo, md5);
					return SUCCESS;
				}
		}
		this.setParam(StaticKey.ONE);
		return INPUT;
	}

	/**
	 * 进行用户登录有的系统首页数据初始化及用户权限相关初始化
	 * @param user
	 * @param md5
	 */
	private void doSysIndexInit(AoneUserInfo user,MD5Code md5){
		ActionContext.getContext().getSession().put(StaticKey.BACK_USER_SESSION_KEY, user);
		this.setParam(md5.getMD5ofStr(user.getUserId()));
		ActionContext.getContext().getSession().put(StaticKey.BACK_SESSION_KEY, param);
	}
	/**
	 * 后台登出
	 */
	@Action(value = "/adminlogout", results = { @Result(name = "json", type = "json") })
	public String adminlogout() {
		ActionContext.getContext().getSession().remove(StaticKey.BACK_USER_SESSION_KEY);
		ActionContext.getContext().getSession().remove(StaticKey.USERROLEFUNCTION);
		ActionContext.getContext().getSession().remove(StaticKey.BACK_SESSION_KEY);
		return "json";
	}


	public String getParam() {
		return param;
	}


	public void setParam(String param) {
		this.param = param;
	}


	public AoneUserInfo getAoneUserInfo() {
		return aoneUserInfo;
	}


	public void setAoneUserInfo(AoneUserInfo aoneUserInfo) {
		this.aoneUserInfo = aoneUserInfo;
	}


	public List<Map<String, Object>> getRows() {
		return rows;
	}


	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
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


	public long getTotal() {
		return total;
	}


	public void setTotal(long total) {
		this.total = total;
	}


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


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isSucflag() {
		return sucflag;
	}


	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}


	public boolean isSlogin() {
		return slogin;
	}


	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}


	public boolean isSauthority() {
		return sauthority;
	}


	public void setSauthority(boolean sauthority) {
		this.sauthority = sauthority;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getBasepath() {
		return basepath;
	}


	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}
	
	
	
}
