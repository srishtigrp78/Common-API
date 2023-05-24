package com.iemr.common.model.user;

import lombok.Data;

public @Data class NotificationTypeModel
{
	private Integer notificationTypeID;
	// private List<NotificationModel> notificationModels;
	// private List<EmergencyContactsModel> emergencyContacts;
	private String notificationType;
	private String notificationTypeDesc;
	private Integer providerServiceMapID;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
