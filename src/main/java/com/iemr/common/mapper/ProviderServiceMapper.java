package com.iemr.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.model.user.ProviderServiceMappingModel;

@Mapper(componentModel = "spring", imports = { RoleMapper.class })
public interface ProviderServiceMapper
{
	ProviderServiceMapper INSTANCE = Mappers.getMapper(ProviderServiceMapper.class);

	ProviderServiceMappingModel providerServiceMappingToModel(ProviderServiceMapping dto);
}
