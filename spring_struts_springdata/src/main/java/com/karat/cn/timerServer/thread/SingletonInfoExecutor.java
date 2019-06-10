package com.karat.cn.timerServer.thread;

import org.springframework.core.task.TaskExecutor;

import com.karat.cn.timerServer.service.SingletonInfoService;



public class SingletonInfoExecutor {

	private TaskExecutor taskExecutor;
	private SingletonInfoService singTimingService;
	
	//构造器
	public SingletonInfoExecutor(TaskExecutor taskExecutor) {
		super();
		this.taskExecutor = taskExecutor;
	}


	//查询
	public void processSingletonInfo() {
		taskExecutor.execute(new fixedTimeThread());
	}
	private class fixedTimeThread implements Runnable {
		public fixedTimeThread() {
				
		}
		public void run() {
			singTimingService.processSingleton();
		}
	}



	//get/set	
	public SingletonInfoService getSingTimingService() {
		return singTimingService;
	}
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	public void setSingTimingService(SingletonInfoService singTimingService) {
		this.singTimingService = singTimingService;
	}
			
}
