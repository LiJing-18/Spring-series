package com.karat.cn.controller;


import com.karat.cn.model.User;
import com.karat.cn.model.vo.ResponseUser;
import com.karat.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list")
	@ResponseBody//返回json格式的数据
	public List<User> products(){
		List<User> userList = userService.findAll();
		return userList;
	}

	@RequestMapping(value = "/add")
	@ResponseBody//返回json格式的数据
	public ResponseUser add(){
		ResponseUser response=new ResponseUser();
		User user=new User("小明","小红","2019");
		userService.addUser(user);
		response.setCode("200");
		response.setMsg("请求成功");
		return response;
	}
}
