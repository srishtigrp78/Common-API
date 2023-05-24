package com.iemr.common.cti;

public interface ContantCallBeneficiary extends Constants
{
	static final String dialRequestURLSuccess1 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_DIAL&agent_id=2003&ip=" + REQUESTOR_IP + "&phone_num=1234567899&resFormat=3";
	static final String dialRequestSuccess1 = "{agent_id:2003, phone_num:1234567899}";
	static final String dialURLResponseSuccess1 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"2003\", \"requestparam\": \"1234567899\", \"status\": \"SUCCESS\", \"response_code\": \"1\"}}";
	static final String dialResposneSuccess1 = "{\"agent_id\":null,\"phone_num\":null,\"transaction_id\":\"CTI_DIAL\","
			+ "\"agentid\":\"2003\",\"requestparam\":\"1234567899\",\"status\":\"SUCCESS\",\"response_code\":\"1\"}";
	static final String controllerDialResposneSuccess1 = "{\"agent_id\":null,\"phone_num\":null,"
			+ "\"transaction_id\":\"CTI_DIAL\",\"agentid\":\"2003\",\"requestparam\":\"1234567899\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\"}";

	static final String dialBeneficiaryRequestFailure1 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_DIAL&agent_id=2003&ip=" + REQUESTOR_IP + "&phone_num=1234567899&resFormat=3";

}