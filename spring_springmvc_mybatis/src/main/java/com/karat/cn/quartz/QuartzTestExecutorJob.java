package com.karat.cn.quartz;

import com.karat.cn.thread.QuartzTestExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 定时器测试
 */
public class QuartzTestExecutorJob {

	@Autowired
	private QuartzTestExecutor quartzTestExecutor;
	

	public void biz(){
		//quartzTestExecutor.process();
	}

}
