package com.iemr.common.model.beneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class BeneficiaryEducationModel
{
	@Expose
	private Long educationID;
	// private List<BeneficiaryDemographicsModel> beneficiaryDemographicsModel;
	@Expose
	private String educationType;
	// private Boolean deleted;
	// private String createdBy;
	// private String modifiedBy;

	// public static BeneficiaryEducationModel createEducationModel(Integer educationID,
	// EducationRepository educationRepository, EducationMapper educationMapper)
	// {
	// BeneficiaryEducationModel educationModel = new BeneficiaryEducationModel();
	// educationModel =
	// educationMapper.educationToModel(educationRepository.findOne(Long.parseLong(educationID.toString())));
	// return educationModel;
	// }
}
