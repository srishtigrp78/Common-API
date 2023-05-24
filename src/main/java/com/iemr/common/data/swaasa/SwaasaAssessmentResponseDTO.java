package com.iemr.common.data.swaasa;

import org.springframework.stereotype.Component;

@Component
public class SwaasaAssessmentResponseDTO {

	private String status;
	private Swaasa data;
	private String assessmentId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Swaasa getData() {
		return data;
	}

	public void setData(Swaasa data) {
		this.data = data;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

}
