package com.iemr.common.model.feedback;

import lombok.Data;

public @Data class FeedbackTypeModel
{
	private Integer feedbackTypeID;
	// private Set<FeedbackDetailsModel> feedbacks;
	private String feedbackTypeName;
	private String feedbackDesc;
	// private Integer providerServiceMapID;
	// private ProviderServiceMappingModel providerServiceMappingModel;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
