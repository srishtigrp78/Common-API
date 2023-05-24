package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class AgentSkills
{
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id= CTI_AGENT_SKILL_ADDUPDATE&agent_id=[value]&skill=[
	 * value]&weight=[value]&type=[type value 'add' or 'update' ]&resFormat=3
	 */
	/*
	 * "response": { "transaction_id": "CTI_AGENT_SKILL_ADDUPDATE" , "response_code": "0", "status": "FAILURE",
	 * "agent_id" : "2003", "skill" : "Hindi", "weight" : "20", "reason": ""} }
	 */
	OutputMapper outputMapper = new OutputMapper();
	@Expose
	String campaign_name;
	@Expose
	String agent_id;
	@Expose
	String skill;
	@Expose
	String weight;
	@Expose
	String type;
	@Expose
	JsonArray skills;

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
	Integer isFeedback = 0;
	// JsonObject response;
	@Expose
	CTIResponse response;
    @Expose	
    String call_id;	
	public String getAgentID()
	{
		return agent_id;
	}
	public String getCallID()
	{
		return call_id;
	}
	public String getSkill()
	{
		return skill;
	}

	public String getWeight()
	{
		return weight;
	}

	public String getType()
	{
		return type;
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
		this.skill = response.getSkill();
		this.skills = response.getSkills();
		this.weight = response.getWeight();
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

	public String getCampaignName()
	{
		return campaign_name;
	}
}
