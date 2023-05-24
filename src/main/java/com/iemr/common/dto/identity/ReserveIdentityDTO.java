package com.iemr.common.dto.identity;

import lombok.Data;

@Data
public class ReserveIdentityDTO {

	private Integer providerServiceMapID;
	private String vehicalNo;
	private Long reserveCount;
}
