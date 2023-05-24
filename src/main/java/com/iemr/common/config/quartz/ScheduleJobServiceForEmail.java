package com.iemr.common.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.service.email.EmailService;

@Service
@Transactional
public class ScheduleJobServiceForEmail implements Job{

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private EmailService emailService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.info("Started job " + arg0.getClass().getName());
		emailService.publishEmail();
		logger.info("Completed job " + arg0.getClass().getName());
	}
}
