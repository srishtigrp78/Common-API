package com.iemr.common.model.user;

import lombok.Data;

public @Data class ProviderServiceAddressMappingModel
{
	private Integer pSAddMapID;
	// private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	private Integer providerServiceMapID;
	private Integer districtID;
	private String address;
	private String locationName;

	private Boolean deleted;
	// private String createdBy;
	// private Date createdDate;
	// private String modifiedBy;
	// private Date lastModDate;
}
