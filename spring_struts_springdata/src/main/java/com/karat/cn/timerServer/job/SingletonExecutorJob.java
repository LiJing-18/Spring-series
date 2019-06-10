package com.karat.cn.timerServer.job;

import org.quartz.JobExecutionContext;

import com.karat.cn.timerServer.thread.SingletonInfoExecutor;


public class SingletonExecutorJob extends BaseJob{

	private SingletonInfoExecutor singTimingExecutor;
	
	@Override
	public void biz(JobExecutionContext ctx) throws Exception {
		singTimingExecutor.processSingletonInfo();
	}

	public SingletonInfoExecutor getSingTimingExecutor() {
		return singTimingExecutor;
	}

	public void setSingTimingExecutor(SingletonInfoExecutor singTimingExecutor) {
		this.singTimingExecutor = singTimingExecutor;
	}

	
		
	
}
