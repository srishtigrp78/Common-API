package com.iemr.common.notification;

public interface ConstantEmergencyContacts
{
	final static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss.SSS"; 
	final static String providerServiceMapString1 = "{\"providerServiceMapID\":1224,\"serviceProviderID\":489,"
			+ "\"serviceProvider\":{\"serviceProviderID\":489,\"serviceProviderName\":\"PSMRI A\","
			+ "\"logoFileName\":\"\",\"logoFilePath\":\"\",\"primaryContactName\":\"Narendra\","
			+ "\"primaryContactNo\":\"1234567890\",\"primaryContactEmailID\":\"narendra@psmri.org\","
			+ "\"primaryContactAddress\":\"HYD,HYD\",\"secondaryContactName\":\"\",\"secondaryContactNo\":\"\","
			+ "\"secondaryContactEmailID\":\"\",\"secondaryContactAddress\":\"\",\"statusID\":2,\"status\":{},"
			+ "\"validFrom\":\"2017-11-20T00:00:00.000Z\",\"validTill\":\"2022-11-20T00:00:00.000Z\","
			+ "\"deleted\":false,\"createdBy\":\"Super Admin\",\"createdDate\":\"2017-11-20T00:00:00.000Z\","
			+ "\"lastModDate\":\"2017-11-20T00:00:00.000Z\"},\"serviceID\":1,\"m_ServiceMaster\":{"
			+ "\"serviceID\":1,\"serviceName\":\"1097\",\"serviceDesc\":\"1097 Helpline\",\"deleted\":false,"
			+ "\"createdBy\":\"Admin\"},\"stateID\":18,\"deleted\":false,\"createdBy\":\"Super Admin\","
			+ "\"createdDate\":\"2017-11-20T10:00:31.000Z\",\"lastModDate\":\"2017-11-20T10:19:34.000Z\","
			+ "\"ctiCampaignName\":\"UAT_1097_CO\",\"statusID\":2,\"status\":{}}";
	final static String notificationTypeString1 = "{\"notificationTypeID\":18,\"notificationType\":\"Alert\","
			+ "\"notificationTypeDesc\":null,\"providerServiceMapID\":null,\"deleted\":false,\"createdBy\":\"Admin\"}";
	final static String creationDateTime = "2018-01-08 11:33:46.0";

	final static String createEmergencyContactsSuccessRequest1 = "[{\"providerServiceMapID\": \"1224\", "
			+ "\"notificationTypeID\": \"10\", \"createdBy\": \"test1097_1\", \"designationID\":\"2\", "
			+ "\"emergContactNo\":\"1234567890\", \"emergContactDesc\": \"test contacts API\", "
			+ "\"notificationTypeID\":\"18\"}]";
	final static String createEmergencyContactsSuccessResonse1 = "[{\"emergContactID\":2,\"designationID\":2,"
			+ "\"designation\":null,\"emergContactName\":null,\"emergContactNo\":\"1234567890\","
			+ "\"emergContactDesc\":\"test contacts API\",\"location\":null,\"providerServiceMapID\":1224,"
			+ "\"providerServiceMapping\":{\"providerServiceMapID\":1224,\"m_UserServiceRoleMappings\":null,"
			+ "\"notifications\":null,\"serviceRoleScreenMapping\":null,\"screens\":null,\"directories\":null,"
			+ "\"feedbacks\":null,\"feedbackSeverities\":null,\"emergencyContacts\":null,\"blockNumbers\":null,"
			+ "\"serviceProviderID\":489,\"serviceProvider\":{\"serviceProviderID\":489,"
			+ "\"providerServiceMappings\":null,\"serviceProviderName\":\"PSMRI A\",\"joiningDate\":null,"
			+ "\"stateID\":null,\"logoFileName\":\"\",\"logoFilePath\":\"\",\"primaryContactName\":\"Narendra\","
			+ "\"primaryContactNo\":\"1234567890\",\"primaryContactEmailID\":\"narendra@psmri.org\","
			+ "\"primaryContactAddress\":\"HYD,HYD\",\"primaryContactValidityTillDate\":null,"
			+ "\"secondaryContactName\":\"\",\"secondaryContactNo\":\"\",\"secondaryContactEmailID\":\"\","
			+ "\"secondaryContactAddress\":\"\",\"secondaryContactValidityTillDate\":null,\"statusID\":2,"
			+ "\"status\":{\"statusID\":null,\"status\":null,\"statusDesc\":null,\"deleted\":null,\"createdBy\":null},"
			+ "\"validFrom\":\"2017-11-20T00:00:00.000Z\",\"validTill\":\"2022-11-20T00:00:00.000Z\",\"deleted\":false,"
			+ "\"createdBy\":\"Super Admin\",\"createdDate\":\"2017-11-20T00:00:00.000Z\",\"modifiedBy\":null,"
			+ "\"lastModDate\":\"2017-11-20T00:00:00.000Z\"},\"serviceID\":1,\"m_ServiceMaster\":{\"serviceID\":1,"
			+ "\"serviceName\":\"1097\",\"serviceDesc\":\"1097 Helpline\",\"deleted\":false,\"createdBy\":\"Admin\","
			+ "\"m_UserServiceRoleMapping\":null,\"subServices\":null},\"countryID\":null,\"stateID\":18,"
			+ "\"districtID\":null,\"cityID\":null,\"districtBlockID\":null,\"address\":null,\"deleted\":false,"
			+ "\"createdBy\":\"Super Admin\",\"createdDate\":\"2017-11-20T10:00:31.000Z\",\"modifiedBy\":null,"
			+ "\"lastModDate\":\"2017-11-20T10:19:34.000Z\",\"ctiCampaignName\":\"UAT_1097_CO\",\"statusID\":2,"
			+ "\"status\":{\"statusID\":null,\"status\":null,\"statusDesc\":null,\"deleted\":null,\"createdBy\":null}},"
			+ "\"notificationTypeID\":18,\"notificationType\":{\"notificationTypeID\":18,\"notificationType\":\"Alert\","
			+ "\"notificationTypeDesc\":null,\"providerServiceMapID\":null,\"deleted\":false,\"createdBy\":\"Admin\"},"
			+ "\"deleted\":false,\"processed\":null,\"createdBy\":null,\"createdDate\":\"2018-01-08T11:33:46.000Z\","
			+ "\"modifiedBy\":null,\"lastModDate\":null}]";
	static final String failureRequest1 = null;

}
