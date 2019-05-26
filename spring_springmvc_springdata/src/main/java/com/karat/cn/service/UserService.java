package com.karat.cn.service;

import java.util.List;

import com.karat.cn.model.User;

public interface UserService {
	/**
	 * 添加
	 * @param User
	 */
	public void addUser(User User);
	 
	/**
	 * 删除
	 * @param id
	 */
	public void removeUser(String id);
	 
	 
	/**
	 * 保存或修改
	 * @param User
	 */
	public void saveOrUpdateUser(User User);
	 
	 
	/**
	 * 根据id查询单个
	 * @param id
	 * @return
	 */
	public User findById(String id);
	     
	/**
	 * 根据用户名查询
	 * @param id
	 * @return
	 */
	public User findByUsername(String username);
	 
	 
	/**
	 * 查询所有
	 * @return
	 */
	public List<User> findAll();
}
