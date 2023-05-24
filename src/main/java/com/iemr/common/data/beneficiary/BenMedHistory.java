package com.iemr.common.data.beneficiary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "T_BenMedHistory")
@Data
public class BenMedHistory
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BenMedHistoryID")
	@Expose
	private Long benMedHistoryID;

	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;

	@Transient
	@JsonIgnore
	private Beneficiary i_beneficiary;

	@Column(name = "YearofIllness")
	@Expose
	private Timestamp yearofIllness;
	@Column(name = "IllnessTypeID")
	@Expose
	private Integer illnessTypeID;
	@Column(name = "IllnessType")
	@Expose
	private String illnessType;
	@Column(name = "SurgeryID")
	@Expose
	private Integer surgeryID;
	@Column(name = "YearofSurgery")
	@Expose
	private Timestamp yearofSurgery;
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

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
