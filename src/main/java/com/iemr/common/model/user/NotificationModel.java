package com.iemr.common.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.common.model.userbeneficiary.LanguageModel;

import lombok.Data;

public @Data class NotificationModel
{
	private Integer notificationID;
	private String notification;
	private String notificationDesc;
	private Integer notificationTypeID;
	private NotificationTypeModel notificationType;
	private Integer roleID;
	private RoleModel role;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Timestamp validTill;
	private Timestamp validFrom;
	private Integer kmFileManagerID;
	private KMFileManagerModel kmFileManager;
	private Integer workingLocationID;
	private WorkLocationModel workingLocation;
	private List<Integer> workingLocationIDs;
	private Integer languageID;
	private LanguageModel language;
	private List<Integer> languageIDs;
	private Integer userID;
	private UserModel user;
	private List<Integer> userIDs;
	private Timestamp validStartDate;
	private Timestamp validEndDate;
	private String kmFilePath;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
