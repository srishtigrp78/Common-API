package com.iemr.common.model.userbeneficiary;

import lombok.Data;

public @Data class DirectoryModel
{
	private Integer instituteDirectoryID;
	// private List<InstituteDirectoryMapping> instituteDirectoryMappings;
	private String instituteDirectoryName;
	private String instituteDirectoryDesc;
	private Integer providerServiceMapID;
	// private ProviderServiceMappingModel providerServiceMappingModel;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
