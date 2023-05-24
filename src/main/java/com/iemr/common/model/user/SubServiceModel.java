package com.iemr.common.model.user;

import lombok.Data;

public @Data class SubServiceModel
{
	private Integer subServiceID;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel service;
	private String subServiceName;
	private String subServiceDesc;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
