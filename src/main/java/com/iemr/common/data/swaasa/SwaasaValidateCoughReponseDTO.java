package com.iemr.common.data.swaasa;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SwaasaValidateCoughReponseDTO {

	private String status;
	private Map<String, Object> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
