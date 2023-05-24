package com.iemr.common.data.cti;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class AgentCallStats {
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id=
	 * CTI_CHECK_AGENT_STATE&agent_id=2003&ip=&resFormat=3
	 */
	/*
	 * { "response": { "transaction_id": "CTI_AGENT_CALL_RECORD" ,
	 * "response_code": "1", "status": "SUCCESS", "agent_id" : "2003",
	 * "total_calls" : "44", "total_invalid_calls" : "unavailable",
	 * "total_call_duration" : "00:15:44", "total_free_time" : "12:00:04",
	 * "total_break_time" : "00:00:00", "reason": ""} }
	 */

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();
	@Expose
	String transaction_id;
	@Expose
	String agent_id;
	@Expose
	String total_calls;
	@Expose
	String total_invalid_calls;
	@Expose
	String total_call_duration;
	@Expose
	String total_free_time;
	@Expose
	String total_break_time;
	@Expose
	String response_code;
	@Expose
	String CLI;
	@Expose
	String session_id;
	@Expose
	JSONObject stateObj;
	@Expose
	CTIResponse response;
	@Expose
	private String status;
	@Expose
	private String reason;

	public String getAgentID() {
		return agent_id;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public void setResponse(CTIResponse ctiResponse)
	{
		this.response = ctiResponse;
		this.transaction_id = ctiResponse.getTransaction_id();
		this.response_code = ctiResponse.getResponse_code();
		this.status = ctiResponse.getStatus();
		this.agent_id = ctiResponse.getAgent_id();
		this.total_calls = ctiResponse.getTotal_calls();
		this.total_invalid_calls = ctiResponse.getTotal_invalid_calls();
		this.total_call_duration = ctiResponse.getTotal_call_duration();
		this.total_free_time = ctiResponse.getTotal_free_time();
		this.total_break_time = ctiResponse.getTotal_break_time();
		this.reason = ctiResponse.getReason();
	}

	public CTIResponse getResponse()
	{
		return response;
	}
}
