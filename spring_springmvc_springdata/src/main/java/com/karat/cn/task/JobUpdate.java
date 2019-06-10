package com.karat.cn.task;

import com.karat.cn.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JobUpdate {

	@Autowired
	private QuartzService quartzService;

	public void execute() {
		System.out.println("定时任务 ---》》》JobUpdate -----》》》 5s执行");
		quartzService.update();
	}
}
