package com.iemr.common.model.reports;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;
@Data
public class CallSummaryReport {

	private Long SNo;
	private Timestamp dateOfCall;
	private String callerPhoneNumber;
	private String agentID;
	private String agentName;
	private String skillSet;
	private String callType;
	private String callSubType;
	private Integer providerServiceMapID;
	private String closureRemark;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}
	
	public CallSummaryReport(Long SNo, Timestamp dateOfCall, String callerPhoneNumber,String agentID, String firstName,
			String receivedRoleName,String callTypeName, String callSubTypeName, Integer providerServiceMapID, String remarks) {
		this.SNo=SNo;
		this.dateOfCall=dateOfCall;
		this.callerPhoneNumber=callerPhoneNumber;
		this.agentID=agentID;
		this.agentName=firstName;
		this.skillSet=receivedRoleName;
		this.callType=callTypeName;
		this.callSubType=callSubTypeName;
		this.providerServiceMapID=providerServiceMapID;
		this.closureRemark=remarks;
	}
}
