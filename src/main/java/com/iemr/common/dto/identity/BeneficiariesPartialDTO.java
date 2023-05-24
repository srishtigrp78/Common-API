package com.iemr.common.dto.identity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BeneficiariesPartialDTO
{
	private String benId;
	private Long benRegId;
	private Long beneficiaryDetailsId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Timestamp lastModDate;
	private Integer beneficiaryAge;
	private String fatherName;
	private String spouseName;
	private Integer benficiaryAge;

}
