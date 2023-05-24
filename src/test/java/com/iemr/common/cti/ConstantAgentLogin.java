package com.iemr.common.cti;

public interface ConstantAgentLogin extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGIN&agent_id=2003&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_LOGIN\", \"agentid\": \"2003\", "
			+ "\"requestparam\": \"login\", \"status\": \"SUCCESS\", \"response_code\": \"1\" } }";
	static final String successRequest1 = "{\"agent_id\":\"2003\"}";
	static final String successResponse1 = "{\"data\":{\"stateObj\":{},\"response\":{\"transaction_id\":\"CTI_LOGIN\","
			+ "\"agentid\":\"2003\",\"requestparam\":\"login\",\"status\":\"SUCCESS\",\"response_code\":\"1\"},"
			+ "\"transaction_id\":\"CTI_LOGIN\",\"agentid\":\"2003\",\"requestparam\":\"login\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"stateObj\":{},\"response\":{"
			+ "\"transaction_id\":\"CTI_LOGIN\",\"agentid\":\"2003\",\"requestparam\":\"login\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\"},\"transaction_id\":\"CTI_LOGIN\",\"agentid\":\"2003\","
			+ "\"requestparam\":\"login\",\"status\":\"SUCCESS\",\"response_code\":\"1\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGIN&agent_id=2004&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_LOGIN\", \"agentid\": \"2004\", "
			+ "\"requestparam\": \"login\", \"status\": \"FAIL###Agent already logged in.\", "
			+ "\"response_code\": \"-1\" } }";
	static final String failureRequest1 = "{\"agent_id\":\"2004\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"status\":\"FAIL###Agent already logged in.\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\","
			+ "\"status\":\"FAIL###Agent already logged in.\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGIN&agent_id=&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_LOGIN\", \"agentid\": \"\", "
			+ "\"requestparam\": \"login\", \"status\": \"FAIL\", " + "\"response_code\": \"-1\" } }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\","
			+ "\"status\":\"FAIL\"}";

	static final String urlFailureRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGIN&agent_id=&ip=&resFormat=3";
	static final String urlFailureResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_LOGIN\", \"agentid\": \"\", "
			+ "\"requestparam\": \"login\", \"status\": \"FAIL\", " + "\"response_code\": \"-1\" } }";
	static final String failureRequest3 = "{}";
	static final String failureResponse3 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse3 = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\","
			+ "\"status\":\"FAIL\"}";

}
