package com.iemr.common.model.beneficiary;

import java.sql.Timestamp;

import lombok.Data;

public @Data class BenMedHistoryModel
{
	private Long benMedHistoryID;
	private Long beneficiaryRegID;
	private BeneficiaryModel i_beneficiary;
	private Timestamp yearofIllness;
	private Integer illnessTypeID;
	private String illnessType;
	private Integer surgeryID;
	private Timestamp yearofSurgery;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
