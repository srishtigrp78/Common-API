package com.iemr.common.model.user;

import java.sql.Timestamp;

import lombok.Data;

public @Data class PhoneBlockModel
{
	private Long phoneBlockID;
	private String phoneNo;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Integer noOfNuisanceCall;
	private Boolean isBlocked;
	private String ctiCampaignName;
	private Timestamp blockStartDate;
	private Timestamp blockEndDate;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
