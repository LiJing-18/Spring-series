package com.karat.cn.action.wx.integrate;

import com.karat.cn.action.wx.vo.VoMemberData;
import com.karat.cn.mongo.dao.RepositoryDaoExtra;
import com.karat.cn.mongo.db.MemberInfoDB;
import com.karat.cn.mongo.model.MemberInfo;


public class IntegrateMember {
	
	// 会员基础信息
	public static VoMemberData findVoMemberData(String memberId, RepositoryDaoExtra repositoryDaoExtra) {
		// 基本信息
		MemberInfo memberInfo = MemberInfoDB.findMemberInfoByMemberId(memberId, repositoryDaoExtra);
		if (null != memberInfo) {
			return findVoMemberDataCom(memberInfo);
		}
		return null;
	}
	/**
	 * 组装vo
	 * @param memberInfo
	 * @return
	 */
	private static VoMemberData findVoMemberDataCom(MemberInfo memberInfo) {
		VoMemberData voMemberData = new VoMemberData();
		voMemberData = memberInfoToVoMemberData(voMemberData, memberInfo);
		return voMemberData;
	}

	/**
	 * 组装vo
	 * @param voMemberData
	 * @param memberInfo
	 * @return
	 */
	private static VoMemberData memberInfoToVoMemberData(VoMemberData voMemberData, MemberInfo memberInfo) {
		voMemberData.setMemberId(memberInfo.getId());
		voMemberData.setNickname(memberInfo.getNickname());
		voMemberData.setHeadImgUrl(memberInfo.getHeadImgUrl());
		voMemberData.setRedPacket(memberInfo.getIntegrate());
		return voMemberData;
	}
}
