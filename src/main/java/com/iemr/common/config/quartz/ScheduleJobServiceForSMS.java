package com.iemr.common.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.service.sms.SMSService;

@Service
@Transactional
public class ScheduleJobServiceForSMS implements Job
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private SMSService smsService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.info("Started job " + arg0.getClass().getName());
		smsService.publishSMS();
		logger.info("Completed job " + arg0.getClass().getName());
	}

}
