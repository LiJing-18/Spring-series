package com.karat.cn.controller.back;

import com.karat.cn.controller.back.abs.Response;
import com.karat.cn.model.MemberInfo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * 水军
 * @author 开发
 *
 */
@RestController
@RequestMapping("back")
public class AoneMemberController{

	private MongoTemplate mongoTemplate;


	//查看
	@RequestMapping("findAllAoneMemberInfoList")
	public Response findAllAoneMemberInfoList(int page,int rp) {
		Response response=new Response();

		int currentPage = page;
		int lineSize = rp;

		Query query = new Query();

		long total =mongoTemplate.count(new Query(),MemberInfo.class);
		response.setTotal(total);

		List<MemberInfo> list = mongoTemplate.find(query, MemberInfo.class);
		if(list.size()>0){
			processList(response,list);
		}
		return response;
	}
	private void processList(Response response,List<MemberInfo> list) {
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		list.forEach(m->{
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", m.getId());
			cellMap.put("cell", new Object[] {
					m.getNickname(),
					"<img src='" + m.getHeadImgUrl() + "' width='30' height='15'/>",
					m.getSex(),
					m.getCreatedDate()
			});
			rows.add(cellMap);
		});
		response.setMessage("请求成功");
		response.setSucflag(true);
		response.setRows(rows);
	}

}
