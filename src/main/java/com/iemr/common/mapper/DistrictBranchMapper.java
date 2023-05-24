package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.model.userbeneficiary.DistrictBranchModel;

@Mapper(componentModel = "spring")
@DecoratedWith(DistrictBranchMapperDecorator.class)
public interface DistrictBranchMapper
{
	DistrictBranchMapper districtBranchMapper = Mappers.getMapper(DistrictBranchMapper.class);

	DistrictBranchModel districtBranchToModel(DistrictBranchMapping districtBranchMapping);

	@IterableMapping(elementTargetType = DistrictBranchModel.class)
	List<DistrictBranchModel> districtBranchToModel(List<DistrictBranchMapping> districtBranchMapping);

	DistrictBranchModel districtBranchToModelByID(Integer districtBranchMapping);

	@IterableMapping(elementTargetType = DistrictBranchModel.class)
	List<DistrictBranchModel> districtBranchToModelByID(List<Integer> districtBranchMapping);
}
