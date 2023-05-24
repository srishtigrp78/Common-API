package com.iemr.common.data.helpline104history;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import lombok.Data;


@Entity
@Data
@Table(name="m_104drugmapping")
public class M_104drugmapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "DrugMapID")
	private Integer drugMapID;
	
	@Expose
	@Column(name = "DrugId")
	private Integer drugId;
	
	@Expose
	@Column(name = "DrugName")
	private String drugName;
	
	@Expose
	@Column(name = "DrugGroupID")
	private Integer drugGroupID;
	
	@Expose
	@Column(name = "DrugGroupName")
	private String drugGroupName;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
