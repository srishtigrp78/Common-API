package com.iemr.common.model.reports;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Report1097RequestModel
{
	private Integer providerServiceMapID;
	private String callType /* = "%%" */;
	private String callSubType /* = "%%" */;
	private String beneficiaryCallType /* = "%%" */;
	private String beneficiaryCallSubType /* = "%%" */;
	@JsonFormat(pattern = "yyyy-MM-dd'T'00:00:00.000'Z'")
	private Timestamp startTimestamp;
	@JsonFormat(pattern = "yyyy-MM-dd'T'23:59:59.999'Z'")
	private Timestamp endTimestamp;
	private Integer minAge = 0;
	private Integer maxAge = 150;
	private String state /* = "%%" */;
	private String district /* = "%%" */;
	private String gender /* = "%%" */;
	private String beneficiaryPreferredLanguage /* = "%%" */;
	private String title /* = "%%" */;
	private String maritalStatus /* = "%%" */;
	private String beneficiarySexualOrientation /* = "%%" */;
	private String education /* = "%%" */;
	private String occupation /* = "%%" */;
	private String healthcareWorker /* = "%%" */;
	private String incomeStatus /* = "%%" */;
	private String community /* = "%%" */;
	private String religion /* = "%%" */;
	private String placeOfWork /* = "%%" */;
	private String subDistrict /* = "%%" */;
	private String callerAgeGroup;
	

}
