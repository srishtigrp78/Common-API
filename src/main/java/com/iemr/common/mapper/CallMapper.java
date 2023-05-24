package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.model.beneficiary.BeneficiaryCallModel;

@Mapper(componentModel = "spring")
public interface CallMapper
{

	CallMapper INSTANCE = Mappers.getMapper(CallMapper.class);

	BeneficiaryCallModel beneficiaryCallToModel(BeneficiaryCall beneficiaryCall);

	@IterableMapping(elementTargetType = BeneficiaryCallModel.class)
	List<BeneficiaryCallModel> beneficiaryCallToModel(List<BeneficiaryCall> beneficiariesDTOList);

}
