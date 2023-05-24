package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class AutoPreviewDial {

	OutputMapper outputMapper = new OutputMapper();
	@Expose
	String camp_name;
	
	@Expose
	String Agent_id;
	
	@Expose
	String mobile;

	@Expose
	String transaction_id;
	
	@Expose
	String agentid;
	
	@Expose
	String status;
	
	@Expose
	String response_code;
	
	@Expose
	String reason;
	
	@Expose
	CTIResponse response;
	
	public CTIResponse getResponse()
	{
		return response;
	}

	public void setResponse(CTIResponse response)
	{
		this.response = response;
		this.transaction_id = response.getTransaction_id();
		this.agentid = response.getAgentid();
		this.status = response.getStatus();
		this.response_code = response.getResponse_code();
		this.reason = response.getReason();
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
