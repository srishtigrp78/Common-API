package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class LanguageModel
{
	@Expose
	private Integer languageID;
	// private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	// private List<UserLangMappingModel> userLangMappingModels;
	// private List<NotificationModel> notificationModels;
	@Expose
	private String languageName;
	@Expose
	private String languageDesc;
	@Expose
	private String propertyFilePath;
	@Expose
	private String ivrFilePath;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
