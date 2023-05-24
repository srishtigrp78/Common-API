package com.iemr.common.model.user;

import lombok.Data;

@Data
public class ForceLogoutRequestModel
{
	private String userName;
	private Integer providerServiceMapID;
	private String password;
}
