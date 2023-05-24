package com.iemr.common.data.uptsu;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class SmsRequestOBJ {
	
	private String choName;
	private String facilityPhoneNo;
	private String benPhoneNo;
	private String employeeCode;
	private String facilityName;
	private String hfrId;
	private String beneficiaryName;
	private Long beneficiaryId;
//	private Timestamp appointmentDate;
//	private Timestamp appointmentTime;
	private Integer smsTemplateID;
	private String choSms;
	private String benSms;
	private Integer smsTemplateTypeID;
	private String appointmentTime;
	private String appointmentDate;
	private Long beneficiaryRegID;
	private String createdBy;
	

}
