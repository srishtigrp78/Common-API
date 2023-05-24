package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class ReligionModel
{
	@Expose
	private Integer religionID;
	// private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	// private Set<UserDemographicsModel> usersDemographics;
	@Expose
	private String religionType;
	@Expose
	private String religionDesc;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
