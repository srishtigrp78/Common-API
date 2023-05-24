
package com.iemr.common.data.registration;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;


import lombok.Data;

@Entity
@Table(name = "t_everwellapi")
@Data
public class everwellBeneficicaryRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "EAPIID")
	private Long EAPIID;
	@Expose
	@Column(name = "EverWellID")
	private Long Id;
//	@Expose
//	@Column(name = "BeneficiaryID")
//	private Integer BeneficiaryID;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long BeneficiaryRegID;
	@Expose
	@Column(name = "Callid")
	private Long Callid;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer ProviderServiceMapID;

	@Expose
	@Column(name = "firstName")
	private String FirstName;
	@Expose
	@Column(name = "lastName")
	private String LastName;
	@Transient
	@Expose
	private String Gender;	
	@Expose
	@Column(name = "primaryNumber")
	private String PrimaryNumber;
	@Expose
	@Column(name = "missedDoses")
	private Integer MissedDoses;
	@Expose
	@Column(name = "facilityName")
	private String FacilityName;
	@Expose
	@Column(name = "state")
	private String State;
	@Transient
	@Expose
	private String District;
	@Expose
	@Column(name = "adherencePercentage")
	private Integer AdherencePercentage;
	@Expose
	@Column(name = "isRegistered")
	private Boolean isRegistered = false;
	@Expose
	@Column(name = "AgentID")
	private Integer AgentID;
	@Expose
	@Column(name = "isAllocated")
	private Boolean isAllocated;
	@Expose
	@Column(name = "ActionTaken")
	private String ActionTaken;
	@Expose
	@Column(name = "Category")
	private String Category;
	@Expose
	@Column(name = "SubCategory")
	private String SubCategory;
	@Expose
	@Column(name = "DateOfAction", insertable = false, updatable = false)
	private String DateOfAction;
	@Expose
	@Column(name = "Comments")
	private String Comments;
	@Expose
	@Column(name = "statusUpdatedEverwell")
	private Boolean statusUpdatedEverwell;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted = false;
	@Expose
	@Column(name = "Processed")
	private Character Processed = 'A'; 
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	@Expose
	@Column(name = "VanSerialNo")
	private Integer VanSerialNo;
	@Expose
	@Column(name = "VanID")
	private Integer VanID;
	@Expose
	@Column(name = "VehicalNo")
	private String VehicalNo;
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer ParkingPlaceID;
	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;

	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;
	
	public everwellBeneficicaryRegistration getOutboundCall(Long BeneficiaryRegID,
            Integer ProviderServiceMapID, Long ID, String firstName, String lastName,
            String primaryNumber,Timestamp LastModDate)
    {
        this.BeneficiaryRegID = BeneficiaryRegID;
        //this.BeneficiaryID = BeneficiaryID;
        this.ProviderServiceMapID = ProviderServiceMapID;
        this.Id = ID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.PrimaryNumber = primaryNumber;
        this.lastModDate = LastModDate;
        return this;



    }

}