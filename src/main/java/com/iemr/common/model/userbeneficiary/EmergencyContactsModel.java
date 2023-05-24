package com.iemr.common.model.userbeneficiary;

import com.iemr.common.model.user.NotificationTypeModel;
import com.iemr.common.model.user.ProviderServiceMappingModel;

import lombok.Data;

public @Data class EmergencyContactsModel
{
	private Integer emergContactID;
	private Integer designationID;
	private DesignationModel designationModel;
	private String emergContactName;
	private String emergContactNo;
	private String emergContactDesc;
	private String location;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Integer notificationTypeID;
	private NotificationTypeModel notificationType;

	private Boolean deleted;
	// private String processed;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
