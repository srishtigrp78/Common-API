package com.iemr.common.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.common.model.userbeneficiary.DesignationModel;
import com.iemr.common.model.userbeneficiary.GenderModel;
import com.iemr.common.model.userbeneficiary.MaritalStatusModel;
import com.iemr.common.model.userbeneficiary.StatusModel;

import lombok.Data;

public @Data class LoginResponseModel
{
	private Long userID;
	private List<UserServiceRoleMappingModel> userServiceRoleMappings;
	// private List<OutboundCallRequestModel> outboundCallRequests;
	private List<UserServiceRoleMappingModel> roleMappings;
	private List<UserLangMappingModel> userLangMappings;
	// private List<FeedbackDetailsModel> feedbackDetails;
	private Integer titleID;
	private TitleModel title;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer genderID;
	private GenderModel genderModel;
	private Integer maritalStatusID;
	private MaritalStatusModel maritalstatus;
	private Integer statusID;
	private StatusModel status;
	private String aadhaarNo;
	private String pAN;
	private Timestamp dOB;
	private Timestamp dOJ;
	private Integer qualificationID;
	private String userName;
	// private String password;
	private String emailID;
	private String emergencyContactPerson;
	private String emergencyContactNo;
	private Boolean isSupervisor;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
	// private String agentID;
	private Integer designationID;
	private DesignationModel designationModel;
	private String agentPassword;
	private String newPassword = null;
	private String loginKey;
	private String ipAddress;
	private String hostName;
}
