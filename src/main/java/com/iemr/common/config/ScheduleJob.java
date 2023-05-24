package com.iemr.common.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.iemr.common.service.callhandling.BeneficiaryCallService;

/**
 * @author VI314759
 *
 */
public class ScheduleJob implements Job
{
	private BeneficiaryCallService beneficiaryCallService;

	@SuppressWarnings("unused")
	private void getBeansFromContext(JobExecutionContext context) throws SchedulerException
	{
		ApplicationContext applicationContext =
				(ApplicationContext) context.getScheduler().getContext().get("applicationContext");
		this.beneficiaryCallService = applicationContext.getBean(BeneficiaryCallService.class);
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException
	{
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		try
		{
			logger.info("Schedule Job started for " + ctx.getFireInstanceId());
			if (beneficiaryCallService != null)
			{
				beneficiaryCallService.unblockBlockedNumbers();
			} else
			{
				logger.info("Could not start unblocking blocked numbers as the beneficiaryCallService = "
						+ beneficiaryCallService);
			}
			logger.info("Schedule Job Completed for " + ctx.getFireInstanceId());
		} catch (Exception e)
		{
			logger.error("ScheduleJob failed with error " + e.getMessage(), e);
		}
	}
}
