package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.location.Country;
import com.iemr.common.model.userbeneficiary.CountryModel;

@Mapper(componentModel = "spring")
public interface CountryMapper
{
	CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

	CountryModel countryToResponse(Country countryObj);
	
	@InheritInverseConfiguration
	Country requestToCountry(CountryModel requestObj);
	
	@IterableMapping(elementTargetType = CountryModel.class)
	List<CountryModel> countryToResponse(List<Country> countryObj);
}
