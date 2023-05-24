package com.iemr.common.model.institute;

import com.iemr.common.model.user.SubDirectoryModel;
import com.iemr.common.model.userbeneficiary.DirectoryModel;

import lombok.Data;

public @Data class InstituteDirectoryMapping
{
	private Long instituteDirMapID;
	private Integer institutionID;
	private InstituteModel institute;
	private Integer instituteDirectoryID;
	private DirectoryModel directory;
	private Integer instituteSubDirectoryID;
	private SubDirectoryModel subDirectory;
	private Integer instituteRouteDirectoryID;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
