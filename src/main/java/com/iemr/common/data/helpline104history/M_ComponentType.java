package com.iemr.common.data.helpline104history;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="M_ComponentType")
public class M_ComponentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer componentTypeID;
	
	private String componentType;
	private String componentTypeDesc;
	private Boolean deleted;
	private String createdBy;
	private String modifiedBy;
	
	public M_ComponentType(Integer componentTypeID, String componentType, String componentTypeDesc) {
		super();
		this.componentTypeID = componentTypeID;
		this.componentType = componentType;
		this.componentTypeDesc = componentTypeDesc;
	}

	public M_ComponentType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getComponentTypeID() {
		return componentTypeID;
	}

	public void setComponentTypeID(Integer componentTypeID) {
		this.componentTypeID = componentTypeID;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentTypeDesc() {
		return componentTypeDesc;
	}

	public void setComponentTypeDesc(String componentTypeDesc) {
		this.componentTypeDesc = componentTypeDesc;
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

}
