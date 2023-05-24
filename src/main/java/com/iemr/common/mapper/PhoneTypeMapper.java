package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.PhoneType;
import com.iemr.common.model.userbeneficiary.PhoneTypeModel;

@Mapper(componentModel = "spring")
public interface PhoneTypeMapper
{
	PhoneTypeMapper INSTANCE = Mappers.getMapper(PhoneTypeMapper.class);

	@Mappings({ @Mapping(source = "phoneTypeObj.phoneType", target = "phoneType"),
			@Mapping(source = "phoneTypeObj.phoneTypeID", target = "phoneTypeID"), })
	PhoneTypeModel phoneTypeToResponse(PhoneType phoneTypeObj);

	@IterableMapping(elementTargetType = PhoneTypeModel.class)
	List<PhoneTypeModel> phoneTypeToResponse(List<PhoneType> phoneTypeObj);
}
