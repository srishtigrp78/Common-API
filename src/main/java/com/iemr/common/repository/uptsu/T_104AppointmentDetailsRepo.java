package com.iemr.common.repository.uptsu;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.uptsu.T_104AppointmentDetails;

@Repository
public interface T_104AppointmentDetailsRepo extends CrudRepository<T_104AppointmentDetails, Integer>{
	
	@Query(value = " SELECT SMSTypeID FROM db_iemr.m_smstype " + " WHERE SMSType = :choSms ", nativeQuery = true)
	public Integer getSMSTypeIDCho(@Param("choSms") String choSms);
	
	@Query(value = " SELECT SMSTypeID FROM db_iemr.m_smstype " + " WHERE SMSType = :benSms ", nativeQuery = true)
	public Integer getSMSTypeIDBen(@Param("benSms") String benSms);
	
	@Query(value = " SELECT SMSTemplateID FROM db_iemr.m_smstemplate "
			+ " WHERE SMSTypeID = :smsTypeIDForCho ", nativeQuery = true)
	public Integer getSMSTemplateIDCho(@Param("smsTypeIDForCho") Integer smsTypeIDForCho);
	
	@Query(value = " SELECT SMSTemplateID FROM db_iemr.m_smstemplate "
			+ " WHERE SMSTypeID = :smsTypeIDForBeneficiary AND deleted = false", nativeQuery = true)
	public Integer getSMSTemplateIDBen(@Param("smsTypeIDForBeneficiary") Integer smsTypeIDForBeneficiary);
	
	
	@Query(value = "call Pr_BeneficiaryDetails(:benRegId)", nativeQuery = true)
	Object[] findBeneficiaryNameAndBeneficiaryIdByBenRegId(@Param("benRegId") Long benRegId);


}
