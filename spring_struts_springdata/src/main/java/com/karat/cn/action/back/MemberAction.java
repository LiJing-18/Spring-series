package com.karat.cn.action.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.karat.cn.common.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;

import com.karat.cn.mongo.model.MemberInfo;



/**
 * 用户信息接口
 * @author 开发
 *
 */
@Namespace("")
@ParentPackage("jshop")
public class MemberAction extends BaseAction {

	private static final long serialVersionUID = -5463602245463393961L;
	private int rp;
	private boolean sucflag;
	private String message;
	
	private int page = 1;
	private int total = 0;
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	
	
	/**
	 * 查询会员列表(分页)
	 */
	@Action(value = "findAllMemberInfo", results = { @Result(name = "json", type = "json") })
	public String findAllMemberInfo(){
		finddefaultAllMember();	
		return JSON;
	}
	private void finddefaultAllMember() {
		int currentPage = page;
		int lineSize = rp;
		Query query = new Query();
		query.sort().on("createdDate", Order.DESCENDING);
		total = repositoryDaoExtra.getCount(query, MemberInfo.class).intValue();
		List<MemberInfo> list = repositoryDaoExtra.findByPage(query, currentPage, lineSize, MemberInfo.class);
		parList(list);
	}
	private void parList(List<MemberInfo> list){
		for (Iterator<MemberInfo> it = list.iterator(); it.hasNext();) {
			MemberInfo info = (MemberInfo) it.next();
			String sex = "未知";
			if (1 == info.getSex()) {
				sex = "男性";
			} else if (2 == info.getSex()) {
				sex = "女性";
			}
			
			String sf="";
			if(info.getIdentity().equals("0")){
				sf="普通用户";
			}else if(info.getIdentity().equals("1")){
				sf="预备导购";
			}else if(info.getIdentity().equals("2")){
				sf="正式导购";
			}
			
			
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", info.getId());
			cellMap.put("cell", new Object[] {
					 info.getOpenId(),
					 info.getNickname(),
					 "<img src='" + info.getHeadImgUrl() + "' width='30' height='15'/>",
					 sex,
					 info.getPhone(),
					 info.getIntegrate(),
					 info.getCreatedDate(),
					 sf
					});
			rows.add(cellMap);
		}
	}
	
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Map<String, Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}