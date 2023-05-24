package com.iemr.common.model.institute;

import lombok.Data;

public @Data class InstituteTypeModel
{
	private Integer institutionTypeID;
	private String institutionType;
	private String institutionTypeDesc;
	private Integer providerServiceMapID;
	private Boolean deleted;
	// private String createdBy;
	// private Date createdDate;
	// private String modifiedBy;
	// private Date lastModDate;
}
