package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.model.userbeneficiary.DistrictBranchModel;
import com.iemr.common.repository.location.LocationDistrilctBranchRepository;


public abstract class DistrictBranchMapperDecorator implements DistrictBranchMapper
{
	@Autowired
	LocationDistrilctBranchRepository districtBranchRepository;
	
	public DistrictBranchModel districtBranchToModelByID(Integer villageId){
		DistrictBranchModel model = new DistrictBranchModel();
		model = districtBranchToModel(districtBranchRepository.findOne(villageId));
		return model;
	}
}
