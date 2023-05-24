package com.iemr.common.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.model.beneficiary.BeneficiaryOccupationModel;

@Mapper(componentModel = "spring")
@DecoratedWith(OccupationMapperDecorator.class)
public interface OccupationMapper
{
	OccupationMapper INSTANCE = Mappers.getMapper(OccupationMapper.class);

	BeneficiaryOccupationModel occupationToModel(BeneficiaryOccupation occupation);

	BeneficiaryOccupationModel occupationToModelByID(Integer occupationID);

}
