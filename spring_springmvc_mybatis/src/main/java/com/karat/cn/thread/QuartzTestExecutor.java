package com.karat.cn.thread;

import com.karat.cn.service.QuartzTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;


/**
 * 线程池使用
 */
@Component
public class QuartzTestExecutor {

	@Autowired
	private TaskExecutor taskExecutor;
	@Autowired
	private QuartzTestService quartzTestService;


	//查看信息
	public void process() {
		taskExecutor.execute(new serviceThread());
	}

	private class serviceThread implements Runnable {
		public serviceThread() {}
		public void run() {
			quartzTestService.send();
		}
	}

}
