package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.StatusModel;
import com.iemr.common.repository.userbeneficiarydata.StatusRepository;

public abstract class StatusMapperDecorator implements StatusMapper
{
	@Autowired
	StatusRepository statusRepository;

	@Override
	public StatusModel statusToModelByID(Integer statusID)
	{
		StatusModel status = new StatusModel();
		status = statusToModel(statusRepository.findOne(statusID));
		return status;
	};

}
