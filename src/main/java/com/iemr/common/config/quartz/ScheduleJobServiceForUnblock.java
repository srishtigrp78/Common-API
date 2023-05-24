package com.iemr.common.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.service.callhandling.BeneficiaryCallService;

@Service
@Transactional
public class ScheduleJobServiceForUnblock implements Job
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private BeneficiaryCallService beneficiaryCallService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// Example example = new Example();
		// example.setFoo("test");
		// exampleRepository.save(example);
		logger.info("Started job " + arg0.getClass().getName());
		beneficiaryCallService.unblockBlockedNumbers();
		logger.info("Completed job " + arg0.getClass().getName());
	}

}
