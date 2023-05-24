package com.iemr.common.model.user;

import com.iemr.common.model.userbeneficiary.StatusModel;

import lombok.Data;

public @Data class ProviderServiceMappingModel
{
	private Integer providerServiceMapID;
	// private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	// private List<NotificationModel> notificationModels;
	// private List<ServiceRoleScreenMappingModel> serviceRoleScreenMappingModel;
	// private List<ScreenModel> screens;
	// private List<DirectoryModel> directories;
	// private List<FeedbackTypeModel> feedbacks;
	// private List<FeedbackSeverityModel> feedbackSeverities;
	// private List<EmergencyContactsModel> emergencyContacts;
	// private List<PhoneBlockModel> blockNumbers;
	private Short serviceProviderID;
	private ServiceProviderModel serviceProvider;
	private Short serviceID;
	private ServiceMasterModel ServiceMaster;
	private Integer countryID;
	private Integer stateID;
	private Integer districtID;
	private Integer cityID;
	private Integer districtBlockID;
	private String address;
	private String ctiCampaignName;
	private Integer statusID;
	private StatusModel status;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
