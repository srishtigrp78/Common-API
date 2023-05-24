package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.model.feedback.FeedbackRequestModel;

@Mapper(componentModel = "spring")
public interface FeedbackRequestMapper
{
	FeedbackRequestMapper INSTANCE = Mappers.getMapper(FeedbackRequestMapper.class);

	FeedbackRequestModel feedbackDetailsToResponse(FeedbackRequest feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackRequestModel.class)
	List<FeedbackRequestModel> feedbackDetailsToResponse(List<FeedbackRequest> feedbackDetailsObj);

	FeedbackRequest requestToFeedbackDetails(FeedbackRequestModel feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackRequest.class)
	List<FeedbackRequest> requestToFeedbackDetails(List<FeedbackRequestModel> feedbackDetailsObj);
}