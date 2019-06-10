package com.karat.cn.task;

import com.karat.cn.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JobAdd {

	@Autowired
	private QuartzService service;
	
	public void execute() {
		System.out.println("定时任务 ---》》》JobAdd  =====>>> 2s执行一次");
		service.add();
	}
}
