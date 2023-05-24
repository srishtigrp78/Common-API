package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.Role;
import com.iemr.common.data.users.Screen;
import com.iemr.common.model.user.RoleModel;
import com.iemr.common.model.user.RoleFeatureOutputModel;
import com.iemr.common.model.user.ScreenModel;

@Mapper(componentModel = "spring")
public interface RoleMapper
{
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	RoleModel roleMappingToLoginRole(Role roleObj);

	@IterableMapping(elementTargetType = RoleModel.class)
	List<RoleModel> roleMappingToLoginRole(List<Role> roleObj);

	@Mappings({ @Mapping(source = "roleObj.serviceRoleScreenMappings", target = "featureName"),
			// @Mapping(source = "roleObj.serviceRoleScreenMappings.screen", target = "featureName.screen"),
	})
	RoleFeatureOutputModel roleFeatureMapping(Role roleObj);

	@IterableMapping(elementTargetType = RoleFeatureOutputModel.class)
	List<RoleFeatureOutputModel> roleFeatureMapping(List<Role> roleObj);

//	ScreenModel getScreenModel(Screen screen);
}
