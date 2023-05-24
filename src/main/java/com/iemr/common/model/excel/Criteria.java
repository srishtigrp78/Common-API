package com.iemr.common.model.excel;

public class Criteria {
	String Start_Date;
	String End_Date;
	String Service;
	String AgentID;
	String RoleID;
	String CallTypeID;
	String CallTypeName;
	String State;
	String District;
	String Language;
	String CallerAgeGroup;
	String Call_Type;
	String Call_Sub_Type;
	String Gender;
	String Sexual_Orientation;


	public String getStart_Date() {
		return Start_Date;
	}

	public String getCallTypeID() {
		return CallTypeID;
	}

	public void setCallTypeID(String callTypeID) {
		CallTypeID = callTypeID;
	}

	public String getCallTypeName() {
		return CallTypeName;
	}

	public void setCallTypeName(String callTypeName) {
		CallTypeName = callTypeName;
	}

	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}

	public String getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}

	public String getService() {
		return Service;
	}

	public void setService(String service) {
		Service = service;
	}

	public String getAgentID() {
		return AgentID;
	}

	public void setAgentID(String agentID) {
		AgentID = agentID;
	}

	public String getRoleID() {
		return RoleID;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getCall_Type() {
		return Call_Type;
	}

	public void setCall_Type(String call_Type) {
		Call_Type = call_Type;
	}

	public String getCall_Sub_Type() {
		return Call_Sub_Type;
	}

	public void setCall_Sub_Type(String call_Sub_Type) {
		Call_Sub_Type = call_Sub_Type;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getSexual_Orientation() {
		return Sexual_Orientation;
	}

	public void setSexual_Orientation(String sexual_Orientation) {
		Sexual_Orientation = sexual_Orientation;
	}

	public void setRoleID(String roleID) {
		RoleID = roleID;
	}


	public String getCallerAgeGroup() {
		return CallerAgeGroup;
	}

	public void setCallerAgeGroup(String callerAgeGroup) {
		CallerAgeGroup = callerAgeGroup;
	}

}
