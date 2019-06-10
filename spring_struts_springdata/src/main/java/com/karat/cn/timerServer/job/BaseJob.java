package com.karat.cn.timerServer.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BaseJob extends QuartzJobBean {

	Logger logger = null;
	Logger runLogger = null;
	
	@Override
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		String jobName = null;
		String tiggerName = null;
		
		try {
			jobName = ctx.getJobDetail().getName();
			tiggerName = ctx.getTrigger().getName();
			runLogger.info(jobName +" 正在运行 ... ");
			biz(ctx);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("[" + tiggerName + "][" + jobName + "]业务逻辑  发生错误 : " + e);
		}

	}

	protected void biz(JobExecutionContext ctx) throws Exception {
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Logger getRunLogger() {
		return runLogger;
	}

	public void setRunLogger(Logger runLogger) {
		this.runLogger = runLogger;
	}

}
