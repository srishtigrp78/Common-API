package com.iemr.common.data.beneficiary;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_beneficiaryincomestatus")
@Data
public class BeneficiaryIncomeStatus
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IncomeStatusID")
	@Expose
	private Integer incomeStatusID;

	@Transient
	private Set<BenDemographics> i_bendemographics;

	@Column(name = "IncomeStatus")
	@Expose
	private String incomeStatus;
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

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public BeneficiaryIncomeStatus()
	{
	}

	public BeneficiaryIncomeStatus(Integer IncomeStatusID, String IncomeStatus)
	{
		this.incomeStatusID = IncomeStatusID;
		this.incomeStatus = IncomeStatus;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
