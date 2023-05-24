package com.iemr.common.cti;

public interface ContantAddUpdateAgentSkills extends Constants
{
	static final String urlRequestSuccess1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_AGENT_SKILL_ADDUPDATE&"
			+ "agent_id=2003&skill=Hindi&weight=30&type=add&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String requestSuccess1 = "{\"agent_id\":2003, \"skill\":\"Hindi\", "
			+ "\"weight\":\"30\", \"type\":\"add\"}";
	static final String urlResponseSuccess1 = "{ \"response\": { "
			+ "\"transaction_id\": \"CTI_AGENT_SKILL_ADDUPDATE\" , \"response_code\": \"1\", "
			+ "\"status\": \"SUCCESS\", \"agent_id\" : \"2003\", \"skill\" : \"Hindi\", "
			+ "\"weight\" : \"30\", \"reason\": \"\"} }";
	static final String responseSuccess1 = "{\"data\":{\"agent_id\":\"2003\",\"skill\":\"Hindi\","
			+ "\"weight\":\"30\",\"type\":\"add\",\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\","
			+ "\"agent_id\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"skill\":\"Hindi\","
			+ "\"weight\":\"30\"}},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerResponseSuccess1 = "{\"data\":{\"agent_id\":\"2003\",\"skill\":\"Hindi\","
			+ "\"weight\":\"30\",\"type\":\"add\",\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\","
			+ "\"agent_id\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"skill\":\"Hindi\","
			+ "\"weight\":\"30\"}},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlRequestSuccess2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_AGENT_SKILL_ADDUPDATE&agent_id=2003"
			+ "&skill=English&weight=30&type=update&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String requestSuccess2 = "{\"agent_id\":2003, \"skill\":\"English\", "
			+ "\"weight\":\"30\", \"type\":\"update\"}";
	static final String urlResponseSuccess2 = "{ \"response\": { "
			+ "\"transaction_id\": \"CTI_AGENT_SKILL_ADDUPDATE\" , \"response_code\": \"1\", "
			+ "\"status\": \"SUCCESS\", \"agent_id\" : \"2003\", \"skill\" : \"English\", "
			+ "\"weight\" : \"30\", \"reason\": \"\"} }";
	static final String responseSuccess2 = "{\"data\":{\"agent_id\":\"2003\",\"skill\":\"English\","
			+ "\"weight\":\"30\",\"type\":\"update\",\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\",\"agent_id\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skill\":\"English\",\"weight\":\"30\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerResponseSuccess2 = "{\"data\":{\"agent_id\":\"2003\",\"skill\":\"English\","
			+ "\"weight\":\"30\",\"type\":\"update\",\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_AGENT_SKILL_ADDUPDATE\",\"agent_id\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skill\":\"English\",\"weight\":\"30\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	
	
	static final String urlRequestFailure1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_AGENT_SKILL_ADDUPDATE&agent_id=2003&"
			+ "skill=English&weight=30&type=add&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlResponseFailure1 = "{ \"response\": { "
			+ "\"transaction_id\": \"CTI_AGENT_SKILL_ADDUPDATE\" , \"response_code\": \"0\", "
			+ "\"status\": \"FAILURE\", \"agent_id\" : \"2003\", \"skill\" : \"English\", "
			+ "\"weight\" : \"30\", \"reason\": \"skill is already exist.\"} }";
	static final String requestFailure1 = "{\"agent_id\":2003, \"skill\":\"English\", "
			+ "\"weight\":\"30\", \"type\":\"add\"}";
	static final String responseFailure1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is already exist.\",\"status\":\"FAILURE\"}";
	static final String controllerResponseFailure1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is already exist.\",\"status\":\"FAILURE\"}";

	static final String urlRequestFailure2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_AGENT_SKILL_ADDUPDATE&agent_id=2003&"
			+ "skill=Tamil&weight=30&type=add&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlResponseFailure2 = "{ \"response\": { "
			+ "\"transaction_id\": \"CTI_AGENT_SKILL_ADDUPDATE\" , \"response_code\": \"0\", "
			+ "\"status\": \"FAILURE\", \"agent_id\" : \"2003\", \"skill\" : \"Tamil\", "
			+ "\"weight\" : \"30\", \"reason\": \"skill is not exist.\"} }";
	static final String requestFailure2 = "{\"agent_id\":2003, \"skill\":\"Tamil\", "
			+ "\"weight\":\"30\", \"type\":\"add\"}";
	static final String responseFailure2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is not exist.\",\"status\":\"FAILURE\"}";
	static final String controllerResponseFailure2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is not exist.\",\"status\":\"FAILURE\"}";

	static final String urlRequestFailure3 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_AGENT_SKILL_ADDUPDATE&agent_id=2003&"
			+ "skill=&weight=&type=add&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlResponseFailure3 = "{ \"response\": { "
			+ "\"transaction_id\": \"CTI_AGENT_SKILL_ADDUPDATE\" , \"response_code\": \"0\", "
			+ "\"status\": \"FAILURE\", \"agent_id\" : \"2003\", \"skill\" : \"\", "
			+ "\"weight\" : \"30\", \"reason\": \"skill is missing\"} }";
	static final String requestFailure3 = "{\"agent_id\":2003, \"type\":\"add\"}";
	static final String responseFailure3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is missing\",\"status\":\"FAILURE\"}";
	static final String controllerResponseFailure3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is missing\",\"status\":\"FAILURE\"}";

	static final String urlRequestFailure4 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_AGENT_SKILL_ADDUPDATE&agent_id=2003&"
			+ "skill=Tamil&weight=30&type=update&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlResponseFailure4 = "{ \"response\": { "
			+ "\"transaction_id\": \"CTI_AGENT_SKILL_ADDUPDATE\" , \"response_code\": \"0\", "
			+ "\"status\": \"FAILURE\", \"agent_id\" : \"2003\", \"skill\" : \"Tamil\", "
			+ "\"weight\" : \"30\", \"reason\": \"skill is not exist.\"} }";
	static final String requestFailure4 = "{\"agent_id\":2003, \"skill\":\"Tamil\", "
			+ "\"weight\":\"30\", \"type\":\"update\"}";
	static final String responseFailure4 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is not exist.\",\"status\":\"FAILURE\"}";
	static final String controllerResponseFailure4 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"skill is not exist.\",\"status\":\"FAILURE\"}";

}