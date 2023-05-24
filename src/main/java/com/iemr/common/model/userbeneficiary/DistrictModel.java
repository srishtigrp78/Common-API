package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class DistrictModel
{
	// @Autowired
	// LocationDistrictRepository locationDistrictRepository;
	//
	// @Autowired
	// DistrictMapper districtMapper;

	@Expose
	private Integer districtID;
	// private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	// private List<InstituteModel> institutes;
	@Expose
	private Integer stateID;
	@Expose
	private String districtName;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
	@Expose
	private StateModel stateModel;

	// public static DistrictModel createDistrict(Integer districtID,
	// LocationDistrictRepository locationDistrictRepository, DistrictMapper districtMapper)
	// {
	// DistrictModel district = new DistrictModel();
	// district = districtMapper.DistrictToModel(locationDistrictRepository.findOne(districtID));
	// return district;
	// }
}
