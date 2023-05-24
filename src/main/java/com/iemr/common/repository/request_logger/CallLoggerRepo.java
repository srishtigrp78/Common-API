package com.iemr.common.repository.request_logger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.request_logger.CallLogger;

@Repository
@RestResource(exported = false)
public interface CallLoggerRepo extends CrudRepository<CallLogger, Long> {

}
