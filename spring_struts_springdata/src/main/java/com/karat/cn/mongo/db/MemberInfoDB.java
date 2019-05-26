package com.karat.cn.mongo.db;

import com.karat.cn.mongo.dao.RepositoryDaoExtra;
import com.karat.cn.mongo.model.MemberInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public class MemberInfoDB {
	
	// 插入
	public static MemberInfo insertMemberInfo(MemberInfo info, RepositoryDaoExtra repositoryDaoExtra) {
		repositoryDaoExtra.insert(info);
		return info;
	}
	
	// 更新
	public static MemberInfo updateMemberInfo(MemberInfo info, RepositoryDaoExtra repositoryDaoExtra) {
		repositoryDaoExtra.saveOrUpdate(info);
		return info;
	}
	
	// 根据openId查询会员信息
	public static MemberInfo findMemberInfoByOpenId(String openId, RepositoryDaoExtra repositoryDaoExtra) {
		if (StringUtils.isBlank(openId)) {
			return null;
		}
		return repositoryDaoExtra.findOne(new Query().addCriteria(Criteria.where("openId").is(openId)), MemberInfo.class);
	}
	
	// 根据id查找会员基本信息
	public static MemberInfo findMemberInfoByMemberId(String memberId, RepositoryDaoExtra repositoryDaoExtra) {
		if (StringUtils.isBlank(memberId)) {
			return null;
		}
		return repositoryDaoExtra.findOne(new Query().addCriteria(Criteria.where("id").is(memberId)), MemberInfo.class);
	}

}
