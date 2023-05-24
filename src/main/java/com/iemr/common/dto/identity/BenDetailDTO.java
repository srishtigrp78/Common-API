package com.iemr.common.dto.identity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BenDetailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigInteger beneficiaryDetailsId;
	private Integer areaId;
	private BigInteger beneficiaryRegID;
	private Integer communityId;
	private String community;
	private String createdBy;
	private Timestamp createdDate;
	private Boolean deleted = false;
	private Timestamp dob;
	private Integer educationId;
	private String education;
	private Boolean emergencyRegistration;
	private String fatherName;
	private String firstName;
	private Integer genderId;
	private String gender;
	private String incomeStatus;
	private Integer incomeStatusId;
	private Timestamp lastModDate;
	private String lastName;
	private Integer maritalStatusId;
	private String maritalStatus;
	private String middleName;
	private String modifiedBy;
	private Integer occupationId;
	private String occupation;
	private Integer phcId;
	private String placeOfWork;
	private String preferredLanguage;
	private Integer preferredLanguageId;
	private String religion;
	private Integer religionId;
	private String remarks;
	private BigInteger servicePointId;
	private String sourceOfInfo;
	private String spouseName;
	private String status;
	private Integer statusId;
	private Integer titleId;
	private String title;
	private Integer zoneId;
	private Short sexualOrientationID;
	private Short healthCareWorkerId;
	private String isHIVPositive;
	private Integer beneficiaryAge;

	private Long houseHoldID;
	private String guideLineID;
	private String rchID;
	
	// family tagging
	private Integer headOfFamily_RelationID;
	private String familyId;
	private String other;
	private String headOfFamily_Relation;
}
