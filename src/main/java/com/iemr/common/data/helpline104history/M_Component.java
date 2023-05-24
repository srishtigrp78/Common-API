package com.iemr.common.data.helpline104history;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;


@Entity
@Table(name="M_Component")
public class M_Component {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer componentID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "componentID")
	private T_BloodRequest t_bloodRequest;
	
	private String component;
	private String componentDesc;
	private Boolean deleted;
	private String createdBy;
	private String modifiedBy;
	
	public M_Component(Integer componentID, String component, String componentDesc) {
		super();
		this.componentID = componentID;
		this.component = component;
		this.componentDesc = componentDesc;
	}

	public M_Component() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getComponentID() {
		return componentID;
	}

	public void setComponentID(Integer componentID) {
		this.componentID = componentID;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getComponentDesc() {
		return componentDesc;
	}

	public void setComponentDesc(String componentDesc) {
		this.componentDesc = componentDesc;
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
	
	public String toString() {
		return new Gson().toJson(this);
	}


}
