package com.iemr.common.repository.feedback;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.feedback.EpidemicOutbreak;

@Repository
@RestResource(exported = false)
public interface T_EpidemicOutbreakRepo extends CrudRepository<EpidemicOutbreak, Long> {
	@Query(" SELECT t FROM EpidemicOutbreak t WHERE t.requestID = :requestID ")
	public EpidemicOutbreak searchByRequestID(@Param("requestID") String requestID);
}
