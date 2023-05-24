package com.iemr.common.data.cti;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class TransferCall
{
	OutputMapper outputMapper = new OutputMapper();
	@Expose
	String transfer_to;
	@Expose
	String transfer_from;
	@Expose
	String transfer_campaign_info;
	@Expose
	String skill_transfer_flag;
	@Expose
	String skill;
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
	// JsonObject response;
	@Expose
	CTIResponse response;

	@Transient
	private String agentIPAddress;
	
	@Transient
	private Long benCallID;
	

	
	@Transient
	private Integer callTypeID;
	

	public String getSkill()
	{
		return skill;
	}

	public String getResponse()
	{
		return response.toString();
	}

	public CTIResponse getResponseObj()
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
		return OutputMapper.gson().toJson(this);
	}

	// public String getTransfer_to()
	// {
	// return transfer_to;
	// }
	//
	// public String getTransfer_from()
	// {
	// return transfer_from;
	// }
	//
	// public String getTransfer_campaign_info()
	// {
	// return transfer_campaign_info;
	// }
	//
	// public String getSkill_transfer_flag()
	// {
	// return skill_transfer_flag;
	// }
	//
	// public String getTransaction_id()
	// {
	// return transaction_id;
	// }

	public String getAgentid()
	{
		return agentid;
	}
	

}
