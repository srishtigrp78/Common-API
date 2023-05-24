package com.iemr.common.data.userbeneficiarydata;

import java.sql.Timestamp;
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

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.notification.Notification;
import com.iemr.common.data.users.UserLangMapping;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "M_Language")
@Data
public class Language
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LanguageID")
	@Expose
	private Integer languageID;

	@Transient
	private Set<BenDemographics> i_bendemographics;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_language")
	@Transient
	private Set<UserLangMapping> m_UserLangMappings;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	@Transient
	private Set<Notification> notifications;

	@Column(name = "LanguageName")
	@Expose
	private String languageName;
	@Column(name = "LanguageDesc")
	@Expose
	private String languageDesc;
	@Column(name = "PropertyFilePath")
	@Expose
	private String propertyFilePath;
	@Column(name = "IVRFilePath")
	@Expose
	private String ivrFilePath;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
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

	public Language()
	{
	}

	public Language(int languageId, String languageName, String languageDesc, String propertyFilePath,
			String IVRFilePath)
	{
		this.languageID = Integer.valueOf(languageId);
		this.languageName = languageName;
		this.languageDesc = languageDesc;
		this.propertyFilePath = propertyFilePath;
		this.ivrFilePath = IVRFilePath;
	}

	public Language(int languageId, String languageName)
	{
		this.languageID = Integer.valueOf(languageId);
		this.languageName = languageName;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
