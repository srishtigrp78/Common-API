package com.iemr.common.model.user;

import lombok.Data;

public @Data class ServiceMasterModel
{
	private Integer serviceID;
	private String serviceName;
	private String serviceDesc;
	// private List<UserServiceRoleMappingModel> m_UserServiceRoleMapping;
	// private List<SubServiceModel> subServices;
	// private List<FeedbackDetailsModel> feedbacks;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
