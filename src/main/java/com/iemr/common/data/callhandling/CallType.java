package com.iemr.common.data.callhandling;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_calltype")
@Data
public class CallType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "CallTypeID")
	private Integer callTypeID;
	@OneToMany(mappedBy = "callTypeObj", fetch = FetchType.LAZY)
	@JsonIgnore
	@Transient
	private List<BeneficiaryCall> beneficiaryCalls;
	@Expose
	@Column(name = "CallGroupType")
	private String callGroupType;
	@Expose
	@Column(name = "CallType")
	private String callType;
	@Expose
	@Column(name = "CallTypeDesc")
	private String callTypeDesc;
	// @Expose
	// @Column(name = "MctsType")
	// private Integer mctsType;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "IsInbound")
	private Boolean isInbound;
	@Expose
	@Column(name = "IsOutbound")
	private Boolean isOutbound;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	@Column(name = "FitToBlock")
	@Expose
	private Boolean fitToBlock = false;
	@Column(name = "FitForFollowup")
	@Expose
	private Boolean fitForFollowUp = true;
	
	@Column (name="MaxRedial")
	@Expose
	private Integer maxRedial;

	public CallType createCallTypes(Integer callTypeID, String callType, String callTypeDesc, String callGroupType,
			Boolean fitToBlock, Boolean fitForFollowUp, Boolean isInbound, Boolean isOutbound)
	{
		this.callType = callType;
		this.callGroupType = callGroupType;
		this.callTypeID = callTypeID;
		this.callTypeDesc = callTypeDesc;
		this.fitToBlock = fitToBlock;
		this.fitForFollowUp = fitForFollowUp;
		this.isInbound = isInbound;
		this.isOutbound = isOutbound;
		return this;
	}

	// public CallType()
	// {
	// }

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public String getCallGroupType()
	{
		return callGroupType;
	}

	public String getCallType()
	{
		return callType;
	}
}
