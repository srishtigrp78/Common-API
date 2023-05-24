package com.iemr.common.data.category;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_Category")
@Data
public class CategoryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "CategoryID")
	private Integer categoryID;

	@Expose
	@Column(name = "CategoryName")
	private String categoryName;
	@Expose
	@Column(name = "CategoryDesc")
	private String categoryDesc;
	@Expose
	@Column(name = "SubServiceID")
	private Integer subServiceID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "FeedbackNatureID")
	private Integer feedbackNatureID;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
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
	@Column(name = "104_CS_Type", insertable = false, updatable = false)
	@Expose
	private Boolean isWellBeing;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryDetails")
	@Transient
	@JsonIgnore
	private Set<SubCategoryDetails> subCategories;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Integer getCategoryID() {
		return categoryID;
	}

	public Integer getSubServiceID() {
		return subServiceID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}
	
	public Integer getFeedbackNatureID() {
		return feedbackNatureID;
	}

	public CategoryDetails() {
	}

	public CategoryDetails(Integer CategoryID, String CategoryName) {
		this.categoryID = CategoryID;
		this.categoryName = CategoryName;
	}

	public CategoryDetails(Integer CategoryID, String CategoryName, Boolean isWellBeing) {
		this.categoryID = CategoryID;
		this.categoryName = CategoryName;
		this.isWellBeing = isWellBeing;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public Boolean getIsWellBeing() {

		return isWellBeing;
	}
}
