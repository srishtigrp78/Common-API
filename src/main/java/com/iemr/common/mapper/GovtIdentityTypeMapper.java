package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.dto.identity.BenIdentityDTO;
import com.iemr.common.model.userbeneficiary.BeneficiaryIdentityModel;
import com.iemr.common.model.userbeneficiary.GovtIdentityTypeModel;

@Mapper(componentModel = "spring")
@DecoratedWith(GovtIdentityTypeDecorator.class)
public interface GovtIdentityTypeMapper
{
	GovtIdentityTypeMapper INSTANCE = Mappers.getMapper(GovtIdentityTypeMapper.class);

	GovtIdentityTypeModel getGovtIdentity(GovtIdentityType govtIdentityType);

	GovtIdentityTypeModel govtIdentityTypeModelByIDToModel(Integer govtIdentityTypeModelID);

	BeneficiaryIdentityModel govtIdentityTypeModelsByIDToModel(BenIdentityDTO identityDTO);

	List<BeneficiaryIdentityModel> govtIdentityTypeModelsByIDToModel(List<BenIdentityDTO> identityDTOs);
}
