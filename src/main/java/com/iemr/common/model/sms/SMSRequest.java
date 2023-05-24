package com.iemr.common.model.sms;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.common.data.telemedicine.PrescribedDrugDetail;

import lombok.Data;

@Data
public class SMSRequest {
	private Integer providerServiceMapID;
	private Integer smsTemplateTypeID;
	private Integer smsTemplateID;
	private Long beneficiaryRegID;
	private Integer stateID;
	private Integer districtID;
	private Integer blockID;
	private Boolean is1097 = false;
	private Long userID;
	private Integer InstituteID;
	private Long feedbackID;
	private String createdBy;
	private String alternateNo;
	private String smsText;
	private Long prescribedDrugID;
	private Long bloodReqID;
	private Long directoryServiceID;
	private Long fSComplaintID;
	private String requestID;
	private Long outbreakComplaintID;
	private Long obCallID;
	private Boolean isBloodBankSMS = false;
	private String moAdvice;
	private Long organDonationID;
	private Long requestedBloodBankID;
	private Long requestedInstitutionID;

	private Integer specializationID;
	private String smsTypeTM;
	private String tcDate;
	private String tcPreviousDate;
	private List<PrescribedDrugDetail> presObj;
	private List<Object> diagnosis;
	private Long benHistoryID;	
	private String imrDate;
	private String imrID;
	private String nodalNumber;
	private String informerName;
	private String choName;
	private String facilityPhoneNo;
	private String benPhoneNo;
	private String employeeCode;
	private String facilityName;
	private String hfrId;
	private String beneficiaryName;
	private Long beneficiaryId;
	private String appointmentDate;
	private String appointmentTime;
}
