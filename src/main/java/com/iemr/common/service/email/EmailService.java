package com.iemr.common.service.email;

public interface EmailService {

	public String SendEmail(String request, String authToken) throws Exception;
	
	public String sendEmailGeneral(String emailRequest, String authToken) throws Exception;

	public String getAuthorityEmailID(String request) throws Exception;

	public void publishEmail();
}
