package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class StateModel
{
	@Expose
	private Integer stateID;
	// private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	@Expose
	private String stateName;
	@Expose
	private String stateCode;
	@Expose
	private Integer countryID;
	// private Boolean deleted;
	// private String createdBy;
	// private String modifiedBy;
	// private Timestamp createdDate;
	// private Timestamp lastModDate;
	// private Set<Districts> districts;
	// private Set<InstituteModel> institutes;

//	public static StateModel getState(Integer stateID, LocationStateRepository locationStateRepo,
//			StateMapper stateMapper2)
//	{
//		StateModel state = new StateModel();
//		state = stateMapper2.StateToModel(locationStateRepo.findByStateID(stateID));
//		return state;
//	}
}
