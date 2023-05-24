package com.iemr.common.model.user;

import lombok.Data;

public @Data class ScreenModel
{
	private Integer screenID;
	// private List<ServiceRoleScreenMappingModel> serviceRoleScreenMappingModels;
	private String screenName;
	private String apiUsed;
	private String workflowName;
	private String screenDesc;
	private Integer providerServiceMapID;
	// private ProviderServiceMappingModel providerServiceMappingModel;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
