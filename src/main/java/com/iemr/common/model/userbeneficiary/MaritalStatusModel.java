package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class MaritalStatusModel
{
	@Expose
	private Integer maritalStatusID;
	// private List<BeneficiaryModel> i_beneficiary;
	// private List<UserModel> m_user;
	@Expose
	private String status;
	@Expose
	private String statusDesc;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;

	// public static MaritalStatusModel createMaritalStatus(Integer msId, MaritalStatusRepository
	// maritalStatusRepository,
	// MaritalStatusMapper maritalStatusMapper)
	// {
	// MaritalStatusModel msModel = new MaritalStatusModel();
	// if (msId != null)
	// {
	// msModel = maritalStatusMapper
	// .maritalStatusToLoginResponse(maritalStatusRepository.findAciveMaritalStatusByID(msId));
	// }
	// return msModel;
	// }

	public MaritalStatusModel()
	{

	}
}
