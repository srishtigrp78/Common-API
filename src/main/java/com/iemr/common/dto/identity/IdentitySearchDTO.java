package com.iemr.common.dto.identity;

import java.math.BigInteger;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class IdentitySearchDTO {

	private BigInteger beneficiaryId;
	private BigInteger beneficiaryRegId;

	private String firstName;
	private String middleName;
	private String lastName;

	private Integer ageId;
	private Integer age;
	private Integer genderId;
	private String genderName;

	private String spouseName;
	private String fatherName;

	private String pinCode;
	private Address currentAddress;
	private Address permanentAddress;
	private Address emergencyAddress;

	private String contactNumber;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp dob;

	// new column added for D2D, 21-01-2021
	private Long houseHoldID;
	private Boolean isD2D;
}
