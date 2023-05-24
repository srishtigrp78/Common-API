package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.model.userbeneficiary.GenderModel;

@Mapper(componentModel = "spring")
@DecoratedWith(GenderMapperDecorator.class)
public interface GenderMapper
{
	GenderMapper INSTANCE = Mappers.getMapper(GenderMapper.class);

	GenderModel genderToLoginResponse(Gender gender);

	@IterableMapping(elementTargetType = GenderModel.class)
	List<GenderModel> genderToLoginResponse(List<Gender> gender);

	GenderModel genderByIDToLoginResponse(Integer genderID);

	@IterableMapping(elementTargetType = GenderModel.class)
	List<GenderModel> genderbyIDToLoginResponse(List<Integer> genderID);
}
