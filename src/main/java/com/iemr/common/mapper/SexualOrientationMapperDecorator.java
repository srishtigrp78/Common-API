package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.SexualOrientationModel;
import com.iemr.common.repository.userbeneficiarydata.SexualOrientationRepository;

public abstract class SexualOrientationMapperDecorator implements SexualOrientationMapper
{
	@Autowired
	SexualOrientationRepository sexualOrientationRepository;

	public SexualOrientationModel sexualOrientationByIDToModel(Short sexualOrientationID)
	{
		SexualOrientationModel model = null;
		if (sexualOrientationID != null)
		{
			model = sexualOrientationToModel(sexualOrientationRepository.findOne(sexualOrientationID));
		}
		return model;
	}
}
