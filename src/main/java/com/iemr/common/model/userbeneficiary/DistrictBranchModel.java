package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class DistrictBranchModel
{
	@Expose
	private Integer districtBranchID;
	// private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	@Expose
	private Integer blockID;
	@Expose
	private String panchayatName;
	@Expose
	private String villageName;
	@Expose
	private String habitat;
	@Expose
	private String pinCode;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;

	// public static DistrictBranchModel createDistrictBranch(Integer villageId,
	// LocationDistrilctBranchRepository districtBranchRepository, DistrictBranchMapper districtBranchMapper)
	// {
	// DistrictBranchModel model = new DistrictBranchModel();
	// model = districtBranchMapper.districtBranchToModel(districtBranchRepository.findOne(villageId));
	// return model;
	// }
}
