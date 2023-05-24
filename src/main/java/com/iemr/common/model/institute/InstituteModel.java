package com.iemr.common.model.institute;

import com.iemr.common.model.userbeneficiary.DistrictBlockModel;
import com.iemr.common.model.userbeneficiary.DistrictBranchModel;
import com.iemr.common.model.userbeneficiary.DistrictModel;
import com.iemr.common.model.userbeneficiary.StateModel;

import lombok.Data;

public @Data class InstituteModel
{
	private Integer institutionID;
	// private List<InstituteDirectoryMapping> instituteDirectory;
	// private List<FeedbackDetailsModel> feedbackDetailsModel;
	private String institutionName;
	private Integer stateID;
	private StateModel stateModels;
	private Integer districtID;
	private DistrictModel district;
	private Integer blockID;
	private DistrictBlockModel districtBlock;
	private Integer districtBranchMappingID;
	private DistrictBranchModel m_districtbranchmapping;
	private String govtInstituteID;
	private String address;
	private String contactPerson1;
	private String contactPerson1_Email;
	private String contactNo1;
	private String contactPerson2;
	private String contactPerson2_Email;
	private String contactNo2;
	private String contactPerson3;
	private String contactPerson3_Email;
	private String contactNo3;
	private String website;
	private Integer providerServiceMapID;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
