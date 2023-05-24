package com.iemr.common.dto.identity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.iemr.common.model.userbeneficiary.BeneficiaryIdentityModel;

import lombok.Data;

@Data
public class Identity
{
	private String identityNo;
	private String identityName;
	private Integer identityNameId;
	private String identityType;
	private Integer identityTypeId;
	private Timestamp issueDate;
	private Timestamp expiryDate;
	private Boolean isVerified;
	private String identityFilePath;
	private String createdBy;
	private BigInteger benIdentityId;
	private Boolean deleted;

	// public static List<Identity> createIdentity(String govtIdentityNo, Integer govtIdentityTypeID)
	public static List<Identity> createIdentity(String govtIdentityNo, Integer govtIdentityTypeID, String createdBy)
	{
		List<Identity> identityList = new ArrayList<>();
		if (govtIdentityNo != null && govtIdentityTypeID != null)
		{
			identityList.add(doIdentity(govtIdentityNo, govtIdentityTypeID, createdBy));
		}
		return identityList;

	}

	private static Identity doIdentity(String govtIdentityNo, Integer govtIdentityTypeID, String createdBy)
	{
		Identity identity = new Identity();
		identity.identityNo = govtIdentityNo;
		identity.identityNameId = govtIdentityTypeID;
		identity.createdBy = createdBy;
		return identity;
	}

	private static Identity doIdentity(String govtIdentityNo, Integer govtIdentityTypeID, String createdBy,
			Boolean deleted, BigInteger benIdentityId)
	{
		Identity identity = new Identity();
		identity.identityNo = govtIdentityNo;
		identity.identityNameId = govtIdentityTypeID;
		identity.createdBy = createdBy;
		identity.deleted = deleted;
		identity.benIdentityId = benIdentityId;
		return identity;
	}

	public static List<Identity> createIdentity(List<BeneficiaryIdentityModel> identities, String createdBy)
	{
		List<Identity> identityList = new ArrayList<Identity>();
		if (identities != null)
		{
			for (BeneficiaryIdentityModel identity : identities)
			{
				if (identity.getBenIdentityId() != null)
				{
					identityList.add(doIdentity(identity.getGovtIdentityNo(), identity.getGovtIdentityTypeID(),
							createdBy, identity.getDeleted(), identity.getBenIdentityId()));
				} else
				{
					identityList
							.add(doIdentity(identity.getGovtIdentityNo(), identity.getGovtIdentityTypeID(), createdBy));
				}
			}
		}
		return identityList;

	}
}
