package com.karat.cn.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.DBCollection;

/**
 * mongodb 基础操作
 * @author 开发
 *
 */
public interface RepositoryDaoExtra {

	/**
	 * 插入对象
	 * 
	 * @param t
	 */
	public <T> void insert(T t);

	/**
	 * 插入多个对象
	 */
	public <T> void insertAll(List<T> t);

	/**
	 * 根据id删除对象
	 * 
	 * @param id
	 * @return
	 */
	public <T> boolean deleteById(String id, Class<T> t);

	/**
	 * 删除对象
	 * 
	 * @param t
	 */
	public <T> void delete(T t);

	/**
	 * 根据条件查询单个对象数据
	 * 
	 * @param query
	 * @return
	 */
	public <T> T findOne(Query query, Class<T> t);

	/**
	 * 根据id查询单个对象数据
	 * @param id
	 * @param t
	 * @param <T>
	 * @return
	 */
	public <T> T findById(String id, Class<T> t);

	/**
	 * 根据条件更新一个对象
	 * 
	 * @param query
	 * @param update
	 * @param t
	 * @return
	 */
	public <T> boolean updateFirst(Query query, Update update, Class<T> t);

	/**
	 * 查询所有数据
	 * 
	 * @param t
	 * @return
	 */
	public <T> List<T> findAll(Class<T> t);

	/**
	 * 查询总记录数
	 * 
	 * @param query
	 * @param t
	 * @return
	 */
	public <T> Long getCount(Query query, Class<T> t);

	/**
	 * 根据条件查询所有数据
	 * 
	 * @param query
	 * @param t
	 * @return
	 */
	public <T> List<T> findAll(Query query, Class<T> t);

	/**
	 * 根据条件分页查询所有数据
	 * 
	 * @param query
	 * @param t
	 * @return
	 */
	public <T> List<T> findByPage(Query query, int currentPage, int lineSize, Class<T> t);

	/**
	 * 返回更新后的数据
	 * 
	 * @param t
	 * @return
	 */
	public <T> T findAndModify(Query query, Update update, Class<T> t);

	/**
	 * 查询并删除
	 * 
	 * @param query
	 * @param t
	 * @return
	 */
	public <T> T findAndRemove(Query query, Class<T> t);

	/**
	 * 保存对象，如果对象存在就更新对象，如果对象不存在则保存对象
	 * 
	 * @param t
	 */
	public <T> void saveOrUpdate(T t);

	/**
	 * 根据条件更新多个对象
	 * 
	 * @param query
	 * @param update
	 * @param t
	 * @return
	 */
	public <T> boolean updateMulti(Query query, Update update, Class<T> t);

	/**
	 * 更新对象，如果对象不存在则插入对象
	 * 
	 * @param query
	 * @param update
	 * @param t
	 * @return
	 */
	public <T> boolean upsert(Query query, Update update, Class<T> t);

	/**
	 * 删除表
	 * 
	 * @param t
	 */
	public <T> void drop(Class<T> t);

	/**
	 * 获取collection
	 * 
	 * @param collectionName
	 * @return
	 */
	public <T> DBCollection getCollection(String collectionName);

	/**
	 * 删除数据
	 */
	public <T> void remove(Query query, Class<T> t);

	public <T> GroupByResults<T> group(Criteria criteria, String collectionName, String groupField, Class<T> t);
}
