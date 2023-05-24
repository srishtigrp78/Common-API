package com.iemr.common.model.feedback;

import lombok.Data;

public @Data class FeedbackNatureDetailModel
{
	private Integer feedbackNatureID;
	private String feedbackNature;
	private String feedbackNatureDesc;
	private Integer feedbackTypeID;
	private String feedbackTypeName;
	// private List<FeedbackDetailsModel> feedbackDetailsModel;
	private Boolean deleted;
	// private String createdBy;
	// private Date createdDate;
	// private String modifiedBy;
	// private Date lastModDate;
}
