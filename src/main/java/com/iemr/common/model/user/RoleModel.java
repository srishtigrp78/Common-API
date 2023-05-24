package com.iemr.common.model.user;

import java.util.List;
import java.util.Set;

import lombok.Data;

public @Data class RoleModel
{
	private Integer roleID;
	private String roleName;
	private String roleDesc;
	private Set<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	// private Set<NotificationModel> notificationModels;
	private List<ServiceRoleScreenMappingModel> serviceRoleScreenMappingModels;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
