package com.iemr.common.model.userbeneficiary;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.iemr.common.dto.identity.BenIdentityDTO;

import lombok.Data;

@Data
public class BeneficiaryIdentityModel
{
	@Expose
	private GovtIdentityTypeModel govtIdentityType;
	@Expose
	private String govtIdentityNo;
	@Expose
	private Integer govtIdentityTypeID;
	@Expose
	private BigInteger benIdentityId;
	@Expose
	private String createdBy;
	@Expose
	private Boolean deleted;

	public static List<BeneficiaryIdentityModel> createBeneficiaryIdentities(List<BenIdentityDTO> benIdentityDTOList)
	{
		List<BeneficiaryIdentityModel> beneficiaryIdentities = null;
		if (benIdentityDTOList != null)
		{
			beneficiaryIdentities = new ArrayList<BeneficiaryIdentityModel>();
			for (BenIdentityDTO benIdentityDTO : benIdentityDTOList)
			{
				BeneficiaryIdentityModel beneficiary = new BeneficiaryIdentityModel();
				beneficiary.setGovtIdentityNo(benIdentityDTO.getIdentityNo());
				beneficiary.setGovtIdentityTypeID(benIdentityDTO.getIdentityTypeId());
				beneficiary.setBenIdentityId(benIdentityDTO.getBenIdentityId());
				beneficiary.setCreatedBy(benIdentityDTO.getCreatedBy());
				beneficiary.setDeleted(benIdentityDTO.getDeleted());
				beneficiary.setGovtIdentityType(GovtIdentityTypeModel.createGovtIdentity(benIdentityDTO));
				beneficiaryIdentities.add(beneficiary);
			}
		}
		return beneficiaryIdentities;
	}
}
