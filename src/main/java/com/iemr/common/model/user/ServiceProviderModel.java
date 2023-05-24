package com.iemr.common.model.user;

import java.sql.Date;

import com.iemr.common.model.userbeneficiary.StatusModel;

import lombok.Data;

public @Data class ServiceProviderModel
{

	private Integer serviceProviderID;
	// private List<ProviderServiceMappingModel> providerServiceMappingModels;
	private String serviceProviderName;
	private Date joiningDate;
	private Integer stateID;
	private String logoFileName;
	private String logoFilePath;
	private String primaryContactName;
	private String primaryContactNo;
	private String primaryContactEmailID;
	private String primaryContactAddress;
	private Date primaryContactValidityTillDate;
	private String secondaryContactName;
	private String secondaryContactNo;
	private String secondaryContactEmailID;
	private String secondaryContactAddress;
	private Date secondaryContactValidityTillDate;
	private Integer statusID;
	private StatusModel status;
	private Date validFrom;
	private Date validTill;
	private Boolean deleted;
	// private String createdBy;
	// private Date createdDate;
	// private String modifiedBy;
	// private Date lastModDate;
}
