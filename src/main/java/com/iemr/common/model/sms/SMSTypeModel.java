package com.iemr.common.model.sms;

import lombok.Data;

@Data
public class SMSTypeModel
{
	Integer smsTypeID;
	String smsType;
	String description;
	Integer serviceID;
	Boolean deleted;
	// String processed;
	// String createdBy;
	// Timestamp createdDate;
	// String modifiedBy;
	// Timestamp lastModDate;
}
