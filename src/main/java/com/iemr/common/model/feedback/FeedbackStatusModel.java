package com.iemr.common.model.feedback;

import lombok.Data;

public @Data class FeedbackStatusModel
{
	private Integer feedbackStatusID;
	private String feedbackStatus;
	private String feedbackStatusDesc;
	private Integer providerServiceMapID;
	// private List<FeedbackDetailsModel> feedbackDetailsModel;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
