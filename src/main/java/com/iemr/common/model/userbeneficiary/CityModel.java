package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class CityModel
{
	@Expose
	private Integer cityID;
	// private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	@Expose
	private String cityName;
	@Expose
	private Integer districtID;
	@Expose
	private Integer stateID;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
