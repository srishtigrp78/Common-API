package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.MaritalStatusModel;
import com.iemr.common.repository.userbeneficiarydata.MaritalStatusRepository;

public abstract class MaritalStatusMapperDecorator implements MaritalStatusMapper
{
	@Autowired
	MaritalStatusRepository maritalStatusRepository;
	
	public MaritalStatusModel maritalStatusByIDToResponse(Integer msId){
		MaritalStatusModel msModel = new MaritalStatusModel();
		if (msId != null)
		{
			msModel = maritalStatusToLoginResponse(maritalStatusRepository.findAciveMaritalStatusByID(msId));
		}
		return msModel;
	}
}
