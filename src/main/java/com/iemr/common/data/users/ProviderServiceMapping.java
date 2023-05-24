package com.iemr.common.data.users;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.callhandling.PhoneBlock;
import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.feedback.FeedbackSeverity;
import com.iemr.common.data.feedback.FeedbackType;
import com.iemr.common.data.notification.EmergencyContacts;
import com.iemr.common.data.notification.Notification;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_providerservicemapping")
public class ProviderServiceMapping
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@OneToMany(mappedBy = "m_ProviderServiceMapping")
	@Transient
	@Expose
	private List<UserServiceRoleMapping> m_UserServiceRoleMappings;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<Notification> notifications;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<ServiceRoleScreenMapping> serviceRoleScreenMapping;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<Screen> screens;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<Directory> directories;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<FeedbackType> feedbacks;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<FeedbackSeverity> feedbackSeverities;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<EmergencyContacts> emergencyContacts;
	@OneToMany(mappedBy = "providerServiceMapping")
	@Transient
	@Expose
	private List<PhoneBlock> blockNumbers;

	@Expose
	@Column(name = "ServiceProviderID")
	private Short serviceProviderID;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ServiceProviderID", updatable = false, insertable = false)
	// @Transient
	@Expose
	private ServiceProvider serviceProvider;

	@Expose
	@Column(name = "ServiceID")
	private Short serviceID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ServiceID", updatable = false, insertable = false)
	// @Transient
	@Expose
	private ServiceMaster m_ServiceMaster;

	@Expose
	@Column(name = "CountryID")
	private Integer countryID;
	@Expose
	@Column(name = "StateID")
	private Integer stateID;
	@Expose
	@Column(name = "DistrictID")
	private Integer districtID;
	@Expose
	@Column(name = "CityID")
	private Integer cityID;
	@Expose
	@Column(name = "DistrictBlockID")
	private Integer districtBlockID;
	@Expose
	@Column(name = "Address")
	private String address;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Expose
	@Column(name = "CTI_CampaignName")
	private String ctiCampaignName;

	@Expose
	@Column(name = "StatusID")
	private Integer statusID;

	@Expose
	@Column(name = "APIMANClientID")
	private String aPIMANClientID;
	
	@Expose
	@Column(name = "APIMANClientKey")
	private String aPIMANClientKey;
	
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StatusID", insertable = false, updatable = false)
	private Status status;

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	// public ServiceMaster getM_ServiceMaster()
	// {
	// return m_ServiceMaster;
	// }

	public String getCtiCampaignName()
	{
		return ctiCampaignName;
	}

	public Integer getStateID()
	{
		return stateID;
	}

	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	@Expose
	@Column(name = "IsDialPreferenceManual")
	private Boolean isDialPreferenceManual;

	@Expose
	@Column(name = "PreviewWindowTime")
	private Integer previewWindowTime;

	public ProviderServiceMapping(Boolean isDialPreferenceManual, Integer previewWindowTime)
	{
		this.isDialPreferenceManual = isDialPreferenceManual;
		this.previewWindowTime = previewWindowTime;
	}

	public ProviderServiceMapping()
	{
	}

}
