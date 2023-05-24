package com.iemr.common.cti;

public interface ConstantUserLogin extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_LOGIN_KEY&username=test1097_1&password=Test@123&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_LOGIN_KEY\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"username\" : \"test1097_1\", "
			+ "\"login_key\" : \"66261306768283\", \"reason\": \"\"} }";
	static final String successRequest1 = "{username:\"test1097_1\", password:\"Test@123\"}";
	static final String successResponse1 = "{\"data\":{\"username\":\"test1097_1\",\"password\":\"Test@123\","
			+ "\"transaction_id\":\"CTI_LOGIN_KEY\",\"login_key\":\"66261306768283\",\"reason\":\"\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"response\":{\"transaction_id\":\"CTI_LOGIN_KEY\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"login_key\":\"66261306768283\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"username\":\"test1097_1\",\"password\":\"Test@123\","
			+ "\"transaction_id\":\"CTI_LOGIN_KEY\",\"login_key\":\"66261306768283\",\"reason\":\"\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"response\":{\"transaction_id\":\"CTI_LOGIN_KEY\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"login_key\":\"66261306768283\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_LOGIN_KEY&username=test1097&password=Test@123&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_LOGIN_KEY\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"username\" : \"test1097\", \"login_key\" : \"0\", "
			+ "\"reason\": \"username or password is incorrect.\"} }";
	static final String failureRequest1 = "{username:\"test1097\", password:\"Test@123\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"username or password is incorrect.\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"username or password is incorrect.\",\"status\":\"FAILURE\"}";

}
