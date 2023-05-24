package com.iemr.common.repository.sms;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.sms.SMSType;

@Repository
@RestResource(exported = false)
public interface SMSTypeRepository extends CrudRepository<SMSType, Integer>
{
	@Query(value = "select smsType from SMSType smsType where smsType.serviceID = :serviceID and smsType.deleted <> true")
	ArrayList<SMSType> findSMSTypeByDeletedNotTrue(@Param("serviceID")Integer serviceID);
}
