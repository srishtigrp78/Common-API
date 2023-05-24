package com.iemr.common.service.feedback;

import java.util.List;

import com.iemr.common.data.feedback.FeedbackType;

public interface FeedbackTypeService
{

	List<FeedbackType> getActiveFeedbackTypes();

	List<FeedbackType> getActiveFeedbackTypes(Integer providerServiceMapID);
}
