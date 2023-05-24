package com.iemr.common.service.feedback;

import java.util.List;

import com.iemr.common.data.feedback.FeedbackSeverity;

public interface FeedbackSeverityService {
	
	List<FeedbackSeverity> getActiveFeedbackSeverity();
	
	List<FeedbackSeverity> getActiveFeedbackSeverity(Integer providerServiceMapID);
}
