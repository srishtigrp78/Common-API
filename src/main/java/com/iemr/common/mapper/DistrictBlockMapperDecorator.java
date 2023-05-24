package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.model.userbeneficiary.DistrictBlockModel;
import com.iemr.common.repository.location.LocationDistrictBlockRepository;

public abstract class DistrictBlockMapperDecorator implements DistrictBlockMapper 
{
	@Autowired
	LocationDistrictBlockRepository locationDistrictBlockRepository;
	
	public DistrictBlockModel districtBlockToModelByID(Integer blockID){
		DistrictBlockModel result = new DistrictBlockModel();
		result = districtBlockToModel(locationDistrictBlockRepository.findOne(blockID));
		return result;
	}
}
