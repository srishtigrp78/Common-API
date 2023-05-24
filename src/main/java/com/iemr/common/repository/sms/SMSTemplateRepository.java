package com.iemr.common.repository.sms;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.sms.SMSTemplate;

@Repository
@RestResource(exported = false)
public abstract interface SMSTemplateRepository extends CrudRepository<SMSTemplate, Integer>
{
	@Query("select smsTemplate from SMSTemplate smsTemplate where "
			+ "smsTemplate.providerServiceMapID = :providerServiceMapID "
			+ "order by smsTemplate.deleted, smsTemplate.smsTypeID ")
	public List<SMSTemplate> getSMSTemplateByProviderServiceMapIDOrderByDeletedSmsTypeIDDesc(
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select smsTemplate from SMSTemplate smsTemplate where "
			+ "smsTemplate.providerServiceMapID = :providerServiceMapID and "
			+ "smsTemplate.smsTypeID = :smsTypeID and smsTemplate.deleted<> true "
			+ "order by smsTemplate.deleted, smsTemplate.smsTypeID ")
	public List<SMSTemplate> getSMSTemplateByProviderServiceMapIDAndSMSTypeID(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("smsTypeID") Integer smsTypeID);

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update SMSTemplate set deleted = :deleted where smsTemplateID = :smsTemplateID")
	public int updateSMSTemplate(@Param("smsTemplateID") Integer smsTemplateID, @Param("deleted") Boolean deleted);
}
