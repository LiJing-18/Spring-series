package com.karat.cn.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTest {

     @Scheduled(cron="*/3 * * * * ?")//每10秒跑一次任务
     public void tesTime(){
          System.out.println("定时器执行成功！---------66666----------");
     }
}
