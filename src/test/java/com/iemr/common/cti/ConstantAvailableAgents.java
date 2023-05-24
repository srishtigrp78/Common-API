package com.iemr.common.cti;

public interface ConstantAvailableAgents extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AVAILABLE_AGENTS&campaign_name=&skill_name=&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_AVAILABLE_AGENTS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"skills\" : ["
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}], "
			+ "\"reason\": \"\"} }";
	static final String successRequest1 = "{}";
	static final String successResponse1 = "{\"data\":{\"skills\":["
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}],"
			+ "\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skills\":["
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}]}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllersuccessResponse1 = "{\"data\":{\"skills\":["
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}],"
			+ "\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skills\":["
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_RO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_104_HAO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Hindi\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"English\",\"weight\":\"30\"},"
			+ "{\"campaign_name\":\"UAT_1097_MO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}]}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AVAILABLE_AGENTS&campaign_name=UAT_1097_CO&"
			+ "skill_name=kannada&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_GET_AVAILABLE_AGENTS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"skills\" : [{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}], \"reason\": \"\"} }";
	static final String successRequest2 = "{campaign_name:UAT_1097_CO, skill:kannada}";
	static final String successResponse2 = "{\"data\":{\"campaign_name\":\"UAT_1097_CO\",\"skills\":["
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}"
			+ "],\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skills\":[{\"campaign_name\":\"UAT_1097_CO\","
			+ "\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}]}},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllersuccessResponse2 = "{\"data\":{\"campaign_name\":\"UAT_1097_CO\",\"skills\":["
			+ "{\"campaign_name\":\"UAT_1097_CO\",\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}"
			+ "],\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_AVAILABLE_AGENTS\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skills\":[{\"campaign_name\":\"UAT_1097_CO\","
			+ "\"agent_id\":\"2003\",\"skill_name\":\"Kannada\",\"weight\":\"30\"}]}},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

}
