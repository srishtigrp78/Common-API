package com.iemr.common.model.sms;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SMSTemplateResponse
{
	Integer smsTemplateID;
	String smsTemplateName;
	String smsTemplate;
	Integer providerServiceMapID;
	SMSTypeModel smsType;
	Boolean deleted;
	String processed;
	String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp createdDate;
	String modifiedBy;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp lastModDate;

	public SMSTemplateResponse()
	{
	}
}
