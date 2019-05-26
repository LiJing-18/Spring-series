package com.karat.cn.service;

import java.util.List;

import com.karat.cn.pojo.User;

public interface UserService {

	/**
	 * 
	 * @Description: 新增用户
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * 
	 * @Description: 更新用户
	 * @param user
	 */
	public void updateUserById(User user);
	
	/**
	 * 
	 * @Description: 删除用户
	 * @param userId
	 */
	public void deleteUserById(String userId);
	
	/**
	 * 
	 * @Description: 根据用户主键ID获取用户信息
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId);
	
	/**
	 * 
	 * @Description: 获取用户列表
	 * @return
	 */
	public List<User> getUserList();
}
