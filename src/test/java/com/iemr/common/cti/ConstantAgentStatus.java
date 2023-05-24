package com.iemr.common.cti;

public interface ConstantAgentStatus extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_AGENT_CALL_RECORD&agent_id=2003&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_AGENT_CALL_RECORD\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"agent_id\" : \"2003\", \"total_calls\" : \"1\", "
			+ "\"total_invalid_calls\" : \"0\", \"total_call_duration\" : \"00:00:21\", "
			+ "\"total_free_time\" : \"03:44:14\", \"total_break_time\" : \"00:00:35\", " + "\"reason\": \"\"} }";
	static final String successRequest1 = "{\"agent_id\":\"2003\"}";
	static final String successResponse1 = "{\"data\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\",\"agent_id\":\"2003\","
			+ "\"total_calls\":\"1\",\"total_invalid_calls\":\"0\",\"total_call_duration\":\"00:00:21\","
			+ "\"total_free_time\":\"03:44:14\",\"total_break_time\":\"00:00:35\",\"response_code\":\"1\","
			+ "\"response\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\",\"agent_id\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"total_calls\":\"1\",\"total_invalid_calls\":\"0\","
			+ "\"total_call_duration\":\"00:00:21\",\"total_free_time\":\"03:44:14\",\"total_break_time\":\"00:00:35\"},"
			+ "\"status\":\"SUCCESS\",\"reason\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final Object controllerSuccessResponse1 = "{\"data\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\","
			+ "\"agent_id\":\"2003\",\"total_calls\":\"1\",\"total_invalid_calls\":\"0\","
			+ "\"total_call_duration\":\"00:00:21\",\"total_free_time\":\"03:44:14\",\"total_break_time\":\"00:00:35\","
			+ "\"response_code\":\"1\",\"response\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\",\"agent_id\":\"2003\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"total_calls\":\"1\","
			+ "\"total_invalid_calls\":\"0\",\"total_call_duration\":\"00:00:21\",\"total_free_time\":\"03:44:14\","
			+ "\"total_break_time\":\"00:00:35\"},\"status\":\"SUCCESS\",\"reason\":\"\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_AGENT_CALL_RECORD&agent_id=2003&ip=&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_AGENT_CALL_RECORD\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"agent_id\" : \"2003\", \"total_calls\" : \"1\", "
			+ "\"total_invalid_calls\" : \"0\", \"total_call_duration\" : \"00:00:21\", "
			+ "\"total_free_time\" : \"03:44:14\", \"total_break_time\" : \"00:00:35\", " + "\"reason\": \"\"} }";
	static final String successRequest2 = "{\"agent_id\":\"2003\"}";
	static final String successResponse2 = "{\"data\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\","
			+ "\"agent_id\":\"2003\",\"total_calls\":\"1\",\"total_invalid_calls\":\"0\","
			+ "\"total_call_duration\":\"00:00:21\",\"total_free_time\":\"03:44:14\",\"total_break_time\":\"00:00:35\","
			+ "\"response_code\":\"1\",\"response\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\","
			+ "\"agent_id\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\","
			+ "\"total_calls\":\"1\",\"total_invalid_calls\":\"0\",\"total_call_duration\":\"00:00:21\","
			+ "\"total_free_time\":\"03:44:14\",\"total_break_time\":\"00:00:35\"},\"status\":\"SUCCESS\","
			+ "\"reason\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final Object controllerSuccessResponse2 = "{\"data\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\","
			+ "\"agent_id\":\"2003\",\"total_calls\":\"1\",\"total_invalid_calls\":\"0\","
			+ "\"total_call_duration\":\"00:00:21\",\"total_free_time\":\"03:44:14\",\"total_break_time\":\"00:00:35\","
			+ "\"response_code\":\"1\",\"response\":{\"transaction_id\":\"CTI_AGENT_CALL_RECORD\",\"agent_id\":\"2003\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"total_calls\":\"1\","
			+ "\"total_invalid_calls\":\"0\",\"total_call_duration\":\"00:00:21\",\"total_free_time\":\"03:44:14\","
			+ "\"total_break_time\":\"00:00:35\"},\"status\":\"SUCCESS\",\"reason\":\"\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_AGENT_CALL_RECORD&agent_id=&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_AGENT_CALL_RECORD\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"agent_id\" : \"\", \"total_calls\" : \"0\", "
			+ "\"total_invalid_calls\" : \"0\", \"total_call_duration\" : \"0\", \"total_free_time\" : \"0\", "
			+ "\"total_break_time\" : \"0\", \"reason\": \"Agent Id is missing.\"} }";
	static final String failureRequest1 = "{}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"Agent Id is missing.\","
			+ "\"status\":\"FAILURE\"}";
	static final Object controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"Agent Id is missing.\","
			+ "\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_AGENT_CALL_RECORD&agent_id=&ip=&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_AGENT_CALL_RECORD\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"agent_id\" : \"\", \"total_calls\" : \"0\", "
			+ "\"total_invalid_calls\" : \"0\", \"total_call_duration\" : \"0\", \"total_free_time\" : \"0\", "
			+ "\"total_break_time\" : \"0\", \"reason\": \"Agent Id is missing.\"} }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Agent Id is missing.\","
			+ "\"status\":\"FAILURE\"}";
	static final Object controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Agent Id is missing.\","
			+ "\"status\":\"FAILURE\"}";

}
