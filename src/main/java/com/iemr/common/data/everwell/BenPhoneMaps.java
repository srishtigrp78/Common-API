package com.iemr.common.data.everwell;

public class BenPhoneMaps {

	private Integer benRelationshipID;
	private String phoneNo;
	private String phoneNoEverwell;
	private String createdBy;
	private boolean deleted;
	
	public BenPhoneMaps() {
		
	}
	
	public BenPhoneMaps(Integer benRelationshipID, String phoneNo, String createdBy,boolean deleted ) {
		this.benRelationshipID = benRelationshipID;
		this.phoneNo = phoneNo;
		this.createdBy = createdBy;
		this.deleted = deleted;
	}
	
//	public BenPhoneMaps(Integer benRelationshipID, String phoneNo, String createdBy,boolean deleted ) {
//		this.benRelationshipID = benRelationshipID;
//		this.phoneNoEverwell = phoneNo;
//		this.createdBy = createdBy;
//		this.deleted = deleted;
//	}
}
