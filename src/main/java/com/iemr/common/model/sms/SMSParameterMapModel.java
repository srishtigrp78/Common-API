package com.iemr.common.model.sms;

import lombok.Data;

@Data
public class SMSParameterMapModel
{
	Integer smsParameterID;
	Integer smsTemplateID;
	String createdBy;
	String modifiedBy;
	String smsParameterValue;
	String smsParameterName;
	String smsParameterType;
}
