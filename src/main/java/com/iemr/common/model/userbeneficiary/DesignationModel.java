package com.iemr.common.model.userbeneficiary;

import lombok.Data;

public @Data class DesignationModel
{
	private Integer designationID;
	private String designationName;
	private String designationDesc;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
	// private List<FeedbackDetailsModel> feedbackDetails;
	// private List<UserModel> users;
}
