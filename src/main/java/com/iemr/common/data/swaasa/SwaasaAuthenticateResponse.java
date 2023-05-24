package com.iemr.common.data.swaasa;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class SwaasaAuthenticateResponse {

	private String status;
	private String accessToken;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
