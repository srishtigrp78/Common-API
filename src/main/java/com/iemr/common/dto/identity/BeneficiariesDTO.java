package com.iemr.common.dto.identity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import com.iemr.common.model.beneficiary.AbhaAddressDTO;

import lombok.Data;

@Data
public class BeneficiariesDTO {
	private BigInteger benMapId; //
	private String benId;
	private BigInteger benRegId;
	private String createdBy; //
	private Timestamp createdDate; //
	// private Boolean deleted; //
	private Timestamp lastModDate; //
	private String modifiedBy; //
	private Address currentAddress; //
	private Address permanentAddress; //
	private Address emergencyAddress; //
	private String preferredPhoneNum; //
	private String preferredPhoneTyp; //
	private String preferredSMSPhoneNum; //
	private String preferredSMSPhoneTyp; //
	private String emergencyContactNum; //
	private String emergencyContactTyp; //
	private String preferredEmailId; //
	private BenDetailDTO beneficiaryDetails;
	private List<BenFamilyDTO> beneficiaryFamilyTags;
	// private List<BenFamilyDTO> benFamilyDTOs;
	private List<BenIdentityDTO> beneficiaryIdentites;
	private List<BenServiceDTO> beneficiaryServiceMap;
	private List<Phone> contacts;

	// Start Outreach
	// New columns added for MMU integration 09-04-2018
	private Timestamp marriageDate;
	private Integer ageAtMarriage;
	private String literacyStatus;
	private String motherName;
	private String email;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private String accountNo;
	private Long benAccountID;
	private Long benImageID;
	private Integer occupationId;
	private String occupation;
	private String incomeStatus;
	private BigInteger religionId;
	private String religion;

	// End Outreach

	// Start 1097
	private Integer beneficiaryAge;
	// end 1097

	// ABHA address
	List<AbhaAddressDTO> abhaDetails;
}
