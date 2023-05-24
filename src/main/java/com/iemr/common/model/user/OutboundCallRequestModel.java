package com.iemr.common.model.user;

import java.sql.Timestamp;

import com.iemr.common.model.beneficiary.BeneficiaryCallModel;

import lombok.Data;

public @Data class OutboundCallRequestModel
{
	private Long outboundCallReqID;
	private Long beneficiaryRegID;
	private Integer assignedUserID;
	private UserModel user;
	private Integer callTypeID;
	private Integer providerServiceMapID;
	private Timestamp prefferedDateTime;
	private String requestedFor;
	private Boolean isCompleted;
	private Long benCallID;
	private BeneficiaryCallModel beneficiaryCallModel;
	private Integer requestedServiceID;
	private SubServiceModel requestedService;
	private Long requestNo;
	private Boolean is1097;
	private Boolean isSelf;

	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private Boolean modifiedBy;
	private Timestamp lastModDate;
}
