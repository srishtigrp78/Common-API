package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.UserServiceRoleMapping;
import com.iemr.common.model.user.UserServiceRoleMappingModel;

@Mapper(componentModel = "spring")
public interface UserServiceRoleMapper
{
	UserServiceRoleMapper INSTANCE = Mappers.getMapper(UserServiceRoleMapper.class);

	UserServiceRoleMappingModel userRoleToLoginUserRole(UserServiceRoleMapping dto);
	
	@IterableMapping(elementTargetType=UserServiceRoleMappingModel.class)
	List<UserServiceRoleMappingModel> userRoleToLoginUserRole(List<UserServiceRoleMapping> dto);
}
