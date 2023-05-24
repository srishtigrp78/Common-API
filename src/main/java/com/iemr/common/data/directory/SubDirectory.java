package com.iemr.common.data.directory;

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
@Table(name = "m_institutesubdirectory")
@Data
public class SubDirectory
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstituteSubDirectoryID")
	@Expose
	private Integer instituteSubDirectoryID;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subDirectory")
	@JsonIgnore
	@Expose
	@Transient
	private List<InstituteDirectoryMapping> instituteDirectoryMappings;
	// m_instituteroutedirectory
	@Column(name = "InstituteDirectoryID")
	@Expose
	private Integer instituteDirectoryID;
	// m_institutedirectory
	// m_institutesubdirectory
	@Column(name = "InstituteSubDirectoryName")
	@Expose
	private String instituteSubDirectoryName;
	@Column(name = "InstituteSubDirectoryDesc")
	@Expose
	private String instituteSubDirectoryDesc;
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

	public Integer getInstituteSubDirectoryID()
	{
		return instituteSubDirectoryID;
	}

	public Integer getInstituteDirectoryID()
	{
		return instituteDirectoryID;
	}

	public String getInstituteSubDirectoryName()
	{
		return instituteSubDirectoryName;
	}

	public String getInstituteSubDirectoryDesc()
	{
		return instituteSubDirectoryDesc;
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

	protected SubDirectory()
	{
	}

	public SubDirectory(Integer institutionSubDirectoryID, Integer institutionDirectoryID,
			String instituteSubDirectoryName)
	{
		this.instituteSubDirectoryID = institutionSubDirectoryID;
		this.instituteDirectoryID = institutionDirectoryID;
		this.instituteSubDirectoryName = instituteSubDirectoryName;
	}

	public SubDirectory(Integer institutionSubDirectoryID, String instituteSubDirectoryName)
	{
		this.instituteSubDirectoryID = institutionSubDirectoryID;
		this.instituteSubDirectoryName = instituteSubDirectoryName;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
