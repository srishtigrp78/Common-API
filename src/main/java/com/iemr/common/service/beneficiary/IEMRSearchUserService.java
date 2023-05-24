package com.iemr.common.service.beneficiary;

import java.util.List;

import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.model.beneficiary.BeneficiaryModel;

public interface IEMRSearchUserService {

	List<BeneficiaryModel> userExitsCheckWithId(Long beneficiaryId, String auth, Boolean is1097) throws Exception;

	List<Beneficiary> findByBeneficiaryRegID(Beneficiary beneficiary);

	String findByBeneficiaryPhoneNo(BenPhoneMap benPhoneMap, Integer pageNo, Integer rows, String auth)
			throws Exception;

	String findBeneficiary(BeneficiaryModel request, String auth) throws Exception;

	List<BeneficiaryModel> userExitsCheckWithId(String beneficiaryID, String auth, Boolean is1097) throws Exception;

	public List<BeneficiaryModel> userExitsCheckWithHealthId_ABHAId(String healthID, String auth, Boolean is1097)
			throws Exception;

	public List<BeneficiaryModel> userExitsCheckWithHealthIdNo_ABHAIdNo(String healthIDNo, String auth, Boolean is1097)
			throws Exception;

	public List<BeneficiaryModel> userExitsCheckWithFamilyId(String familyId, String auth, Boolean is1097)
			throws Exception;

	public List<BeneficiaryModel> userExitsCheckWithGovIdentity(String identity, String auth, Boolean is1097)
			throws Exception;

}
