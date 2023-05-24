package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.DistrictModel;
import com.iemr.common.repository.location.LocationDistrictRepository;

public abstract class DistrictMapperDecorator implements DistrictMapper
{
	@Autowired
	LocationDistrictRepository locationDistrictRepository;
	
	public DistrictModel districtToModelByID(Integer districtID){
		DistrictModel district = new DistrictModel();
		district = districtToModel(locationDistrictRepository.findOne(districtID));
		return district;
	}
	
}
