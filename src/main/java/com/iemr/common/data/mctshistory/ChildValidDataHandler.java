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
@Table(name="t_childvaliddata")
public class ChildValidDataHandler implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long RowID;
	
	@Expose
	@Column(name = "BeneficiaryRegID", insertable = true, updatable = false)
	private Long BeneficiaryRegID;
	
	@Expose
	private Long MCTSID_no_Child_ID;
	 
	@Expose
	private String Child_Name;
	 
	@Expose
	private String Father_Name;
	 
	@Expose
	private String Mother_Name;
	 
	@Expose
	private Long Mother_ID;
	 
	@Expose
	private Date DOB;
	 
	@Expose
	private String Gender;
	 
	@Expose
	private String Caste;
	 
	@Expose
	private String Phone_No;
	 
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
	private Long Village_ID;
	 
	@Expose
	private String Village_Name;
	 
	@Expose
	private String GP_Village;
	 
	@Expose
	private String Address;
	 
	@Expose
	private String Created_By;
	 
	@Expose
	private String Updated_By;
	 
	@Expose
	@Column(name = "CreatedBy", insertable = true, updatable = false)
	private String CreatedBy;
	 
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date CreatedDate;
	 
	@Expose
	private String ModifiedBy;
	 
	@Expose
	private Date LastModDate;
	
}