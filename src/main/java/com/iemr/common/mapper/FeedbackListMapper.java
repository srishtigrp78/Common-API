package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.model.feedback.FeedbackListRequestModel;
import com.iemr.common.model.feedback.FeedbackListResponseModel;

@Mapper(componentModel = "spring")
public interface FeedbackListMapper
{
	FeedbackListMapper INSTANCE = Mappers.getMapper(FeedbackListMapper.class);

	@Mappings({ @Mapping(source = "feedbackDetailsObj.feedbackRequests", target = "feedbackRequests"),
			@Mapping(source = "feedbackDetailsObj.feedbackResponses", target = "feedbackResponses"),
			@Mapping(source = "feedbackDetailsObj.consolidatedRequests", target = "consolidatedRequests"),
			@Mapping(ignore = true, target = "beneficiary.sexualOrientation"), 
			@Mapping(source = "feedbackDetailsObj.requestID", target = "requestID"),
			@Mapping(source = "feedbackDetailsObj.feedbackNatureID", target = "feedbackNatureID"),})
	FeedbackListResponseModel feedbackDetailsToResponse(FeedbackDetails feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackListResponseModel.class)
	List<FeedbackListResponseModel> feedbackDetailsToResponse(List<FeedbackDetails> feedbackDetailsObj);

	FeedbackDetails requestToFeedbackDetails(FeedbackListRequestModel feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackDetails.class)
	List<FeedbackDetails> requestToFeedbackDetails(List<FeedbackListRequestModel> feedbackDetailsObj);
}