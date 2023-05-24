package com.iemr.common.data.helpline104history;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.location.Districts;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;


@Entity
@Data
@Table(name="T_BloodRequest")
public class T_BloodRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long bloodReqID;
	@Expose
	private String requestID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	@Expose
	private Long beneficiaryRegID;
	@Expose
	private Long recipientBeneficiaryID;
	@Expose
	private String recipientName;
	@Expose
	private Integer recipientAge;
	@Expose
	private Short recipientGenderID;
	@Expose
	private String typeOfRequest;
	@Expose
	private Integer bloodGroupID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "bloodGroupID")
	private M_BloodGroup m_bloodGroup;
	@Expose
	private Integer componentTypeID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "componentTypeID")
	private M_ComponentType m_componentType;

	@Expose
	private String unitRequired;
	@Expose
	private String hospitalAdmitted;
	@Expose
	private Integer districtID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "districtID")
	private Districts m_district;
	@Expose
	private Boolean outboundNeeded;
	@Expose
	private Timestamp outboundDate;
	@Expose
	private String bloodBankAddress;
	@Expose
	private String bbPersonName;
	@Expose
	private String bbPersonDesignation;
	@Expose
	private String bbMobileNo;
	@Expose
	private String remarks;
	@Expose
	private String feedback;
	
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
