package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.ReligionModel;
import com.iemr.common.repository.userbeneficiarydata.ReligionRepository;

public abstract class ReligionMapperDecorator implements ReligionMapper
{
	@Autowired
	ReligionRepository religionRepository;

	@Override
	public ReligionModel relegionToModelByID(Integer relegionID)
	{
		ReligionModel relegion = relegionToUserDemographics(religionRepository.findOne(relegionID));
		return relegion;
	}
}
