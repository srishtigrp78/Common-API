package com.iemr.common.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.model.userbeneficiary.StatusModel;

@Mapper(componentModel = "spring")
@DecoratedWith(StatusMapperDecorator.class)

public interface StatusMapper
{
	StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

	StatusModel statusToModel(Status status);

	StatusModel statusToModelByID(Integer statusID);
}
