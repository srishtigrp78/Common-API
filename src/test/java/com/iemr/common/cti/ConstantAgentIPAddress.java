package com.iemr.common.cti;

public interface ConstantAgentIPAddress extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AGENTIP&agent_id=2003&resFormat=3";
	static final String urlSuccessResponse1 =
			"{ \"response\": { \"transaction_id\": \"CTI_GET_AGENTIP\" , " + "\"agent_id\": \"2003\" , \"agent_ip\": "
					+ REQUESTOR_IP + " , \"response_code\": \"1\", " + "\"status\": \"SUCCESS\", \"reason\": \"\"} }";
	static final String successRequest1 = "{agent_id:2003}";
	static final String successResponse1 = "{\"data\":{\"stateObj\":{},\"response\":{"
			+ "\"transaction_id\":\"CTI_GET_AGENTIP\",\"agent_id\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"agent_ip\":\"10.208.24.185\"},"
			+ "\"transaction_id\":\"CTI_GET_AGENTIP\",\"agent_id\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"agent_ip\":\"10.208.24.185\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"stateObj\":{},\"response\":{"
			+ "\"transaction_id\":\"CTI_GET_AGENTIP\",\"agent_id\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"agent_ip\":\"10.208.24.185\"},"
			+ "\"transaction_id\":\"CTI_GET_AGENTIP\",\"agent_id\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"agent_ip\":\"10.208.24.185\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessEmptyAgentRequest = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AGENTIP&agent_id=&resFormat=3";
	static final String urlSuccessEmptyAgentResponse =
			"{ \"response\": { \"transaction_id\": \"CTI_GET_AGENTIP\" , " + "\"agent_id\": \"\" , \"agent_ip\": "
					+ REQUESTOR_IP + " , \"response_code\": \"1\", " + "\"status\": \"SUCCESS\", \"reason\": \"\"} }";

	static final String urlSuccess2004AgentRequest = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AGENTIP&agent_id=2004&resFormat=3";
	static final String urlSuccess2004AgentResponse =
			"{ \"response\": { \"transaction_id\": \"CTI_GET_AGENTIP\" , " + "\"agent_id\": \"2004\" , \"agent_ip\": "
					+ REQUESTOR_IP + " , \"response_code\": \"1\", " + "\"status\": \"SUCCESS\", \"reason\": \"\"} }";

	static final String urlSuccessEmptyIPRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AGENTIP&agent_id=&resFormat=3";
	static final String urlSuccessEmptyIPResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_AGENTIP\" , "
			+ "\"agent_id\": \"\" , \"agent_ip\": \"\" , \"response_code\": \"1\", "
			+ "\"status\": \"SUCCESS\", \"reason\": \"\"} }";

	static final String urlSuccessEmptyIPRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AGENTIP&agent_id=2004&resFormat=3";
	static final String urlSuccessEmptyIPResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_GET_AGENTIP\" , "
			+ "\"agent_id\": \"2004\" , \"agent_ip\": \"\" , \"response_code\": \"1\", "
			+ "\"status\": \"SUCCESS\", \"reason\": \"\"} }";

	static final String urlSuccessEmptyIPRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AGENTIP&agent_id=2003&resFormat=3";
	static final String urlSuccessEmptyIPResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_GET_AGENTIP\" , "
			+ "\"agent_id\": \"2003\" , \"agent_ip\": \"\" , \"response_code\": \"1\", "
			+ "\"status\": \"SUCCESS\", \"reason\": \"\"} }";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_AGENTIP&agent_id=200&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_AGENTIP\" , "
			+ "\"agent_id\": \"200\" , \"agent_ip\": \"\" , \"response_code\": \"0\", \"status\": \"FAILURE\", "
			+ "\"reason\": \"Agent 200 is not loggedin.\"} }";
	static final String failureRequest1 = "{agent_id:200}";
	static final String failureResponse1 =
			"{\"statusCode\":5000," + "\"errorMessage\":\"Agent 200 is not loggedin.\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 =
			"{\"statusCode\":5000," + "\"errorMessage\":\"Agent 200 is not loggedin.\",\"status\":\"FAILURE\"}";
}
