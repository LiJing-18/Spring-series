package com.karat.cn.action.back;

import com.karat.cn.common.base.BaseAction;
import com.karat.cn.common.util.Validate;
import com.karat.cn.mongo.model.ShareInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;

/**
 * 后台分享接口
 * @author 开发
 *
 */
@Namespace("")
@ParentPackage("jshop")
public class ShareInfoAction extends BaseAction {

	private ShareInfo shareInfo;
	private static final long serialVersionUID = 7835248315821079601L;
	private List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private long total = 0;
	private boolean sucflag;
	private String message;
	
	private String id;
	private String type;
	private String content;
	private String imgUrl;
	
	//查看所有分享信息
	@Action(value = "findAllShareInfo", results = { @Result(name = "json", type = "json") })
	public String findAllShareInfo() {
		findAll();
		return JSON;
	}
	public void findAll() {
		int currentPage = page;
		int lineSize = rp;
			
		Query query = new Query();
		total = repositoryDaoExtra.getCount(query, ShareInfo.class).intValue();
		List<ShareInfo> list = repositoryDaoExtra.findByPage(query, currentPage, lineSize, ShareInfo.class);
		if(list.size()>0){
			processList(list);	
		}
	}
	private void processList(List<ShareInfo> list) {
		for (Iterator<ShareInfo> iterator = list.iterator(); iterator.hasNext();) {
			Map<String, Object> cellMap = new HashMap<String, Object>();
				
			ShareInfo shareInfo = (ShareInfo) iterator.next();
			
			//类型
			String type="";
			if(shareInfo.getType().equals("1")){
				type="单张照片";
			}else if(shareInfo.getType().equals("2")){
				type="个人主页 ";
			}else if(shareInfo.getType().equals("3")){
				type="常规";
			}
			
			cellMap.put("id", shareInfo.getId());
			cellMap.put("cell", new Object[] { 
					type,
					shareInfo.getContent(),
					"<img src='" + shareInfo.getImgUrl() + "' width='30' height='15'/>"
			});
			rows.add(cellMap);
		}
	}
	//添加分享
	@Action(value = "insertShareInfo", results = { @Result(name = "json", type = "json") })
	public String insertShareInfo(){
		ShareInfo shareInfo=repositoryDaoExtra.findOne(new Query().addCriteria(Criteria.where("type").is(type)),ShareInfo.class);
		if(shareInfo!=null){
			sucflag = false;
		}else{
			ShareInfo share=new ShareInfo();
			share.setContent(content);
			share.setImgUrl(imgUrl);
			share.setType(type);
			repositoryDaoExtra.insert(share);
			sucflag = true;
		}
		return JSON;
	}
	//根据id查
	@Action(value = "selectShareInfoById", results = { @Result(name = "json", type = "json") })
	public String selectShareInfoById(){	
		if(StringUtils.isNotBlank(id)){
			shareInfo=repositoryDaoExtra.findById(id, ShareInfo.class);
			if (null != shareInfo){
				sucflag = true;
			} else {
				sucflag = false;
			}
		}
		return JSON;
	}
	//改
	@Action(value = "updateShareInfoById", results = { @Result(name = "json", type = "json") })
	public String updateShareInfoById(){
			sucflag = false;
			if (StringUtils.isNotBlank(id)) {
				shareInfo=repositoryDaoExtra.findById(id,ShareInfo.class);
				if (null != shareInfo) {
					shareInfo.setContent(content);
					shareInfo.setImgUrl(imgUrl);
					shareInfo.setType(type);
					repositoryDaoExtra.saveOrUpdate(shareInfo);
					sucflag = true;
				}
			}
		return JSON;
	}
	//删
	@Action(value = "delShareInfoById", results = { @Result(name = "json", type = "json") })
	public String delShareInfoById() {
		if (Validate.StrNotNull(id)) {
			String[] list = id.trim().split(",");
			for (String ids: list) {
				repositoryDaoExtra.deleteById(ids, ShareInfo.class);
			}
			sucflag = true;
			return JSON;
		}
		return JSON;
	}
	
	public ShareInfo getShareInfo() {
		return shareInfo;
	}
	public void setShareInfo(ShareInfo shareInfo) {
		this.shareInfo = shareInfo;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
