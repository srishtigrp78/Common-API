package com.iemr.common.data.helpline104history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Data
@Table(name="t_requestedbloodbank")
public class T_RequestedBloodBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long requestedBloodBankID;
	
	@Expose
	private Long bloodReqID;
	
	@Expose
	private String BloodBankAddress;
	
	@Expose
	private String BBPersonName;
	
	@Expose
	private String BBMobileNo;
	
	@Expose
	private String BBPersonDesignation;
	
}
