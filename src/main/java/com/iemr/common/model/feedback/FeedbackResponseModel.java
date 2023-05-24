package com.iemr.common.model.feedback;

import java.sql.Timestamp;

import com.iemr.common.model.user.KMFileManagerModel;

import lombok.Data;

public @Data class FeedbackResponseModel
{
	private Long feedbackResponseID;
	private Long feedbackRequestID;
	private String responseSummary;
	private Integer authUserID;
	private String comments;
	private Long feedbackID;
	private String authName;
	private String authDesignation;
	// private FeedbackRequestModel feedbackRequestModel;
	// private FeedbackDetailsModel feedbackDetailsModel;
	private Integer feedbackStatusID;
	private Integer emailStatusID;
	private Integer kmFileManagerID;
	private KMFileManagerModel kmFileManager;
	private String attachmentPath;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
