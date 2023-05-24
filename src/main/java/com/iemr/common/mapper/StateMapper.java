package com.iemr.common.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.location.States;
import com.iemr.common.model.userbeneficiary.StateModel;

@Mapper(componentModel="spring")
@DecoratedWith(StateMapperDecorator.class)
public interface StateMapper
{
	StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);
	
	StateModel StateToModel(States state);
	StateModel StateToModelByID(Integer stateID);
}
