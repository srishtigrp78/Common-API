package com.iemr.common.data.users;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_UserLangMapping")
public class UserLangMapping
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "UserLangID")
	private Integer userLangID;

	@Expose
	@Column(name = "UserID")
	private Integer userID;
	@ManyToOne(/* fetch = FetchType.LAZY */)
	@JoinColumn(updatable = false, insertable = false, name = "UserID", referencedColumnName = "UserID")
	@JsonIgnore
	// @Expose
	@Transient
	private User m_user;

	@Expose
	@Column(name = "LanguageID")
	private Integer languageID;
	@ManyToOne(/* fetch = FetchType.EAGER */)
	@JoinColumn(updatable = false, insertable = false, name = "LanguageID", referencedColumnName = "LanguageID")
	@JsonIgnore
	@Expose
	private Language m_language;

	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	@Column(name = "CanRead")
	@Expose
	private Boolean canRead;
	@Column(name = "CanWrite")
	@Expose
	private Boolean canWrite;
	@Column(name = "CanSpeak")
	@Expose
	private Boolean canSpeak;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	// protected UserLangMapping() {
	// }

	public UserLangMapping createUserLangMapping(Integer userLangID, Long USRMappingID, Integer languageID,
			String languageName)
	{
		this.userLangID = userLangID;
		this.languageID = languageID;
		this.m_language = new Language(languageID, languageName);
		return this;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
