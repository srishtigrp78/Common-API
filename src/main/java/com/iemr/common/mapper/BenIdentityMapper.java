
package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.dto.identity.BenDetailForOutboundDTO;

@Mapper(componentModel = "spring")
public interface BenIdentityMapper
{

	BenIdentityMapper INSTANCE = Mappers.getMapper(BenIdentityMapper.class);

	@Mappings({ @Mapping(source = "benDetailForOutboundDTO.benRegId", target = "beneficiaryRegID"),
			@Mapping(source = "benDetailForOutboundDTO.middleName", target = "middleName") })
	// @Mappings({ @Mapping(source = "benDetailForOutboundDTO.middleName", target = "middleName")})
	Beneficiary benDetailForOutboundDTOToIBeneficiary(BenDetailForOutboundDTO benDetailForOutboundDTO);

	@IterableMapping(elementTargetType = Beneficiary.class)
	List<Beneficiary> identityApiToBeneficiary(List<BenDetailForOutboundDTO> benDetailForOutboundDTOList);

	// BenPhoneMapModel benPhoneMapToResponse(BenPhoneMap benPhoneMap);
	//
	// @IterableMapping(elementTargetType = BenPhoneMapModel.class)
	// List<BenPhoneMapModel> benPhoneMapToResponse(List<BenPhoneMap> benPhoneMap);

}
