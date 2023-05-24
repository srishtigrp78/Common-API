package com.iemr.common.data.cti;

import java.util.List;

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
public class BlockUnblockNumber
{
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id= CTI_GET_CAMPAIGNS&campaign_type=&searchkey=104&
	 * resFormat=3
	 */
	/*
	 * { "response": { "transaction_id": "CTI_GET_CAMPAIGNS" , "response_code": "1", "status": "SUCCESS", "campaign" :
	 * [{"campaign_id":"7","campaign_name":"UAT_104_CO"},{"campaign_id":"5", "campaign_name":"UAT_104_HAO"},{
	 * "campaign_id":"3","campaign_name":"UAT_104_MO"},{"campaign_id":"2", "campaign_name":"UAT_104_RO"},{"campaign_id":
	 * "6","campaign_name":"UAT_104_SIO"}], "reason": ""} }
	 */

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();
	@Expose
	private String transaction_id;
	@Expose
	private String type;
	@Expose
	private String campaign;
	@Expose
	private String serviceName;
	@Expose
	private String reason;
	@Expose
	private CTIResponse response;
	@Expose
	private String response_code;
	@Expose
	private String status;
	private String phoneNo;
	private String campaignName;

	public String getServiceName()
	{
		return serviceName;
	}

	public String getType()
	{
		return type;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}

	public String getCampaignName()
	{
		return campaignName;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public CTIResponse getResponse()
	{
		return response;
	}

	public void setResponse(CTIResponse response)
	{
		this.response = response;
		this.status = response.getStatus();
		this.transaction_id = response.getTransaction_id();
		this.campaign = response.getCampaign();
		this.reason = response.getReason();
		this.response_code = response.getResponse_code();
	}
}
