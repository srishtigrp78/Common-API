package com.iemr.common.repository.sms;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.sms.SMSParameters;

@Repository
@RestResource(exported = false)
public interface SMSParameterRepository extends CrudRepository<SMSParameters, Integer>
{
	@Query("select smsParameters from SMSParameters smsParameters where (smsParameters.serviceID is null or smsParameters.serviceID = :serviceID) and smsParameters.deleted <> true")
	List<SMSParameters> findSMSParametersByDeletedNotTrue(@Param("serviceID") Integer serviceID);

}
