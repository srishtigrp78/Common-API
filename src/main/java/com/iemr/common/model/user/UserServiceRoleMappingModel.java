package com.iemr.common.model.user;

import com.iemr.common.model.userbeneficiary.StatusModel;

import lombok.Data;

public @Data class UserServiceRoleMappingModel
{
	private Long usrMappingID;
	private Long userID;
	// private UserModel user;
	private Integer roleID;
	private RoleModel role;
	private Integer serviceID;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMapping;
	private String agentID;
	private String agentPassword;
	private Integer statusID;
	private StatusModel status;
	private Integer workingLocationID;
	private ProviderServiceAddressMappingModel providerServiceAddressMapping;
	private String languageName;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
