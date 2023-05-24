package com.iemr.common.data.helpline104history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;


@Entity
@Table(name="M_DonatableOrgan")
public class M_DonatableOrgan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Integer donatableOrganID;
	@Expose
	private String donatableOrgan;
	@Expose
	private String donatableOrganDesc;
	@Expose
	private Boolean deleted;
	@Expose
	private String createdBy;
	@Expose
	private String modifiedBy;
	
	public M_DonatableOrgan(Integer donatableOrganID, String donatableOrgan, String donatableOrganDesc) {
		super();
		this.donatableOrganID = donatableOrganID;
		this.donatableOrgan = donatableOrgan;
		this.donatableOrganDesc = donatableOrganDesc;
	}

	public M_DonatableOrgan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDonatableOrgan() {
		return donatableOrgan;
	}

	public void setDonatableOrgan(String donatableOrgan) {
		this.donatableOrgan = donatableOrgan;
	}

	public String getDonatableOrganDesc() {
		return donatableOrganDesc;
	}

	public void setDonatableOrganDesc(String donatableOrganDesc) {
		this.donatableOrganDesc = donatableOrganDesc;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Integer getDonatableOrganID() {
		return donatableOrganID;
	}
	
	/*
	public String toString() {
		return new Gson().toJson(this);
	} */
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
