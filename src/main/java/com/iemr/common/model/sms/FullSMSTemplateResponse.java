package com.iemr.common.model.sms;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FullSMSTemplateResponse
{
	Integer smsTemplateID;
	String smsTemplateName;
	String smsTemplate;
	Integer providerServiceMapID;
	SMSTypeModel smsType;
	List<SMSParameterMapModel> smsParameterMaps;
	Boolean deleted;
	String processed;
	String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp createdDate;
	String modifiedBy;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Timestamp lastModDate;

	public FullSMSTemplateResponse()
	{
	}
}
