package com.iemr.common.service.feedback;

import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.utils.exception.IEMRException;

public interface FeedbackRequestService {

	public FeedbackRequest getFeedbackReuest(Long feedbackRequestID);

//	public FeedbackRequest createFeedbackRequest(FeedbackRequest i_feedbackrequest);

	public String getAllFeedback(String feedbackrequest) throws IEMRException;

	String createFeedbackRequest(String request) throws IEMRException;

	
}
