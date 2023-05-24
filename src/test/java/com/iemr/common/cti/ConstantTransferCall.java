package com.iemr.common.cti;

public interface ConstantTransferCall extends Constants
{

	final static String urlSuccessRequest1 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_AGENT&transfer_from=2003&transfer_to=2004&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	final static String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_AGENT\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\": \"SUCCESS\" } }";
	final static String successRequest1 = "{transfer_from:2003, transfer_to:2004}";
	final static String successResponse1 = "{\"data\":{\"transfer_to\":\"2004\",\"transfer_from\":\"2003\","
			+ "\"transaction_id\":\"CTI_TRANSFER_AGENT\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"SUCCESS\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_AGENT\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"SUCCESS\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	final static String controllerSuccessResponse1 = "{\"data\":{\"transfer_to\":\"2004\",\"transfer_from\":\"2003\","
			+ "\"transaction_id\":\"CTI_TRANSFER_AGENT\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"SUCCESS\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_AGENT\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"SUCCESS\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_CAMPAIGN&agent_id=2003&transfer_campaign_info=UAT_1097_CO&"
			+ "skill=Kannada&skill_transfer_flag=1&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_CAMPAIGN\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\" : \"\" } }";
	final static String successRequest2 = "{transfer_from:2003, transfer_campaign_info:\"UAT_1097_CO\", "
			+ "skill:\"Kannada\", skill_transfer_flag:\"1\"}";
	final static String successResponse2 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"skill_transfer_flag\":\"1\",\"skill\":\"Kannada\","
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	final static String controllerSuccessResponse2 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"skill_transfer_flag\":\"1\",\"skill\":\"Kannada\","
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest3 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_CAMPAIGN&agent_id=2003&transfer_campaign_info=UAT_1097_CO&"
			+ "skill=english&skill_transfer_flag=0&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_CAMPAIGN\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\" : \"\" } }";
	final static String successRequest3 = "{transfer_from:2003, transfer_campaign_info:\"UAT_1097_CO\", "
			+ "skill:\"english\", skill_transfer_flag:\"0\"}";
	final static String successResponse3 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"skill_transfer_flag\":\"0\",\"skill\":\"english\","
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	final static String controllerSuccessResponse3 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"skill_transfer_flag\":\"0\",\"skill\":\"english\","
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest4 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_CAMPAIGN&agent_id=2003&transfer_campaign_info=UAT_1097_CO&"
			+ "skill=kannada&skill_transfer_flag=&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse4 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_CAMPAIGN\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\" : \"\" } }";
	final static String successRequest4 = "{transfer_from:2003, transfer_campaign_info:\"UAT_1097_CO\", "
			+ "skill:\"kannada\"}";
	final static String successResponse4 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"skill\":\"kannada\","
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	final static String controllerSuccessResponse4 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"skill\":\"kannada\","
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest5 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_CAMPAIGN&agent_id=2003&transfer_campaign_info=UAT_1097_CO&"
			+ "skill=&skill_transfer_flag=&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse5 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_CAMPAIGN\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\" : \"\" } }";
	final static String successRequest5 = "{transfer_from:2003, transfer_campaign_info:\"UAT_1097_CO\"}";
	final static String successResponse5 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	final static String controllerSuccessResponse5 = "{\"data\":{\"transfer_from\":\"2003\","
			+ "\"transfer_campaign_info\":\"UAT_1097_CO\",\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_TRANSFER_CAMPAIGN\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	final static String urlFailureRequest1 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_AGENT&transfer_from=2003&transfer_to=20000&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	final static String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_AGENT\", "
			+ "\"agentid\": \"2003\", \"status\": \"FAILURE\", \"response_code\": \"0\", "
			+ "\"reason\": \"20000 not available\" } }";
	final static String failureRequest1 = "{transfer_from:2003, transfer_to:20000}";
	final static String failureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"20000 not available\",\"status\":\"FAILURE\"}";
	final static String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"20000 not available\",\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_CAMPAIGN&agent_id=2003&transfer_campaign_info=UAT_1097_CO&"
			+ "skill=Kannada&skill_transfer_flag=1&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_CAMPAIGN\", "
			+ "\"agentid\": \"2004\", \"status\": \"FAILURE\", \"response_code\": \"0\", "
			+ "\"reason\" : \"FAIL-Wrong campaign info\" } }";
	final static String failureRequest2 = "{transfer_from:2004, transfer_campaign_info:\"UAT_1097\", "
			+ "skill:\"kannada\", skill_transfer_flag:\"1\"}";
	final static String failureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"FAIL-Wrong campaign info\",\"status\":\"FAILURE\"}";
	final static String controllerFailureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"FAIL-Wrong campaign info\",\"status\":\"FAILURE\"}";

	static final String urlFailureRequest3 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_TRANSFER_CAMPAIGN&agent_id=2000&transfer_campaign_info=UAT_1097_CO&"
			+ "skill=Kannada&skill_transfer_flag=1&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFER_CAMPAIGN\", "
			+ "\"agentid\": \"2000\", \"status\": \"FAILURE\", \"response_code\": \"0\", "
			+ "\"reason\" : \"FAIL-Agent is not as per request\" } }";
	final static String failureRequest3 = "{transfer_from:2000, transfer_campaign_info:\"UAT_1097_CO\", "
			+ "skill:\"kannada\", skill_transfer_flag:\"1\"}";
	final static String failureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"FAIL-Agent is not as per request\",\"status\":\"FAILURE\"}";
	final static String controllerFailureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"FAIL-Agent is not as per request\",\"status\":\"FAILURE\"}";

}
