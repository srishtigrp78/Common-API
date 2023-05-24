package com.iemr.common.data.cti;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CustomerLanguage
{
	@Expose
	String cust_ph_no;
	@Expose
	String campaign_name;
	@Expose
	String language;
	@Expose
	String action;
	@Expose
	String transaction_id;
	@Expose
	String status;
	@Expose
	String response_code;
	@Expose
	String reason;
	// JsonObject response;
	@Expose
	CTIResponse response;

	public void setResponse(CTIResponse response)
	{
		this.response = response;
		this.transaction_id = response.getTransaction_id();
		this.status = response.getStatus();
		this.response_code = response.getResponse_code();
		this.reason = response.getReason();
		this.campaign_name = response.getCampaign();
		this.cust_ph_no = response.getCust_ph_no();
		this.language = response.getLanguage();
	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
