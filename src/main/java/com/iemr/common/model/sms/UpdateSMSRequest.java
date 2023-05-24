package com.iemr.common.model.sms;

import lombok.Data;

@Data
public class UpdateSMSRequest
{
	Integer smsTemplateID;
	Integer providerServiceMapID;
	Boolean deleted;
	String modifiedBy;
}
