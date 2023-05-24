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
import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.directory.SubDirectory;
import com.iemr.common.data.institute.Institute;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Data
@Table(name = "t_directoryservice")
public class Directoryservice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "DirectoryServiceID")
	private Long directoryServiceID;	
	@Expose
	@Column(name = "RequestID")
	private String requestID;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;	
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	/*@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "benCallID")
	private BenCall benCall; */
	@Expose
	@Column(name = "InstitutionID")	
	private Integer institutionID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "institutionID", insertable = false, updatable = false)		
	private Institute institute;
	@Expose
	@Column(name = "InstituteDirectoryID")	
	private Integer instituteDirectoryID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "instituteDirectoryID", insertable = false, updatable = false)		
	private Directory instituteDirectory;
	@Expose
	@Column(name = "InstituteSubDirectoryID")	
	private Integer instituteSubDirectoryID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "instituteSubDirectoryID", insertable = false, updatable = false)		
	private SubDirectory instituteSubDirectory;
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;	
	@Expose
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	@Expose
	@Column(name = "Processed",insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable=false, updatable=false)
	private Date lastModDate;
	
	public Directoryservice() {
		super();
		
	}
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
