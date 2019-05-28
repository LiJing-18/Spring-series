package com.karat.cn.action.back;

import com.karat.cn.common.base.BaseAction;
import com.karat.cn.common.util.BaseTools;
import com.karat.cn.common.util.Validate;
import com.karat.cn.mongo.model.MemberInfo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;


/**
 * 水军
 * @author 开发
 *
 */
@Namespace("")
@ParentPackage("jshop")
public class AoneMemberInfoAction extends BaseAction {
	
	private MemberInfo aoneMemberInfo;
	
	private static final long serialVersionUID = -8966710032739732173L;
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private long total = 0;
	private boolean sucflag;
	private String message;
	

	private String id;
	private String openId;//用户标识
	private String unionid;//用户统一标识(针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的)
	private String nickname;//用户昵称
	private String headImgUrl;//用户头像链接
	private int sex;//性别(1:男性,2:女性,0:未知)
	private String phone;//电话
	private String createdDate;//创建时间(2018-05-03 13:05:20)
	private int integrate;//积分
	private String description;//用户简介
	private String type;//类型0正常用户1水军
	
	

	//查看
	@Action(value = "findAllAoneMemberInfoList", results = { @Result(name = "json", type = "json") })
	public String findAllAoneMemberInfoList() {
		findAll();
		return JSON;
	}
	public void findAll(){
		int currentPage = page;
		int lineSize = rp;
		
		Query query = new Query();
		query.sort().on("createTime", Order.DESCENDING);
		total = repositoryDaoExtra.getCount(query, MemberInfo.class).intValue();
		List<MemberInfo> list = repositoryDaoExtra.findByPage(query, currentPage, lineSize, MemberInfo.class);
		if(list.size()>0){
			processList(list);	
		}
	}
	private void processList(List<MemberInfo> list) {
		for (Iterator<MemberInfo> iterator = list.iterator(); iterator.hasNext();) {
			Map<String, Object> cellMap = new HashMap<String, Object>();
			
			MemberInfo aoneMemberInfo = (MemberInfo) iterator.next();
					
			cellMap.put("id", aoneMemberInfo.getId());
			cellMap.put("cell", new Object[] { 
					 aoneMemberInfo.getNickname(),
					 "<img src='" + aoneMemberInfo.getHeadImgUrl() + "' width='30' height='15'/>",
					 aoneMemberInfo.getSex(),
					 aoneMemberInfo.getCreatedDate()
			});
			rows.add(cellMap);
		}
	}
	//添加
	@Action(value = "insertAoneMemberInfo", results = { @Result(name = "json", type = "json") })
	public String insertAoneMemberInfo(){
		MemberInfo a=new MemberInfo();
		a.setCreatedDate(BaseTools.formateDbDate(BaseTools.systemtime()));
		a.setHeadImgUrl(headImgUrl);
		a.setNickname(nickname);
		a.setOpenId("");
		a.setPhone("");
		a.setSex((int)Math.floor(Math.random()*( 1-0+1 ) + 0 ));
		a.setUnionid("");
		repositoryDaoExtra.insert(a);
		sucflag=true;
		return JSON;
	}
	//删除
	@Action(value = "delAoneMemberInfobyId", results = { @Result(name = "json", type = "json") })
	public String delAoneMemberInfobyId() {
		if (Validate.StrNotNull(id)){
			String[] list = id.trim().split(",");			
			for (String id : list) {
				MemberInfo memberInfo=repositoryDaoExtra.findById(id, MemberInfo.class);
				if(memberInfo!=null){
					// TODO:未完
					repositoryDaoExtra.delete(memberInfo);
					sucflag = true;
				}else{
					sucflag = false;
				}
			}
		}
		return JSON;
	}
	public MemberInfo getAoneMemberInfo() {
		return aoneMemberInfo;
	}
	public void setAoneMemberInfo(MemberInfo aoneMemberInfo) {
		this.aoneMemberInfo = aoneMemberInfo;
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
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getIntegrate() {
		return integrate;
	}
	public void setIntegrate(int integrate) {
		this.integrate = integrate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
