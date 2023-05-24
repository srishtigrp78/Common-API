package com.iemr.common.data.userbeneficiarydata;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_maritalstatus")
@Data
public class MaritalStatus
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaritalStatusID")
	@Expose
	private Integer maritalStatusID;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_maritalstatus")
	@Expose
	@Transient
	private Set<Beneficiary> i_beneficiary;

	@OneToMany()
	// @Expose
	@JoinColumn(insertable = false, updatable = false, name = "MaritalStatusID",
			referencedColumnName = "MaritalStatusID")
	@Transient
	private Set<User> m_user;

	@Column(name = "Status")
	@Expose
	private String status;
	@Column(name = "StatusDesc")
	@Expose
	private String statusDesc;
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

	// public MaritalStatus()
	// {
	// }

	public MaritalStatus getMaritalStatus(int MaritalStatusID, String Status)
	{
		this.maritalStatusID = MaritalStatusID;
		this.status = Status;
		return this;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
