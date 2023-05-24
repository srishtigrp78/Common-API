package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.userbeneficiarydata.Religion;
import com.iemr.common.model.userbeneficiary.ReligionModel;

@Mapper(componentModel = "spring")
@DecoratedWith(ReligionMapperDecorator.class)
public interface ReligionMapper
{
	ReligionMapper INSTANCE = Mappers.getMapper(ReligionMapper.class);

	ReligionModel relegionToUserDemographics(Religion religion);

	@IterableMapping(elementTargetType = ReligionMapper.class)
	List<ReligionModel> relegionToUserDemographics(List<Religion> religions);

	ReligionModel relegionToModelByID(Integer relegionID);
}
