package com.karat.cn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karat.cn.dao.BaseDaoI;
import com.karat.cn.model.Message;
import com.karat.cn.receive.Rmessage;
import com.karat.cn.service.MessageServiceI;

@Transactional
@Service("messageService")
public class MessageServiceImpl implements MessageServiceI {

	@Resource
	private BaseDaoI<Message> baseDao;

	@Override
	public void msgSub(Rmessage rmessage) {
		Message message = new Message();
		message.setMsgContent(rmessage.getMsgContent());
		message.setMsgId(rmessage.getMsgId());
		message.setMsgIp(rmessage.getMsgIp());
		message.setMsgName(rmessage.getMsgName());
		message.setMsgPhone(rmessage.getMsgPhone());
		message.setMsgTime(rmessage.getMsgTime());
		baseDao.save(message);
	}

}
