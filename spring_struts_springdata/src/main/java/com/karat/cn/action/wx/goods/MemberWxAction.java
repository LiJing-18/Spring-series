package com.karat.cn.action.wx.goods;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.karat.cn.common.AppActionResultCode;
import com.karat.cn.common.VerConstants;
import com.karat.cn.common.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.karat.cn.action.wx.integrate.IntegrateMember;
import com.karat.cn.action.wx.vo.ReMemberMsg;

/**
 * 用户接口
 * @author 开发
 *
 */
@Namespace("/wx")
@ParentPackage("jshop")
public class MemberWxAction extends BaseAction implements ServletRequestAware, ServletResponseAware {
	
	private static final long serialVersionUID = -3314401741141495426L;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private String ver;
	private String memberId;//用户id


	
	/**
	 * 根据用户Id查看会员信息
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

	
}
