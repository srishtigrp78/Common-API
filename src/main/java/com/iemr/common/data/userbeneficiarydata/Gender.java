package com.iemr.common.data.userbeneficiarydata;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_gender")
public class Gender
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "GenderID")
	private Integer genderID;

	@Transient
	private Set<Beneficiary> i_beneficiary;

	@OneToMany()
	@JoinColumn(name = "GenderID", referencedColumnName = "GenderID", insertable = false, updatable = false)
	@JsonIgnore
	@Transient
	private Set<User> m_user;

	@Expose
	@Column(name = "GenderName")
	private String genderName;
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

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Gender getDefaultConstructor()
	{
		return this;
	}

	public Gender getGender(Integer GenderID, String GenderName)
	{
		this.genderID = GenderID;
		this.genderName = GenderName;
		return this;
	}

	/**
	 * @return the genderID
	 */
	// public Integer getGenderID()
	// {
	// return genderID;
	// }

	/**
	 * @return the i_beneficiary
	 */
	// public Set<Beneficiary> getI_beneficiary()
	// {
	// return i_beneficiary;
	// }

	/**
	 * @return the m_user
	 */
	// public Set<User> getM_user()
	// {
	// return m_user;
	// }

	/**
	 * @return the genderName
	 */
	// public String getGenderName()
	// {
	// return genderName;
	// }

	/**
	 * @return the deleted
	 */
	// public Boolean getDeleted()
	// {
	// return deleted;
	// }

	/**
	 * @return the createdBy
	 */
	// public String getCreatedBy()
	// {
	// return createdBy;
	// }

	/**
	 * @return the createdDate
	 */
	// public Timestamp getCreatedDate()
	// {
	// return createdDate;
	// }

	/**
	 * @return the modifiedBy
	 */
	// public String getModifiedBy()
	// {
	// return modifiedBy;
	// }

	/**
	 * @return the lastModDate
	 */
	// public Timestamp getLastModDate()
	// {
	// return lastModDate;
	// }

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}