package com.iemr.common.data.everwell;

import java.sql.Timestamp;

public class EverwellSupportAction {
	//private Long everwellid;
	private Boolean addDose;
	private Timestamp dateOfAction;
//	public Long getEverwellid() {
//		return everwellid;
//	}
//	public void setEverwellid(Long everwellid) {
//		this.everwellid = everwellid;
//	}
	public Boolean getAddDose() {
		return addDose;
	}
	public void setAddDose(Boolean addDose) {
		this.addDose = addDose;
	}
	public Timestamp getDateOfAction() {
		return dateOfAction;
	}
	public void setDateOfAction(Timestamp dateOfAction) {
		this.dateOfAction = dateOfAction;
	}

}
