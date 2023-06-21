package com.iemr.common.model.sms;

public class SmsAPIRequestModel {
	
	private String customerId;
	private StringBuffer destinationAddress;
	private String message;
	private String sourceAddress;
	private String messageType;
	private String dltTemplateId;
	private String entityId;
	
	
	public SmsAPIRequestModel(String customerId, StringBuffer destinationAddress, String message,
			String sourceAddress, String messageType, String dltTemplateId, String entityId) {
		this.customerId = customerId;
		this.destinationAddress = destinationAddress;
		this.message = message;
		this.sourceAddress = sourceAddress;
		this.messageType = messageType;
		this.dltTemplateId = dltTemplateId;
		this.entityId = entityId;
	}


}
