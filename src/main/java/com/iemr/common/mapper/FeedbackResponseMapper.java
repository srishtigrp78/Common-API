package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackResponse;
import com.iemr.common.model.feedback.FeedbackResponseModel;

@Mapper(componentModel = "spring")
public interface FeedbackResponseMapper
{
	FeedbackResponseMapper INSTANCE = Mappers.getMapper(FeedbackResponseMapper.class);

	FeedbackResponseModel feedbackDetailsToResponse(FeedbackDetails feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackResponseModel.class)
	List<FeedbackResponseModel> feedbackDetailsToResponse(List<FeedbackResponse> feedbackDetailsObj);

	FeedbackResponse requestToFeedbackDetails(FeedbackResponseModel feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackResponse.class)
	List<FeedbackResponse> requestToFeedbackDetails(List<FeedbackResponseModel> feedbackDetailsObj);
}