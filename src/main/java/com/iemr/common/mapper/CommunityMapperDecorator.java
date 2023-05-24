package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.model.userbeneficiary.CommunityModel;
import com.iemr.common.repository.beneficiary.CommunityRepository;

public abstract class CommunityMapperDecorator implements CommunityMapper
{
	@Autowired
	CommunityRepository communityRepository;

	public CommunityModel communityToLoginResponseByID(Integer communityID)
	{
		CommunityModel model = new CommunityModel();
		model = communityToLoginResponse(communityRepository.findOne(communityID));
		return model;
	}

}
