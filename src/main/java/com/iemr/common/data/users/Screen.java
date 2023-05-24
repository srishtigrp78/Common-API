package com.iemr.common.data.users;

import java.sql.Timestamp;
import java.util.List;

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

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_screen")
@Data
public class Screen
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "ScreenID")
	private Integer screenID;
	@OneToMany(mappedBy = "screen")
	@Transient
	private List<ServiceRoleScreenMapping> serviceRoleScreenMappings;

	@Expose
	@Column(name = "ScreenName")
	private String screenName;
	@Expose
	@Column(name = "ApiUsed")
	private String apiUsed;
	@Expose
	@Column(name = "WorkflowName")
	private String workflowName;
	@Expose
	@Column(name = "ScreenDesc")
	private String screenDesc;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProviderServiceMapID", insertable = false, updatable = false)
	private ProviderServiceMapping providerServiceMapping;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

//	public Screen()
//	{
//	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public Integer getScreenID()
	{
		return screenID;
	}

	public List<ServiceRoleScreenMapping> getServiceRoleScreenMappings()
	{
		return serviceRoleScreenMappings;
	}

	public String getScreenName()
	{
		return screenName;
	}

	public String getApiUsed()
	{
		return apiUsed;
	}

	public String getWorkflowName()
	{
		return workflowName;
	}

	public String getScreenDesc()
	{
		return screenDesc;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	public ProviderServiceMapping getProviderServiceMapping()
	{
		return providerServiceMapping;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}
}
