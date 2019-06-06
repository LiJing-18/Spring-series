package com.karat.cn.controller.back;

import com.karat.cn.model.MemberInfo;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private MongoTemplate mongoTemplate;


	//查看
	@RequestMapping("findAllAoneMemberInfoList")
	public Map findAllAoneMemberInfoList(int pageSize, int pageNum) {
		Map map = new HashMap();

		//总条数
		int total=(int)mongoTemplate.count(new Query(),MemberInfo.class);
		//分页查询
		Query query=new Query();
		query.skip((pageNum - 1) * pageSize);
		query.limit(pageSize);
		List<MemberInfo> list = mongoTemplate.find(query, MemberInfo.class);
		//总页数
        int totalPage = (total  +  pageSize  - 1) / pageSize;

		map.put("pagelist", list);
		map.put("totalPage",totalPage);
		return map;
	}

	//添加



}
