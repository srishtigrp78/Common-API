package com.iemr.common.data.uptsu;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_104appointmentdetails")
public class T_104AppointmentDetails {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "Id", insertable = false)
	private Integer id;
	
	@Expose
	@Column(name = "BlockName")
	private String blockName;
	
	@Expose
	@Column(name = "FacilityName")
	private String facilityName;
	
	@Expose
	@Column(name = "FacilityCode")
	private String facilityCode;
	
	@Expose
	@Column(name = "Employee_Code")
	private String employeeCode;
	
	@Expose
	@Column(name = "ChoName")
	private String choName;
	
	@Expose
	@Column(name = "HFRID")
	private String hfrId;
	
	@Expose
	@Column(name = "FacilityPhoneNo")
	private String facilityPhoneNo;
	
	@Expose
	@Column(name = "AppointmentDate")
	private Timestamp appointmentDate;
	
	@Expose
	@Column(name = "BenRegId")
	private Long benRegId;
	
	@Expose
	@Column(name = "BenCallID")
	private Long benCallId;
	
	@Expose
	@Column(name = "AlternateMobileNo")
	private String alternateMobNo;
	
	@Expose
	@Column(name = "RefferedFlag")
	private Boolean refferedFlag;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name = "Processed", insertable = false)
	private String processed;
	
	@Expose
	@Column(name = "CreatedBy", updatable = false)
	private String createdBy;
	
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@Expose
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	private String modifiedBy;
	
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	

}
