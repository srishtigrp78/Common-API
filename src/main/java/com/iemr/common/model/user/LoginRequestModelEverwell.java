package com.iemr.common.model.user;

import java.sql.Timestamp;

import lombok.Data;

public @Data class LoginRequestModelEverwell {

	private String everwellUserName;
	private String everwellPassword;
	private String everwellAuthKey;

	public LoginRequestModelEverwell() {

	}

	public LoginRequestModelEverwell(String everwellUserName, String everwellPassword, String everwellAuthKey) {
		this.everwellUserName = everwellUserName;
		this.everwellPassword = everwellPassword;
		this.everwellAuthKey = everwellAuthKey;
	}
}
