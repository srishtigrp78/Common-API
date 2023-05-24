package com.iemr.common.repository.feedback;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.feedback.FeedbackSeverity;

@Repository
@RestResource(exported = false)
public interface FeedbackSeverityRepository extends CrudRepository<FeedbackSeverity, Long>
{
	@Query("select severityID, severityTypeName from FeedbackSeverity where deleted = false "
			+ "order by severityTypeName asc")
	Set<Objects[]> getActiveFeedbackSeverity();

	@Query("select new FeedbackSeverity(severityID, severityTypeName) from FeedbackSeverity where "
			+ "providerServiceMapID = :providerServiceMapID and deleted = false order by severityTypeName asc")
	List<FeedbackSeverity> getActiveFeedbackSeverity(@Param("providerServiceMapID") Integer providerServiceMapID);
}
