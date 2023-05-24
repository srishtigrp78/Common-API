package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.institute.Designation;
import com.iemr.common.model.userbeneficiary.DesignationModel;

@Mapper(componentModel = "spring")
public interface DesignationMapper
{
	DesignationMapper INSTANCE = Mappers.getMapper(DesignationMapper.class);

	DesignationModel maritalStatusToLoginResponse(Designation gender);

	@IterableMapping(elementTargetType = DesignationModel.class)
	List<DesignationModel> genderToLoginResponse(List<Designation> gender);
}