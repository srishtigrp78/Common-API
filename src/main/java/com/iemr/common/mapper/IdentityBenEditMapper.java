package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.dto.identity.Address;
import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.Contact;
import com.iemr.common.dto.identity.Identity;
import com.iemr.common.dto.identity.IdentityEditDTO;
import com.iemr.common.dto.identity.IdentitySearchDTO;
import com.iemr.common.model.beneficiary.BeneficiaryModel;

@Mapper(componentModel = "spring", imports = { Address.class, BenFamilyDTO.class, Contact.class, Identity.class })
@DecoratedWith(IdentityBenEditMapperDecorator.class)
public interface IdentityBenEditMapper
{

	IdentityBenEditMapper INSTANCE = Mappers.getMapper(IdentityBenEditMapper.class);

	@Mappings({ @Mapping(expression = "java(beneficiary.getStatus().getStatus())", target = "status"),
			@Mapping(expression = "java(beneficiary.getMaritalStatus().getStatus())", target = "maritalStatus"), })
	IdentityEditDTO BenToIdentityEditMapper(BeneficiaryModel beneficiary);

	@IterableMapping(elementTargetType = IdentityEditDTO.class)
	List<IdentityEditDTO> benToIdentityEditMapperList(List<BeneficiaryModel> beneficiaryModelList);

	@Mappings({
			@Mapping(expression = "java(Address.bendemographicsAddressMapper(beneficiary.getI_bendemographics()))",
					target = "currentAddress"),
			@Mapping(expression = "java(Address.bendemographicsAddressMapper(beneficiary.getI_bendemographics()))",
					target = "permanentAddress"),
			@Mapping(expression = "java(Address.bendemographicsAddressMapper(beneficiary.getI_bendemographics()))",
					target = "emergencyAddress"),
			@Mapping(source = "beneficiary.firstName", target = "firstName"),
			@Mapping(source = "beneficiary.lastName", target = "lastName"),
			@Mapping(source = "beneficiary.genderID", target = "genderId"),})
	IdentitySearchDTO getidentitysearchModel(BeneficiaryModel beneficiary);
}
