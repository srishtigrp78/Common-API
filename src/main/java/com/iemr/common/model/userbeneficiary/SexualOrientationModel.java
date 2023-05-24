package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;
import com.iemr.common.mapper.SexualOrientationMapper;
import com.iemr.common.repository.userbeneficiarydata.SexualOrientationRepository;

import lombok.Data;

public @Data class SexualOrientationModel
{
	@Expose
	private Short sexualOrientationId;
	// private List<BeneficiaryModel> i_Beneficiaries;
	@Expose
	private String sexualOrientation;
	@Expose
	private String sexualOrientationDesc;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;

	public static SexualOrientationModel createSexualOrientation(Short sexualOrientationId,
			SexualOrientationRepository sexualOrientationRepository, SexualOrientationMapper sexualOrientationMapper)
	{
		SexualOrientationModel model = null;
		if (sexualOrientationId != null)
		{
			model = sexualOrientationMapper
					.sexualOrientationToModel(sexualOrientationRepository.findOne(sexualOrientationId));
		}
		return model;
	}
}
