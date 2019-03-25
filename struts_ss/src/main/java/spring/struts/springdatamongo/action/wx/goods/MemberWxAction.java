package spring.struts.springdatamongo.action.wx.goods;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import spring.struts.springdatamongo.action.wx.integrate.IntegrateMember;
import spring.struts.springdatamongo.action.wx.vo.ReMemberMsg;
import spring.struts.springdatamongo.common.AppActionResultCode;
import spring.struts.springdatamongo.common.VerConstants;
import spring.struts.springdatamongo.common.base.BaseAction;

/**
 * 用户接口
 * @author 开发
 *
 */
@Namespace("/wx")
@ParentPackage("jshop")
@InterceptorRefs({ @InterceptorRef("defaultStack") })
public class MemberWxAction extends BaseAction implements ServletRequestAware, ServletResponseAware {
	
	private static final long serialVersionUID = -3314401741141495426L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String ver;
	private String memberId;//用户id
	private String inviteCode;//邀请码
	private String province;//省
	private String city;//城
	private String area;//区
	private String address;//详细地址
	
	// 用户标识
	private String openId;
	// 用户统一标识
	private String unionid;
	// 会员昵称
	private String nickname;
	// 会员头像
	private String headImgUrl;
	// 性别(1:男性,2:女性,0:未知)
	private int sex;
	//电话
	private String phone;
	
	private String code;//邀请码
	
	/**
	 * 查看会员信息
	 */
	@Action(value = "findMemberInfoWx")
	public void findMemberInfoWx() throws IOException {
		if (VerConstants.findAllPlatformVerKeyState(ver)) {
			ReMemberMsg msg = new ReMemberMsg();
			if (StringUtils.isNotBlank(memberId)) {
				msg.setVoMemberData(IntegrateMember.findVoMemberData(memberId, repositoryDaoExtra));
				msg.setCode(AppActionResultCode.CODE_SUCCESS);
			} else {
				msg.setCode(AppActionResultCode.CODE_FAILURE);
				msg.setMsg("请检查传入参数！");
			}
			doOutput(msg);
		}
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
