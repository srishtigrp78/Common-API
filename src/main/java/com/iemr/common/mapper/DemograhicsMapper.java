package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.dto.identity.Address;
import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;

@Mapper(componentModel = "spring")
public interface DemograhicsMapper
{

	DemograhicsMapper INSTANCE = Mappers.getMapper(DemograhicsMapper.class);

	BeneficiaryDemographicsModel benDemographicsToModel(BenDemographics demographics);

	@IterableMapping(elementTargetType = BeneficiaryDemographicsModel.class)
	List<BeneficiaryDemographicsModel> benDemographicsToModel(List<BenDemographics> demographics);

	BeneficiaryDemographicsModel benAddressToDemographicsModel(Address address);

	@IterableMapping(elementTargetType = BeneficiaryDemographicsModel.class)
	List<BeneficiaryDemographicsModel> benAddressToDemographicsModel(List<Address> addresses);
}
