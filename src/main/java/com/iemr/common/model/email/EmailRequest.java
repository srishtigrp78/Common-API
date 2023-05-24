package com.iemr.common.model.email;

import lombok.Data;

@Data
public class EmailRequest {

	private String requestID;
	private String emailType;
	private String emailID;
}
