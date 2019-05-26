package com.karat.cn.service.impl;

import java.util.List;

import com.karat.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karat.cn.mapper.UserMapper;
import com.karat.cn.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	//增
	public void saveUser(User user) {
		userMapper.insert(user);
	}
	//更新
	public void updateUserById(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	//删
	public void deleteUserById(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}
	//根据id查
	public User getUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	//查所有
	public List<User> getUserList() {	
		List<User> userList = userMapper.selectByExample();
		return userList;
	}

}
