package com.iemr.common.data.feedback;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_severity")
@Data
public class FeedbackSeverity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SeverityID")
	@Expose
	private Integer severityID;
	// t_feedback
	@Transient
	@OneToMany(mappedBy = "severity", fetch = FetchType.LAZY)
	private Set<FeedbackDetails> feedbacks;

	@Column(name = "SeverityTypeName")
	@Expose
	private String severityTypeName;
	@Column(name = "SeverityDesc")
	@Expose
	private String severityDesc;
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
	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProviderServiceMapID", updatable = false, insertable = false)
	@JsonIgnore
	@Expose
	private ProviderServiceMapping providerServiceMapping;

	public FeedbackSeverity()
	{

	}

	public FeedbackSeverity(Integer severityID, String severityTypeName)
	{
		this.severityID = severityID;
		this.severityTypeName = severityTypeName;
	}

	public String getSeverityTypeName()
	{
		return severityTypeName;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
