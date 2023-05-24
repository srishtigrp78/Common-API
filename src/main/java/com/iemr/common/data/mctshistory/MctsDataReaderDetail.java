package com.iemr.common.data.mctshistory;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
@Entity
@Table(name = "t_mothervalidrecord")
public class MctsDataReaderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long MotherValidRecordID;
	
	@Expose
	@Column(name = "BeneficiaryRegID", insertable = true, updatable = false)
	private Long BeneficiaryRegID;

	@Expose
	@Column(name = "MCTSID_no", insertable = true, updatable = true) 
	private Long MCTSID_no;

	@Expose
	private String Name;

	@Expose
	private String Husband_Name;

	@Expose
	private String Whom_PhoneNo;

	@Expose
	private Date Birth_Date;

	@Expose
	private Integer Age;

	@Expose
	private String Caste;

	@Expose
	private Long State_ID;

	@Expose
	private String State_Name;

	@Expose
	private Long District_ID;

	@Expose
	private String District_Name;

	@Expose
	private String Taluka_Name;

	@Expose
	private Long Taluka_ID;

	@Expose
	private Long Block_ID;

	@Expose
	private String Block_Name;

	@Expose
	private Long SubCenter_ID;

	@Expose
	private String SubCenter_Name;

	@Expose
	private Long Village_ID;

	@Expose
	private String Village_Name;

	@Expose
	private String ModifiedBy;

	@Expose
	private Date LastModDate;
	
	@Expose
	private Date LMP_Date;
	
}
