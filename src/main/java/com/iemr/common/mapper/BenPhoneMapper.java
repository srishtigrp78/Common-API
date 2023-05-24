package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.dto.identity.BeneficiariesDTO;
import com.iemr.common.model.beneficiary.BenPhoneMapModel;

@Mapper(componentModel = "spring")
@DecoratedWith(BenPhoneMapperDecorator.class)
public interface BenPhoneMapper
{
	BenPhoneMapper INSTANCE = Mappers.getMapper(BenPhoneMapper.class);

	// @Mappings({
	// @Mapping(target="")
	// })
	BenPhoneMapModel benPhoneMapToResponse(BenPhoneMap benPhoneMap);

	@IterableMapping(elementTargetType = BenPhoneMapModel.class)
	List<BenPhoneMapModel> benPhoneMapToResponse(List<BenPhoneMap> benPhoneMap);
	
//	BenPhoneMapModel benPhoneMapToResponseByDTO(BeneficiariesDTO beneficiariesDTO);
//	
//	List<BenPhoneMapModel> benPhoneMapToResponseByID(BeneficiariesDTO beneficiariesDTO);

//	@IterableMapping(elementTargetType = BenPhoneMapModel.class)
//	List<List<BenPhoneMapModel>> benPhoneMapToResponseByID(List<BeneficiariesDTO> beneficiariesDTO);

	// @Mappings({ @Mapping(source = "benFamilyDTO.benFamilyMapId", target = "benPhMapID"),
	// @Mapping(source = "benFamilyDTO.associatedBenRegId", target = "parentBenRegID"),
	// @Mapping(source = "benFamilyDTO.relationshipID", target = "benRelationshipID"),
	// @Mapping(source = "phone.phoneType", target = "benRelationshipID"),
	// @Mapping(source = "phone.relationshipID", target = "benRelationshipID"),
	// // @Mapping(source="benFamilyDTO.benFamilyMapId", target=""),
	// })
	// BenPhoneMapModel benPhoneMapToResponse(BenFamilyDTO benFamilyDTO, Phone phone, Long benRegID);

	// @IterableMapping(elementTargetType=BenPhoneMapModel.class)

	// @Mappings({ @Mapping(target=) })
	// List<BenPhoneMapModel> benPhoneMapToResponse(List<BenFamilyDTO> benFamilyDTO, List<Phone> phone, Long benRegID);

}
