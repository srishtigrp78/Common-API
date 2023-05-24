package com.iemr.common.repository.sms;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.sms.SMSParametersMap;

@Repository
@RestResource(exported = false)
public interface SMSParameterMapRepository extends CrudRepository<SMSParametersMap, Integer>
{

	List<SMSParametersMap> findSMSParametersMapBySmsTemplateID(Integer smsTemplateID);

}
