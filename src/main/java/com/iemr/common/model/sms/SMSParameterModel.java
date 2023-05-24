package com.iemr.common.model.sms;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SMSParameterModel
{
	Integer smsParameterID;
	String smsParameterName;
	String smsParameterType;
	Boolean deleted;
	String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp createdDate;
	String modifiedBy;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp lastModDate;
	Integer serviceID;
}
