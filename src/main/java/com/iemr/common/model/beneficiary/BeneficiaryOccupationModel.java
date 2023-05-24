package com.iemr.common.model.beneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class BeneficiaryOccupationModel
{
	@Expose
	private Long occupationID;
	// private List<BeneficiaryDemographicsModel> beneficiaryDemographicsModel;
	@Expose
	private String occupationType;

	// private Boolean deleted;
	// private String createdby;
	// private String modifiedby;
	public BeneficiaryOccupationModel()
	{

	}
}
