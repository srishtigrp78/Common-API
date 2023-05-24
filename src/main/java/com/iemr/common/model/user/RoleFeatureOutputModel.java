package com.iemr.common.model.user;

import java.util.List;

import lombok.Data;

@Data
public class RoleFeatureOutputModel
{
	private Integer roleID;
	private String roleName;
	private String roleDesc;
	private List<ServiceRoleScreenMappingModel> featureName;
	private Boolean deleted;
}
