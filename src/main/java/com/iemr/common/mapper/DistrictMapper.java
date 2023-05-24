package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.location.Districts;
import com.iemr.common.model.userbeneficiary.DistrictModel;

@Mapper(componentModel="spring")
@DecoratedWith(DistrictMapperDecorator.class)
public interface DistrictMapper
{
	DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);
	
	DistrictModel districtToModel(Districts district);
	
	@IterableMapping(elementTargetType=DistrictModel.class)
	List<DistrictModel> districtToModel(List<Districts> district);
	
    DistrictModel districtToModelByID(Integer districtID);
	
	@IterableMapping(elementTargetType=DistrictModel.class)
	List<DistrictModel> districtToModelByID(List<Integer> districtID);
}
