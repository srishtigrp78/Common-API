package com.iemr.common.repository.feedback;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.feedback.BalVivahComplaint;

@Repository
@RestResource(exported = false)
public interface BalVivahComplaintRepo extends CrudRepository<BalVivahComplaint, Long> {
	@Query(" SELECT t FROM BalVivahComplaint t WHERE t.requestID = :requestID ")
	public BalVivahComplaint searchByRequestID(@Param("requestID") String requestID);
}
