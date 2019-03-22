package spring.springmvc.springdatamongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import spring.springmvc.springdatamongo.model.User;
import spring.springmvc.springdatamongo.service.UserService;

@Repository
public class UserServiceImpl implements UserService{
	@Autowired
	private MongoTemplate mongoTemplate;
	 
	public void addUser(User User) {
	     //1.如果没有指定集合，则默认添加到和对象名称相同的集合中，没有则创建一个
	     //2.也可以指定集合 mongoTemplate.save(User, "User_db");
	     mongoTemplate.save(User);
	}
	 
    public void removeUser(String id) {         
	     User User = findById(id);
	     mongoTemplate.remove(User);
    }
	 
	public void saveOrUpdateUser(User User) {         
	     mongoTemplate.save(User);
	}
	 
    public User findById(String id) {        
	     return mongoTemplate.findById(id, User.class);
	}
	 
	public List<User> findAll() {       
	    return mongoTemplate.findAll(User.class);
	}
	 
	public User findByUsername(String username) {
	    //根据username查询
	    Query sql = new Query(Criteria.where("userName").is(username));
	    return mongoTemplate.findOne(sql,User.class);
	}
}
