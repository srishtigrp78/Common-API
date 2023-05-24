package com.iemr.common.model.feedback;

import java.sql.Timestamp;

import com.iemr.common.model.user.KMFileManagerModel;
import com.iemr.common.model.userbeneficiary.EmailStatusModel;

import lombok.Data;

public @Data class FeedbackRequestModel
{
	private Long feedbackRequestID;
	private Long feedbackID;
	// private FeedbackDetailsModel feedbackDetailsModel;
	private String feedbackSupSummary;
	private Integer supUserID;
	private String comments;
	private Integer emailStatusID;
	private EmailStatusModel emailStatus;
	private Integer feedbackStatusID;
	private String responseSummary;
	private String responseComments;
	private String responseUpdatedBy;
	private Timestamp responseDate;
	private KMFileManagerModel kmFileManager;
	private String attachmentPath;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
