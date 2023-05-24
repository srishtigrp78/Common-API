package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.user.HealthCareWorkerModel;
import com.iemr.common.repository.users.HealthCareWorkerRepository;

public abstract class HealthCareWorkerMapperDecorator implements HealthCareWorkerMapper
{
	@Autowired
	HealthCareWorkerRepository healthCareWorkerRepository;

	@Override
	public HealthCareWorkerModel getModelByWorkerID(Short workerID)
	{
		HealthCareWorkerModel model = null;
		if (workerID != null)
		{
			model = getModelByWorker(healthCareWorkerRepository.findOne(workerID));
		}
		return model;
	}
}
