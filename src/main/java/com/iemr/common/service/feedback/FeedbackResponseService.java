package com.iemr.common.service.feedback;

import java.util.ArrayList;

import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.data.feedback.FeedbackResponse;
import com.iemr.common.utils.exception.IEMRException;

public interface FeedbackResponseService {
	public FeedbackResponse getFeedbackResponse(Long feedbackResponseID);

	public FeedbackResponse createFeedbackResponse(FeedbackResponse feedbackResponse);

	public String updateResponce(String string) throws IEMRException;

	public ArrayList<Object[]> getdataById(Long feedbackID);

	FeedbackRequest createFeedbackRequest(FeedbackRequest feedbackRequest);

}
