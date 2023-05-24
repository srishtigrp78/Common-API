package com.iemr.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.model.feedback.FeedbackDetailsModel;
import com.iemr.common.model.userbeneficiary.SexualOrientationModel;
import com.iemr.common.repository.userbeneficiarydata.SexualOrientationRepository;

@Mapper(componentModel = "spring", imports = { SexualOrientationModel.class })
public interface FeedbackDetailsMapper
{
	FeedbackDetailsMapper INSTANCE = Mappers.getMapper(FeedbackDetailsMapper.class);

	@Mappings({ @Mapping(target = "beneficiary.sexualOrientation", ignore = true
			// , source = "feedbackDetailsObj.beneficiary.sexualOrientation"
			), })
	FeedbackDetailsModel feedbackDetailsToLoginRole(FeedbackDetails feedbackDetailsObj,
			SexualOrientationRepository sexualOrientationRepository, SexualOrientationMapper sexualOrientationMapper);

	// @IterableMapping(elementTargetType = FeedbackDetailsModel.class)
	// List<FeedbackDetailsModel> feedbackDetailsToLoginRole(List<FeedbackDetails> feedbackDetailsObj);
}