package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.model.userbeneficiary.MaritalStatusModel;

@Mapper(componentModel = "spring")
@DecoratedWith(MaritalStatusMapperDecorator.class)
public interface MaritalStatusMapper
{
	MaritalStatusMapper INSTANCE = Mappers.getMapper(MaritalStatusMapper.class);

	MaritalStatusModel maritalStatusToLoginResponse(MaritalStatus mstatus);

	@IterableMapping(elementTargetType = MaritalStatusModel.class)
	List<MaritalStatusModel> genderToLoginResponse(List<MaritalStatus> mstatus);
	
	MaritalStatusModel maritalStatusByIDToResponse(Integer mstatusID);

	@IterableMapping(elementTargetType = MaritalStatusModel.class)
	List<MaritalStatusModel> genderByIDToResponse(List<Integer> mstatusID);
}