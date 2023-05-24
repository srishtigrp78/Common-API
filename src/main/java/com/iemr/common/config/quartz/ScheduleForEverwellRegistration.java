package com.iemr.common.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.service.everwell.EverwellRegistrationService;

@Service
@Transactional
public class ScheduleForEverwellRegistration implements Job{

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private EverwellRegistrationService registrationService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.info("Started job for registration " + arg0.getClass().getName());
		registrationService.registerBeneficiary();
		logger.info("Completed job for registration " + arg0.getClass().getName());
	}
}
