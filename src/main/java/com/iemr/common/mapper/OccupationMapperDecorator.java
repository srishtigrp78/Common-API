package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.beneficiary.BeneficiaryOccupationModel;
import com.iemr.common.repository.beneficiary.BeneficiaryOccupationRepository;

public abstract class OccupationMapperDecorator implements OccupationMapper
{
	@Autowired
	BeneficiaryOccupationRepository occupationRepository;

	@Override
	public BeneficiaryOccupationModel occupationToModelByID(Integer occupationID)
	{
		BeneficiaryOccupationModel occupation = new BeneficiaryOccupationModel();
		occupation = occupationToModel(occupationRepository.findOne(Long.parseLong(occupationID + "")));
		return occupation;
	}
}
