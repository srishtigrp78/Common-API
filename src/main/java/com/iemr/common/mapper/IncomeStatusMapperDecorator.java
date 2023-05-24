package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.beneficiary.BeneficiaryIncomeStatusModel;
import com.iemr.common.repository.beneficiary.IncomeStatusRepository;

public abstract class IncomeStatusMapperDecorator implements IncomeStatusMapper
{
	@Autowired
	IncomeStatusRepository incomeStatusRepository;

	@Override
	public BeneficiaryIncomeStatusModel incomeStatusByIDToModel(Integer incomeStatusID)
	{
		BeneficiaryIncomeStatusModel model = incomeStatusToModel(incomeStatusRepository.findOne(incomeStatusID));
		return model;
	}
}
