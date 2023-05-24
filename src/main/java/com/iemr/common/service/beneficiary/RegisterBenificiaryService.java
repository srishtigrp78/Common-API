/**
 * 
 */
package com.iemr.common.service.beneficiary;

import javax.servlet.http.HttpServletRequest;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.model.beneficiary.BeneficiaryModel;

import com.iemr.common.utils.exception.IEMRException;

/**
 * @author WA875423
 *
 */
public interface RegisterBenificiaryService
{

	public Beneficiary save(Beneficiary m_user);

	// public Integer updateBenificiary(Beneficiary m_user);

	public Integer updateBenificiary(BeneficiaryModel m_user, String auth) throws IEMRException;

	String save(BeneficiaryModel beneficiaryModel, HttpServletRequest servletRequest) throws Exception;
	
	public Integer updateCommunityorEducation(BeneficiaryModel m_user, String auth) throws IEMRException;
	//
	// List<Beneficiary> findByBeneficiaryRegID(Beneficiary benificiaryDetails);
	//
	// List<Beneficiary> findByBeneficiaryPhoneNo(Beneficiary beneficiary);

	String generateBeneficiaryIDs(String request, HttpServletRequest servletRequest) throws Exception;

	// Beneficiary updateBenificiary(Beneficiary benificiaryDetails);
}
