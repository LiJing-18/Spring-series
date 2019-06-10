package com.karat.cn.action;

import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.karat.cn.receive.Rmessage;
import com.karat.cn.service.MessageServiceI;
import com.opensymphony.xwork2.ModelDriven;

@Action(value = "messageAction")
public class MessageAction extends BaseAction implements ModelDriven<Rmessage> {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MessageAction.class);

	Rmessage rmessage = new Rmessage();

	@Override
	public Rmessage getModel() {
		return rmessage;
	}

	@Resource
	private MessageServiceI messageService;

	public void msgSub() {
		try {

			rmessage.setMsgId(UUID.randomUUID().toString());
			rmessage.setMsgIp(ServletActionContext.getRequest().getRemoteAddr());
			rmessage.setMsgTime(new Timestamp(System.currentTimeMillis()));

			messageService.msgSub(rmessage);

			super.writeJson(true);

		} catch (Exception e) {
			super.writeJson(false);
			logger.error(e);
		}
	}
}
