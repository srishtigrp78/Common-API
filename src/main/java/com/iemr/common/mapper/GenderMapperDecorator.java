package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.GenderModel;
import com.iemr.common.repository.userbeneficiarydata.GenderRepository;

public abstract class GenderMapperDecorator implements GenderMapper

{
	@Autowired
	GenderRepository genderRepository;

	public GenderModel genderByIDToLoginResponse(Integer genderId)
	{
		GenderModel genderModel = new GenderModel();
		if (genderId != null)
		{
			genderModel = genderToLoginResponse(genderRepository.findGendersByID(genderId));
		}
		return genderModel;
	}
}
