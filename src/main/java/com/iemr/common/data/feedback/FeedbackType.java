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
@Table(name = "m_feedbacktype")
@Data
public class FeedbackType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackTypeID")
	@Expose
	private Integer feedbackTypeID;
	@Transient
	@OneToMany(mappedBy = "feedbackType", fetch = FetchType.LAZY)
	private Set<FeedbackDetails> feedbacks;
	@Column(name = "FeedbackTypeName")
	@Expose
	private String feedbackTypeName;
	@Column(name = "FeedbackDesc")
	@Expose
	private String feedbackDesc;
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

	public FeedbackType()
	{

	}

	public FeedbackType(Integer feedbackTypeID, String feedbackTypeName)
	{
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackTypeName = feedbackTypeName;
	}

	public String getFeedbackTypeName()
	{
		return feedbackTypeName;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}
}
