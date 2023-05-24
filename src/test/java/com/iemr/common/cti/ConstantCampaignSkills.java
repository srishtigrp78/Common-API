package com.iemr.common.cti;

public interface ConstantCampaignSkills extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_GET_CAMPAIGN_SKILLS&campaign_name=UAT_1097_CO&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGN_SKILLS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"campaign\" : \"UAT_1097_CO\", \"skills\" : ["
			+ "{\"skill_id\":\"1\",\"skill_name\":\"English\"},{\"skill_id\":\"3\",\"skill_name\":\"Hindi\"},"
			+ "{\"skill_id\":\"2\",\"skill_name\":\"Kannada\"}], \"reason\": \"\"} }";
	static final String successRequest1 = "{\"campaign_name\":\"UAT_1097_CO\"}";
	static final String successResponse1 = "{\"data\":{\"campaign_name\":\"UAT_1097_CO\",\"skills\":[],"
			+ "\"campaignskills\":[],\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGN_SKILLS\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"skills\":[{\"skill_id\":\"1\","
			+ "\"skill_name\":\"English\"},{\"skill_id\":\"3\",\"skill_name\":\"Hindi\"},{\"skill_id\":\"2\","
			+ "\"skill_name\":\"Kannada\"}],\"campaign\":\"UAT_1097_CO\"}},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final Object controllerSuccessResponse1 = "{\"data\":{\"campaign_name\":\"UAT_1097_CO\",\"skills\":[],"
			+ "\"campaignskills\":[],\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGN_SKILLS\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"skills\":[{\"skill_id\":\"1\","
			+ "\"skill_name\":\"English\"},{\"skill_id\":\"3\",\"skill_name\":\"Hindi\"},{\"skill_id\":\"2\","
			+ "\"skill_name\":\"Kannada\"}],\"campaign\":\"UAT_1097_CO\"}},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_GET_CAMPAIGN_SKILLS&campaign_name=1097_CO&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGN_SKILLS\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"campaign\" : \"1097_CO\", "
			+ "\"skills\" : [], \"reason\": \"No active skill found.\"} }";
	static final String failureRequest1 = "{\"campaign_name\":\"1097_CO\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No active skill found.\","
			+ "\"status\":\"FAILURE\"}";
	static final Object controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No active skill found.\","
			+ "\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_GET_CAMPAIGN_SKILLS&campaign_name=&ip=&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGN_SKILLS\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"campaign\" : \"\", \"skills\" : [], "
			+ "\"reason\": \"Campaign Name is missing.\"} }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Campaign Name is missing.\","
			+ "\"status\":\"FAILURE\"}";
	static final Object controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Campaign Name is missing.\","
			+ "\"status\":\"FAILURE\"}";

}
