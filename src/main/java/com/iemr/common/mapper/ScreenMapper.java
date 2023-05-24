package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.Screen;
import com.iemr.common.data.users.ServiceRoleScreenMapping;
import com.iemr.common.model.user.ScreenModel;
import com.iemr.common.model.user.ServiceRoleScreenMappingModel;

@Mapper
public interface ScreenMapper
{
	ScreenMapper INSTANCE = Mappers.getMapper(ScreenMapper.class);

	ScreenModel screenToModel(Screen screenObj);

	@IterableMapping(elementTargetType = ScreenModel.class)
	List<ScreenModel> screenToModel(List<Screen> screenObj);

	ServiceRoleScreenMappingModel roleScreenMappingToModel(ServiceRoleScreenMapping obj);

	@IterableMapping(elementTargetType = ServiceRoleScreenMappingModel.class)
	List<ServiceRoleScreenMappingModel> roleScreenMappingToModel(List<ServiceRoleScreenMapping> screenObj);

}
