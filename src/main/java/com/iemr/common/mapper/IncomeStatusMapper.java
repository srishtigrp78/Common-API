package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.BeneficiaryIncomeStatus;
import com.iemr.common.model.beneficiary.BeneficiaryIncomeStatusModel;

@Mapper(componentModel = "spring")
@DecoratedWith(IncomeStatusMapperDecorator.class)
public interface IncomeStatusMapper
{
	IncomeStatusMapper INSTANCE = Mappers.getMapper(IncomeStatusMapper.class);

	@Mappings({ @Mapping(expression = "java(incomeStatus.getIncomeStatus())", target = "incomeStatus"),
			@Mapping(expression = "java(incomeStatus.getIncomeStatusID())", target = "incomeStatusID"), })
	BeneficiaryIncomeStatusModel incomeStatusToModel(BeneficiaryIncomeStatus incomeStatus);

	@IterableMapping(elementTargetType = BeneficiaryIncomeStatusModel.class)
	List<BeneficiaryIncomeStatusModel> incomeStatusToModel(List<BeneficiaryIncomeStatusModel> incomeStatuses);

	BeneficiaryIncomeStatusModel incomeStatusByIDToModel(Integer incomeStatusID);

	@IterableMapping(elementTargetType = BeneficiaryIncomeStatusModel.class)
	List<BeneficiaryIncomeStatusModel> incomeStatusByIDToModel(List<Integer> incomeStatusIDs);
}