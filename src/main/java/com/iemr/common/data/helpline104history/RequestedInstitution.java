package com.iemr.common.data.helpline104history;

import java.sql.Date;

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
import com.iemr.common.data.institute.Institute;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Data
@Table(name="t_requestedinstitution")
public class RequestedInstitution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RequestedInstitutionID")
	@Expose
	private Long requestedInstitutionID;	
	
	@Column(name = "OrganDonationID")
	private Long organDonationID;	
	@Expose
	@Column(name = "InstitutionID")
	private Integer institutionID;
	
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "institutionID")	
	private Institute institute;

	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted;
	
	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable=false, updatable=false)
	private Date lastModDate;
	
	public RequestedInstitution()
	{
		super();		
	}	
	
	public void setOrganDonationID(Long organDonationID)
	{
		this.organDonationID = organDonationID;
	}
	
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	
	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}		
	

}
