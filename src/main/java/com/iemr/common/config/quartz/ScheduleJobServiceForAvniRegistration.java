package com.iemr.common.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.service.door_to_door_app.DoorToDoorService;

@Service
@Transactional
public class ScheduleJobServiceForAvniRegistration implements Job {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private DoorToDoorService doorToDoorService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Started job for avni registration " + arg0.getClass().getName());
		try {
			doorToDoorService.scheduleJobForRegisterAvniBeneficiary();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("Unexpected error" , e);
		}
		logger.info("Completed job for avni registration " + arg0.getClass().getName());
	}
}
