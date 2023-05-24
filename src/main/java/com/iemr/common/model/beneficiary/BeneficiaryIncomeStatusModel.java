package com.iemr.common.model.beneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class BeneficiaryIncomeStatusModel
{
	@Expose
	private Integer incomeStatusID;
	// private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	@Expose
	private String incomeStatus;

	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
	public BeneficiaryIncomeStatusModel()
	{

	}
}
