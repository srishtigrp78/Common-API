package com.iemr.common.model.beneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class BenRelationshipTypeModel
{
	@Expose
	private Integer benRelationshipID;
	// private List<BenPhoneMapModel> benPhoneMapModel;
	@Expose
	private String benRelationshipType;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
