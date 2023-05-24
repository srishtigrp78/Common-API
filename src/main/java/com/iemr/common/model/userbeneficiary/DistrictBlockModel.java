package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class DistrictBlockModel
{
	@Expose
	private Integer blockID;
	// private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	// private List<InstituteModel> institutes;
	@Expose
	private Integer districtID;
	@Expose
	private String blockName;
	@Expose
	private Integer stateID;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;

	// public static DistrictBlockModel createDistrictBlock(Integer blockID,
	// LocationDistrictBlockRepository locationDistrictBlockRepository, DistrictBlockMapper districtBlockMapper)
	// {
	// DistrictBlockModel result = new DistrictBlockModel();
	// result = districtBlockMapper.districtBlockToModel(locationDistrictBlockRepository.findOne(blockID));
	// return result;
	// }
}
