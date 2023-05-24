package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.UserLangMapping;
import com.iemr.common.model.user.UserLangMappingModel;

@Mapper(componentModel = "spring")
public interface UserLangMapper
{
	UserLangMapper INSTANCE = Mappers.getMapper(UserLangMapper.class);

	UserLangMappingModel userLangMappingToLoginRole(UserLangMapping m_UserLangMapping);

	@InheritInverseConfiguration
	UserLangMapping userLangMappingToDTO(UserLangMappingModel userLangMapping);

	@IterableMapping(elementTargetType = UserLangMappingModel.class)
	List<UserLangMappingModel> userLangMappingToLoginRole(List<UserLangMapping> m_UserLangMappings);

	@IterableMapping(elementTargetType = UserLangMapping.class)
	List<UserLangMapping> userLangMappingToDTO(List<UserLangMappingModel> userLangMapping);

}
