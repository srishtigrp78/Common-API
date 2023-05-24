package com.iemr.common.data.email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Data
@Table(name="v_emailstockalert")
public class StockAlertData {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uuid")
	private String uuid;	

	@Column(name = "FacilityId")
	private Integer facilityId;
	
	@Column(name = "ItemID")
	private Integer itemID;
	
	@Column(name = "FacilityName")
	@Expose
	private String facilityName;
	
	@Column(name = "ItemName")
	@Expose
	private String itemName;
	
	@Column(name = "Totalquantity")
	@Expose
	private Integer Totalquantity;
	
	@Column(name = "Quantityinhand")
	private Integer quantityInHand;
	
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	
	@Column(name = "Emailid")
	@Expose
	private String emailid;
	
	@Column(name = "DistrictName")
	@Expose
	private String districtName;
	
	@Column(name = "QuantityinhandPercent")
	@Expose
	private Double quantityinhandPercent;
}
