package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.location.CityDetails;
import com.iemr.common.model.userbeneficiary.CityModel;

@Mapper(componentModel = "spring")
public interface CityMapper
{
	CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

	CityModel cityDetailsToLoginResponse(CityDetails cityDetails);

	@IterableMapping(elementTargetType = CityModel.class)
	List<CityModel> cityDetailsToLoginResponse(List<CityDetails> cityDetails);
}
