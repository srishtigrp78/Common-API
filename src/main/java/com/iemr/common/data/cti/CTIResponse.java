package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CTIResponse
{
	private static final String SUCCESS = "success";
	OutputMapper mapper = new OutputMapper();
	@Expose
	String transaction_id;
	@Expose
	String agentid;
	@Expose
	String agent_id;
	@Expose
	String requestparam;
	@Expose
	String status;
	@Expose
	String response_code;
	@Expose
	String reason;
	@Expose
	String skill;
	@Expose
	String weight;
	@Expose
	JsonArray skills;
	@Expose
	String state;
	@Expose
	String dialer_type;
	@Expose
	String campaign_dialerType;
	@Expose
	String previewDialing;
	@Expose
	String manual_dial;
	@Expose
	String last_cust_ph_no;
	@Expose
	String call_duration;
	@Expose
	String CLI;
	@Expose
	String session_id;
	@Expose
	String ivrs_path;
	@Expose
	String cust_ph_no;
	@Expose
	String wrapTime;
	@Expose
	String wrpupDisconnectFlag;
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
	private String campaign;
	@Expose
	private String login_key;
	@Expose
	private String user_name;
	@Expose
	private JsonArray roles;
	@Expose
	String result;
	@Expose
	String path;
	@Expose
	String filename;
	@Expose
	String disconnect_by;
	@Expose
	String language;
	@Expose
	String action;
	@Expose
	private String response;

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}

	public Boolean isSuccessResponse()
	{
		return status.equalsIgnoreCase(SUCCESS);
	}

	// public String getReason()
	// {
	// return reason;
	// }
	//
	// public String getResponse_code()
	// {
	// return response_code;
	// }
	//
	// public String getStatus()
	// {
	// return status;
	// }
	//
	// public String getTransaction_id()
	// {
	// return transaction_id;
	// }
	//
	// public String getAgentid()
	// {
	// return agentid;
	// }
	//
	// public String getAgent_id()
	// {
	// return agent_id;
	// }
	//
	// public String getRequestparam()
	// {
	// return requestparam;
	// }
	//
	// public String getSkill()
	// {
	// return skill;
	// }
	//
	// public String getWeight()
	// {
	// return weight;
	// }
	//
	// public JsonArray getSkills()
	// {
	// return skills;
	// }
	//
	// public String getState()
	// {
	// return state;
	// }
	//
	// public String getDialer_type()
	// {
	// return dialer_type;
	// }
	//
	// public String getCampaign_dialerType()
	// {
	// return campaign_dialerType;
	// }
	//
	// public String getPreviewDialing()
	// {
	// return previewDialing;
	// }
	//
	// public String getManual_dial()
	// {
	// return manual_dial;
	// }
	//
	// public String getLast_cust_ph_no()
	// {
	// return last_cust_ph_no;
	// }
	//
	// public String getCall_duration()
	// {
	// return call_duration;
	// }
	//
	// public String getCLI()
	// {
	// return CLI;
	// }
	//
	// public String getSession_id()
	// {
	// return session_id;
	// }
	//
	// public String getIvrs_path()
	// {
	// return ivrs_path;
	// }
	//
	// public String getCust_ph_no()
	// {
	// return cust_ph_no;
	// }
	//
	// public String getWrapTime()
	// {
	// return wrapTime;
	// }
	//
	// public String getWrpupDisconnectFlag()
	// {
	// return wrpupDisconnectFlag;
	// }
	//
	// public OutputMapper getMapper()
	// {
	// return mapper;
	// }
	//
	// public String getTotal_calls()
	// {
	// return total_calls;
	// }
	//
	// public String getTotal_invalid_calls()
	// {
	// return total_invalid_calls;
	// }
	//
	// public String getTotal_call_duration()
	// {
	// return total_call_duration;
	// }
	//
	// public String getTotal_free_time()
	// {
	// return total_free_time;
	// }
	//
	// public String getTotal_break_time()
	// {
	// return total_break_time;
	// }
	//
	// public String getCampaign()
	// {
	// return campaign;
	// }
	//
	// public String getLogin_key()
	// {
	// return login_key;
	// }
	//
	// public String getUser_name()
	// {
	// return user_name;
	// }
	//
	// public JsonArray getRoles()
	// {
	// return roles;
	// }
	//
	// public String getResult()
	// {
	// return result;
	// }
	//
	// public String getPath()
	// {
	// return path;
	// }
	//
	// public String getFilename()
	// {
	// return filename;
	// }
	//
	// public String getDisconnect_by()
	// {
	// return disconnect_by;
	// }
}
