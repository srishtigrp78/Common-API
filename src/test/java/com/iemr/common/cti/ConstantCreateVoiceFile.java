package com.iemr.common.cti;

public interface ConstantCreateVoiceFile extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_MIX_VOICE_FILE&agent_id=2003&"
			+ "session_id=1511338154.2409000000&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_MIX_VOICE_FILE\", "
			+ "\"session_id\": \"1511338154.2409000000\", \"requestparam\": \"MIX_VOICE_FILE\", "
			+ "\"status\": \"1\", \"result\": \"SUCCESS\", \"response_code\": \"1\" } }";
	static final String successRequest1 = "{agent_id:2003, \"session_id\": \"1511338154.2409000000\"}";
	static final String successResponse1 = "{\"data\":{\"response\":{\"transaction_id\":\"CTI_MIX_VOICE_FILE\","
			+ "\"requestparam\":\"MIX_VOICE_FILE\",\"status\":\"1\",\"response_code\":\"1\","
			+ "\"session_id\":\"1511338154.2409000000\",\"result\":\"SUCCESS\"},\"agent_id\":\"2003\","
			+ "\"session_id\":\"1511338154.2409000000\",\"transaction_id\":\"CTI_MIX_VOICE_FILE\","
			+ "\"status\":\"1\",\"response_code\":\"1\",\"result\":\"SUCCESS\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"response\":{"
			+ "\"transaction_id\":\"CTI_MIX_VOICE_FILE\",\"requestparam\":\"MIX_VOICE_FILE\","
			+ "\"status\":\"1\",\"response_code\":\"1\",\"session_id\":\"1511338154.2409000000\","
			+ "\"result\":\"SUCCESS\"},\"agent_id\":\"2003\",\"session_id\":\"1511338154.2409000000\","
			+ "\"transaction_id\":\"CTI_MIX_VOICE_FILE\",\"status\":\"1\",\"response_code\":\"1\","
			+ "\"result\":\"SUCCESS\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_MIX_VOICE_FILE&agent_id=2003&"
			+ "session_id=1511338154.2409000000&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_MIX_VOICE_FILE\", "
			+ "\"session_id\": \"1511338154.2409000000\", \"requestparam\": \"MIX_VOICE_FILE\", "
			+ "\"status\": \"1\", \"result\": \"FILE Exist\", \"response_code\": \"1\" } }";
	static final String successRequest2 = "{agent_id:2003, \"session_id\": \"1511338154.2409000000\"}";
	static final String successResponse2 = "{\"data\":{\"response\":{\"transaction_id\":\"CTI_MIX_VOICE_FILE\","
			+ "\"requestparam\":\"MIX_VOICE_FILE\",\"status\":\"1\",\"response_code\":\"1\","
			+ "\"session_id\":\"1511338154.2409000000\",\"result\":\"FILE Exist\"},"
			+ "\"agent_id\":\"2003\",\"session_id\":\"1511338154.2409000000\","
			+ "\"transaction_id\":\"CTI_MIX_VOICE_FILE\",\"status\":\"1\",\"response_code\":\"1\","
			+ "\"result\":\"FILE Exist\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse2 = "{\"data\":{\"response\":{\"transaction_id\":\"CTI_MIX_VOICE_FILE\","
			+ "\"requestparam\":\"MIX_VOICE_FILE\",\"status\":\"1\",\"response_code\":\"1\","
			+ "\"session_id\":\"1511338154.2409000000\",\"result\":\"FILE Exist\"},"
			+ "\"agent_id\":\"2003\",\"session_id\":\"1511338154.2409000000\","
			+ "\"transaction_id\":\"CTI_MIX_VOICE_FILE\",\"status\":\"1\",\"response_code\":\"1\","
			+ "\"result\":\"FILE Exist\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_MIX_VOICE_FILE&agent_id=2003&"
			+ "session_id=15113381541.2409000000&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_MIX_VOICE_FILE\", "
			+ "\"session_id\": \"15113381541.2409000000\", \"requestparam\": \"MIX_VOICE_FILE\", "
			+ "\"status\": \"FAIL\", \"result\": \"FAIL\", \"response_code\": \"-1\", reason:\"Failure\"} }";
	static final String failureRequest1 = "{agent_id:2003, \"session_id\": \"15113381541.2409000000\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"Failure\",\"status\":\"FAIL\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"Failure\","
			+ "\"status\":\"FAIL\"}";

}
