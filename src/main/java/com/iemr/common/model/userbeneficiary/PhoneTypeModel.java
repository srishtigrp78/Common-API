package com.iemr.common.model.userbeneficiary;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.iemr.common.model.beneficiary.BenPhoneMapModel;

import lombok.Data;

public @Data class PhoneTypeModel
{
	@Expose
	private Integer phoneTypeID;
	@Expose
	private List<BenPhoneMapModel> benPhoneMapModel;
	@Expose
	private String phoneType;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
