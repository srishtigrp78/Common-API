package com.iemr.common.model.user;

import lombok.Data;

public @Data class SubDirectoryModel
{
	private Integer instituteSubDirectoryID;
	// private List<InstituteDirectoryMapping> instituteDirectoryMappings;
	private Integer instituteDirectoryID;
	private String instituteSubDirectoryName;
	private String instituteSubDirectoryDesc;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
