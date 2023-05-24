package com.iemr.common.model.feedback;

import lombok.Data;

public @Data class FeedbackSeverityModel
{
	private Integer severityID;
	// private Set<FeedbackDetailsModel> feedbacks;
	private String severityTypeName;
	private String severityDesc;
	// private Integer providerServiceMapID;
	// private ProviderServiceMappingModel providerServiceMappingModel;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
