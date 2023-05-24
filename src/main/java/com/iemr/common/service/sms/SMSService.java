package com.iemr.common.service.sms;

import java.util.List;

import com.iemr.common.model.sms.CreateSMSRequest;
import com.iemr.common.model.sms.SMSParameterModel;
import com.iemr.common.model.sms.SMSRequest;
import com.iemr.common.model.sms.SMSTypeModel;
import com.iemr.common.model.sms.UpdateSMSRequest;

public interface SMSService
{
	public String getSMSTemplates(SMSRequest smsRequest) throws Exception;

	public String updateSMSTemplate(UpdateSMSRequest smsRequest) throws Exception;

	public String saveSMSTemplate(CreateSMSRequest smsRequest) throws Exception;

	public String getSMSTypes(SMSTypeModel request) throws Exception;

	public String getSMSParameters(SMSParameterModel request) throws Exception;

	public String sendSMS(List<SMSRequest> requests, String authToken) throws Exception;

	public String getFullSMSTemplate(SMSRequest smsRequest) throws Exception;

	public void publishSMS();
}
