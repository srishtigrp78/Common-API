package com.iemr.common.dto.identity;

import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;

import lombok.Data;

public @Data class Address {
	private String addrLine1;
	private String addrLine2;
	private String addrLine3;
	private Integer countryId;
	private String country;
	private Integer stateId;
	private String state;
	private Integer districtId;
	private String district;
	private Integer subDistrictId;
	private String subDistrict;
	private Integer villageId;
	private String village;
	private String habitation;
	private String addressValue;
	private String pinCode;

	/*
	 * New columns added for MMU integration 09-04-2018
	 */
	private Integer zoneID;
	private String zoneName;
	private Integer parkingPlaceID;
	private String parkingPlaceName;
	private Integer servicePointID;
	private String servicePointName;

	public static Address bendemographicsAddressMapper(BeneficiaryDemographicsModel i_bendemographics) {
		Address address = new Address();
		if (i_bendemographics == null) {
			return null;
		}
		address.setAddrLine1(i_bendemographics.getAddressLine1());
		address.setAddrLine2(i_bendemographics.getAddressLine2());
		address.setAddrLine3(i_bendemographics.getAddressLine3());
		address.setCountryId(i_bendemographics.getCountryID());
		if (i_bendemographics.getM_state() != null) {

			address.setState(i_bendemographics.getM_state().getStateName());
		}
		if (i_bendemographics.getM_country() != null) {
			address.setCountry(i_bendemographics.getM_country().getCountryName());
		}
		if (i_bendemographics.getM_district() != null) {

			address.setDistrict(i_bendemographics.getM_district().getDistrictName());
		}
		if (i_bendemographics.getM_districtbranchmapping() != null) {

			address.setVillage(i_bendemographics.getM_districtbranchmapping().getVillageName());
		}
		if (i_bendemographics.getM_districtblock() != null) {

			address.setVillage(i_bendemographics.getM_districtblock().getBlockName());
		}

		address.setStateId(i_bendemographics.getStateID());
		address.setDistrictId(i_bendemographics.getDistrictID());
		address.setSubDistrictId(i_bendemographics.getBlockID());
		address.setVillageId(i_bendemographics.getDistrictBranchID());
		address.setPinCode(i_bendemographics.getPinCode());

		return address;
	}
}
