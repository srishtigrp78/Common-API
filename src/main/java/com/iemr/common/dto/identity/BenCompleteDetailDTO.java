package com.iemr.common.dto.identity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BenCompleteDetailDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BeneficiaryFamilyTags[] beneficiaryFamilyTags;
	// private null beneficiaryServiceMap;
	// private BeneficiaryDetails beneficiaryDetails;
	private String emergencyContactTyp;
	private String preferredSMSPhoneTyp;
	private BigInteger benRegId;
	private String modifiedBy;
	private String emergencyContactNum;
	private String preferredEmailId;
	private String preferredSMSPhoneNum;
	private Boolean deleted;
	// private null contacts;
	private Timestamp lastModDate;
	private String preferredPhoneNum;
	private BigInteger benMapId;
	private String createdBy;
	private Address currentAddress;
	private Address permanentAddress;
	private Address emergencyAddress;
	private String preferredPhoneTyp;
	private BigInteger benId;
	// private BeneficiaryIdentites[] beneficiaryIdentites;
	private Timestamp createdDate;
	

}
