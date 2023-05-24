package com.iemr.common.data.users;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_servicepoint")
public class MasterServicePoint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "ServicePointID")
	private Integer servicePointID;
	@Expose
	@Column(name = "ServicePointName")
	private String servicePointName;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	@OneToMany(mappedBy = "masterServicePoint", cascade = CascadeType.ALL)
	public Set<VanServicepointMapping> vanServicepointMapping;

	public MasterServicePoint() {
	}

	public MasterServicePoint(Integer servicePointID, String servicePointName, Integer providerServiceMapID,
			Integer parkingPlaceID, Boolean deleted, Set<VanServicepointMapping> vanServicepointMapping) {
		super();
		this.servicePointID = servicePointID;
		this.servicePointName = servicePointName;
		this.providerServiceMapID = providerServiceMapID;
		this.parkingPlaceID = parkingPlaceID;
		this.deleted = deleted;
		this.vanServicepointMapping = vanServicepointMapping;
	}

	public Integer getServicePointID() {
		return servicePointID;
	}

	public void setServicePointID(Integer servicePointID) {
		this.servicePointID = servicePointID;
	}

	public String getServicePointName() {
		return servicePointName;
	}

	public void setServicePointName(String servicePointName) {
		this.servicePointName = servicePointName;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Set<VanServicepointMapping> getVanServicepointMapping() {
		return vanServicepointMapping;
	}

	public void setVanServicepointMapping(Set<VanServicepointMapping> vanServicepointMapping) {
		this.vanServicepointMapping = vanServicepointMapping;
	}

}
