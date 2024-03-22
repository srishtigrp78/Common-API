package com.iemr.common.data.customization;

import java.sql.Timestamp;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "m_registrationsections")
@Data
public class SectionMasterCustomization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SectionID")
	@Expose
	private Integer sectionId;
	
	@Column(name = "SectionName")
	@Expose
	private String sectionName;
	
	@Column(name = "Deleted")
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


}
