package com.iemr.common.model.user;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class HealthCareWorkerModel
{
	@Expose
	private Short healthCareWorkerID;
	@Expose
	private String healthCareWorkerType;
	@Expose
	private String healthCareWorkerDesc;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
