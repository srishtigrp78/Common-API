package com.iemr.common.model.user;

import lombok.Data;

public @Data class WorkLocationModel
{
	private Integer psAddMapID;
	// private List<NotificationModel> notificationModels;
	private Integer providerServiceMapID;
	private Integer districtID;
	private String locationName;
	private String address;
	// private String processed;
	private Boolean deleted;
	// private String CreatedBy;
	// private String ModifiedBy;
	// private Timestamp CreatedDate;
	// private Timestamp lastModDate;
}
