package com.iemr.common.model.userbeneficiary;

import lombok.Data;

public @Data class EmailStatusModel
{
	private Integer emailStatusID;
	private String emailStatus;
	private String emailStatusDesc;
	// private List<FeedbackDetailsModel> feedbackDetailsModel;
	// private List<FeedbackRequestModel> feedbackRequestModels;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
