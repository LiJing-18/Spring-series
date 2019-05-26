package com.karat.cn.mongo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.karat.cn.mongo.dao.RepositoryDaoExtra;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.WriteResult;

@Repository("repositoryDaoExtra")
@Scope("singleton")
public class RepositoryDaoImplExtra implements RepositoryDaoExtra {
	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public <T> void insert(T t) {
		mongoTemplate.insert(t);
	}

	@Override
	public <T> void insertAll(List<T> t) {
		mongoTemplate.insertAll(t);
	}

	@Override
	public <T> boolean deleteById(String id, Class<T> t) {
		Criteria criteria = Criteria.where("_id").in(id);
		if (null != criteria) {
			Query query = new Query(criteria);
			List<T> list = this.findAll(query, t);
			if (list != null && list.size() > 0) {
				this.delete(list.get(0));
				return true;
			}
			/*
			 * if(null!=query&&this.findOne(query, t)!=null){
			 * this.delete(this.findOne(query, t)); return true; }
			 */
		}
		return false;
	}

	@Override
	public <T> void delete(T t) {
		mongoTemplate.remove(t);
	}

	@Override
	public <T> T findOne(Query query, Class<T> t) {
		return mongoTemplate.findOne(query, t);
	}

	@Override
	public <T> T findById(String id, Class<T> t) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, t);
	}

	@Override
	public <T> boolean updateFirst(Query query, Update update, Class<T> t) {
		WriteResult result = mongoTemplate.updateFirst(query, update, t);
		if (result.getN() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public <T> List<T> findAll(Class<T> t) {
		return mongoTemplate.findAll(t);
	}

	@Override
	public <T> Long getCount(Query query, Class<T> t) {
		return mongoTemplate.count(query, t);
	}

	@Override
	public <T> List<T> findAll(Query query, Class<T> t) {
		return mongoTemplate.find(query, t);
	}

	@Override
	public <T> List<T> findByPage(Query query, int currentPage, int lineSize, Class<T> t) {
		query.skip((currentPage - 1) * lineSize);
		query.limit(lineSize);
		return mongoTemplate.find(query, t);
	}

	@Override
	public <T> T findAndModify(Query query, Update update, Class<T> t) {
		return mongoTemplate.findAndModify(query, update, t);
	}

	@Override
	public <T> T findAndRemove(Query query, Class<T> t) {
		return mongoTemplate.findAndRemove(query, t);
	}

	@Override
	public <T> void saveOrUpdate(T t) {
		mongoTemplate.save(t);
	}

	@Override
	public <T> boolean updateMulti(Query query, Update update, Class<T> t) {
		WriteResult result = mongoTemplate.updateMulti(query, update, t);
		if (result.getN() >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public <T> boolean upsert(Query query, Update update, Class<T> t) {
		WriteResult result = mongoTemplate.upsert(query, update, t);
		if (result.getN() >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public <T> void drop(Class<T> t) {
		mongoTemplate.dropCollection(t);

	}

	@Override
	public <T> DBCollection getCollection(String collectionName) {
		return mongoTemplate.getCollection(collectionName);
	}

	@Override
	public <T> void remove(Query query, Class<T> t) {
		mongoTemplate.remove(query, t);
	}

	@Override
	public <T> GroupByResults<T> group(Criteria criteria, String collectionName, String groupField, Class<T> t) {
		GroupByResults<T> results = mongoTemplate.group(criteria, collectionName, new GroupBy(groupField), t);
		return results;
	}
}
