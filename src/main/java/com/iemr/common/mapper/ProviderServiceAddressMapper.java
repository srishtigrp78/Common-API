package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.ProviderServiceAddressMapping;
import com.iemr.common.model.user.ProviderServiceAddressMappingModel;

@Mapper(componentModel = "spring")
public interface ProviderServiceAddressMapper
{
	ProviderServiceAddressMapper INSTANCE = Mappers.getMapper(ProviderServiceAddressMapper.class);

	// @Mappings({ @Mapping(source = "addressObj.pSAddMapID", target = "pSAddMapID"),
	// @Mapping(source = "addressObj.providerServiceMapID", target = "providerServiceMapID"),
	// @Mapping(source = "addressObj.districtID", target = "districtID"),
	// @Mapping(source = "addressObj.address", target = "address"), })
	ProviderServiceAddressMappingModel providerAddressToLoginResponse(ProviderServiceAddressMapping addressObj);

	@IterableMapping(elementTargetType = ProviderServiceAddressMappingModel.class)
	List<ProviderServiceAddressMappingModel> providerAddressToLoginResponse(
			List<ProviderServiceAddressMapping> addressObj);
}
