package spring.struts.springdatamongo.action.wx.integrate;

import spring.struts.springdatamongo.action.wx.vo.VoMemberData;
import spring.struts.springdatamongo.mongo.dao.RepositoryDaoExtra;
import spring.struts.springdatamongo.mongo.db.MemberInfoDB;
import spring.struts.springdatamongo.mongo.model.MemberInfo;


public class IntegrateMember {
	
	// 会员基础信息
	public static VoMemberData findVoMemberData(String memberId, RepositoryDaoExtra repositoryDaoExtra) {
		// 基本信息
		MemberInfo memberInfo = MemberInfoDB.findMemberInfoByMemberId(memberId, repositoryDaoExtra);
		if (null != memberInfo) {
			return findVoMemberDataCom(memberInfo, repositoryDaoExtra);
		}
		return null;
	}
	
	private static VoMemberData findVoMemberDataCom(MemberInfo memberInfo, RepositoryDaoExtra repositoryDaoExtra) {
		VoMemberData voMemberData = new VoMemberData();
		voMemberData = memberInfoToVoMemberData(voMemberData, memberInfo,repositoryDaoExtra);
		return voMemberData;
	}
	
	private static VoMemberData memberInfoToVoMemberData(VoMemberData voMemberData, MemberInfo memberInfo,RepositoryDaoExtra repositoryDaoExtra) {
		voMemberData.setMemberId(memberInfo.getId());
		voMemberData.setNickname(memberInfo.getNickname());
		voMemberData.setHeadImgUrl(memberInfo.getHeadImgUrl());
		voMemberData.setPhone(memberInfo.getPhone());
		voMemberData.setRedPacket(memberInfo.getIntegrate());
		voMemberData.setIdentity(memberInfo.getIdentity());
		return voMemberData;
	}
}
