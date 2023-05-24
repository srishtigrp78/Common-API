package com.iemr.common.model.user;

import java.sql.Timestamp;

import lombok.Data;

public @Data class KMFileManagerModel
{
	private Integer kmFileManagerID;
	private NotificationModel notificationModel;
	private String fileUID;
	private String fileName;
	private String fileExtension;
	private String versionNo;
	private String fileCheckSum;
	private Integer providerServiceMapID;
	private Integer userID;
	private String kmUploadStatus;
	private Timestamp validFrom;
	private Timestamp validUpto;
	private Integer categoryID;
	private Integer subCategoryID;
	private String fileContent;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
