package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.model.userbeneficiary.CommunityModel;

@Mapper(componentModel = "spring")
@DecoratedWith(CommunityMapperDecorator.class)
public interface CommunityMapper
{
	CommunityMapper INSTANCE = Mappers.getMapper(CommunityMapper.class);
	
	CommunityModel communityToLoginResponse(Community communityObject);
	
	@IterableMapping(elementTargetType=CommunityModel.class)
	List<CommunityModel> communityToLoginResponse(List<Community> communityObject);
	
	CommunityModel communityToLoginResponseByID(Integer communityID);
	
	@IterableMapping(elementTargetType=CommunityModel.class)
	List<CommunityModel> communityToLoginResponseByID(List<Integer> communityIDs);
}
