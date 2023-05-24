package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.ServiceRoleScreenMapping;
import com.iemr.common.model.user.ServiceRoleScreenMappingModel;

@Mapper(componentModel = "spring")
public interface LoginRoleScreenMapper
{
	LoginRoleScreenMapper INSTANCE = Mappers.getMapper(LoginRoleScreenMapper.class);

	ServiceRoleScreenMappingModel roleMappingToRole(ServiceRoleScreenMapping roleObj);

	@IterableMapping(elementTargetType = ServiceRoleScreenMappingModel.class)
	List<ServiceRoleScreenMappingModel> roleMappingToRole(List<ServiceRoleScreenMapping> roleObj);
}