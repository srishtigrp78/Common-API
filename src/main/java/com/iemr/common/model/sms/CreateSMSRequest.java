package com.iemr.common.model.sms;

import java.util.List;

import lombok.Data;

@Data
public class CreateSMSRequest
{
	Integer smsTemplateID;
	String smsTemplateName;
	String smsTemplate;
	Integer smsTypeID;
	SMSTypeModel smsType;
	Integer providerServiceMapID;
	String createdBy;
	List<SMSParameterMapModel> smsParameterMaps;
}
