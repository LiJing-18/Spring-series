package com.karat.cn.controller.wx.integrate;

import com.karat.cn.controller.wx.vo.member.VoMemberData;
import com.karat.cn.model.MemberInfo;
import org.springframework.data.mongodb.core.MongoTemplate;


public class IntegrateMember {


	// 会员基础信息
	public static VoMemberData findVoMemberData(String memberId, MongoTemplate mongoTemplate) {
		// 基本信息
		MemberInfo memberInfo =mongoTemplate.findById(memberId,MemberInfo.class);
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
		voMemberData.setMemberId(memberInfo.getId());
		voMemberData.setNickname(memberInfo.getNickname());
		voMemberData.setHeadImgUrl(memberInfo.getHeadImgUrl());
		voMemberData.setRedPacket(memberInfo.getIntegrate());
		return voMemberData;
	}

}
