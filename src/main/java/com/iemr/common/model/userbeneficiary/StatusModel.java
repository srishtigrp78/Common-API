package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class StatusModel
{
	@Expose
	private Integer statusID;
	// private List<UserModel> m_Users;
	// private List<BeneficiaryModel> beneficiaryModels;
	// private List<ServiceProviderModel> serviceProviders;
	// private List<ProviderServiceMappingModel> providerServiceMappingModels;
	// private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	@Expose
	private String status;
	@Expose
	private String statusDesc;

	@Expose
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
	public StatusModel() {
		
	}
}
