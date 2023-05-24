package com.iemr.common.service.beneficiary;

import java.util.HashSet;
import java.util.List;

import com.iemr.common.dto.identity.BeneficiariesDTO;
import com.iemr.common.dto.identity.BeneficiariesPartialDTO;
import com.iemr.common.dto.identity.IdentityEditDTO;
import com.iemr.common.model.beneficiary.BeneficiaryGenModel;
import com.iemr.common.utils.exception.IEMRException;

public interface IdentityBeneficiaryService {
	public List<BeneficiariesDTO> getBeneficiaryListByIDs(HashSet benIdList, String auth, Boolean is1097)
			throws IEMRException;

	String getIdentityResponse(String request, String auth, Boolean is1097) throws IEMRException;

	List<BeneficiariesPartialDTO> getPartialBeneficiaryListByIDs(HashSet benIdList, String auth, Boolean is1097)
			throws IEMRException;

	List<BeneficiariesDTO> getBeneficiaryListByPhone(String phoneNo, String auth, Boolean is1097) throws IEMRException;

	List<BeneficiariesDTO> getBeneficiaryListByBenID(String benId, String auth, Boolean is1097) throws IEMRException;

	List<BeneficiariesDTO> getBeneficiaryListByBenRegID(Long benRegId, String auth, Boolean is1097)
			throws IEMRException;

	Integer editIdentityEditDTO(IdentityEditDTO identityEditDTO, String auth, Boolean is1097) throws IEMRException;

	List<BeneficiariesDTO> searchBeneficiaryList(String identitySearchDTO, String auth, Boolean is1097)
			throws IEMRException;

	Integer editIdentityEditDTOCommunityorEducation(IdentityEditDTO identityEditDTO, String auth, Boolean is1097)
			throws IEMRException;

	List<BeneficiaryGenModel> generateBeneficiaryIDs(String request, String auth) throws IEMRException;

	public List<BeneficiariesDTO> getBeneficiaryListByHealthID_ABHAAddress(String healthID, String auth, Boolean is1097)
			throws IEMRException;

	public List<BeneficiariesDTO> getBeneficiaryListByHealthIDNo_ABHAIDNo(String healthIDNo, String auth,
			Boolean is1097) throws IEMRException;

	public List<BeneficiariesDTO> getBeneficiaryListByFamilyId(String familyId, String auth, Boolean is1097)
			throws IEMRException;

	public List<BeneficiariesDTO> getBeneficiaryListByGovId(String identity, String auth, Boolean is1097)
			throws IEMRException;
}
