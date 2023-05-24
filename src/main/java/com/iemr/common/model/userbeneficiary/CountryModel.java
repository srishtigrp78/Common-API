package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class CountryModel
{
	@Expose
	private Integer countryID;
	// private List<BeneficiaryDemographicsModel> i_bendemographics;
	// private List<UserDemographicsModel> m_userdemographics;
	@Expose
	private String countryName;
	@Expose
	private String countryCode;
	@Expose
	private String continent;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}