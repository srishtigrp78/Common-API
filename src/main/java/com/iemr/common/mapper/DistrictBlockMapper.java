package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.model.userbeneficiary.DistrictBlockModel;

@Mapper(componentModel = "spring")
@DecoratedWith(DistrictBlockMapperDecorator.class)
public interface DistrictBlockMapper
{
	DistrictBlockMapper INSTANCE = Mappers.getMapper(DistrictBlockMapper.class);

	DistrictBlockModel districtBlockToModel(DistrictBlock districtBlock);

	@IterableMapping(elementTargetType = DistrictBlockModel.class)
	List<DistrictBlockModel> districtBlockToModel(List<DistrictBlock> districtBlock);

	DistrictBlockModel districtBlockToModelByID(Integer districtBlock);

	@IterableMapping(elementTargetType = DistrictBlockModel.class)
	List<DistrictBlockModel> districtBlockToModelByID(List<Integer> districtBlock);
}
