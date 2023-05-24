package com.iemr.common.model.user;

import lombok.Data;

@Data
public class ChangePasswordModel
{
	private String userName;
	private String password;
	private String newPassword;
	private String transactionId;
	private Boolean isAdmin;
}
