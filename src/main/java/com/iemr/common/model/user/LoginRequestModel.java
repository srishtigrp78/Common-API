package com.iemr.common.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = { "authKey" })
public @Data class LoginRequestModel
{
	private String userName;
	private String password;
	private String authKey;
	private Boolean doLogout;
	
	
	
	public LoginRequestModel() {
		
	}
	//everwell-1097 registration
	public LoginRequestModel(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	
}
