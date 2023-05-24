package com.iemr.common.data.door_to_door_app;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class RequestParser {

	private Integer userID;
	private Long benRegID;
	private Long visitCode;

	private String suspectedTB;
	private String suspectedHRP;
	private String suspectedNCD;
	private String suspectedNCDDiseases;

	public RequestParser() {
	}

	public RequestParser(Long benRegID, String suspectedTB, String suspectedHRP, String suspectedNCD,
			String suspectedNCDDiseases) {
		super();
		this.benRegID = benRegID;
		this.suspectedTB = suspectedTB;
		this.suspectedHRP = suspectedHRP;
		this.suspectedNCD = suspectedNCD;
		this.suspectedNCDDiseases = suspectedNCDDiseases;
	}

}
