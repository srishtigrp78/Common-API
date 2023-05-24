package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.beneficiary.BeneficiaryEducationModel;
import com.iemr.common.repository.beneficiary.EducationRepository;


public abstract class EducationMapperDecorator implements EducationMapper 
{
	@Autowired
	EducationRepository educationRepository;

	public BeneficiaryEducationModel educationToModelByID(Long educationID){
		BeneficiaryEducationModel educationModel = new BeneficiaryEducationModel();
		educationModel =educationToModel(educationRepository.findOne(educationID));
		return educationModel;
	}
}
