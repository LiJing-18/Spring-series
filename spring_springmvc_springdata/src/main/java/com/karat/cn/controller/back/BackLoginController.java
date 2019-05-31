package com.karat.cn.controller.back;

import com.alibaba.fastjson.JSON;
import com.karat.cn.common.enumeration.UserEnum;
import com.karat.cn.common.util.MD5Code;

import com.karat.cn.model.AoneUserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统管理员接口
 * @author 开发
 *
 */
@RequestMapping("/bk/user")
@Controller
public class BackLoginController {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 管理员登陆
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("adminlogin")
	public String adminlogin(String userName, String password){

		Query query = new Query();
		MD5Code md5 = new MD5Code();
		query.addCriteria(Criteria.where("userName").is(userName));
		query.addCriteria(Criteria.where("password").is(md5.getMD5ofStr(password)));
		query.addCriteria(Criteria.where("userState").is(UserEnum.UserState.ACTIVE.getState()));
		AoneUserInfo userInfo = mongoTemplate.findOne(query, AoneUserInfo.class);

		return "redirect:/admin/index.html";
	}

}
