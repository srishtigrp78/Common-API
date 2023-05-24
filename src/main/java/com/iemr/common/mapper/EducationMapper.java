package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.BeneficiaryEducation;
import com.iemr.common.model.beneficiary.BeneficiaryEducationModel;

@Mapper(componentModel = "spring")
@DecoratedWith(EducationMapperDecorator.class)
public interface EducationMapper
{
	EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);

	BeneficiaryEducationModel educationToModel(BeneficiaryEducation education);

	@IterableMapping(elementTargetType = BeneficiaryEducationModel.class)
	List<BeneficiaryEducationModel> educationToModel(List<BeneficiaryEducation> educations);

	BeneficiaryEducationModel educationToModelByID(Long education);

	@IterableMapping(elementTargetType = BeneficiaryEducationModel.class)
	List<BeneficiaryEducationModel> educationToModelByID(List<Long> educations);
}
