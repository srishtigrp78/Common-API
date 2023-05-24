package com.iemr.common.repository.feedback;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.feedback.FeedbackStatus;

@Repository
@RestResource(exported = false)
public interface FeedbackStatusRepository extends CrudRepository<FeedbackStatus, Long>
{

	@Query("select feedbackStatusID, feedbackStatus, feedbackStatusDesc from FeedbackStatus "
			+ "where deleted=false and providerServiceMapID is null "
			+ "order by feedbackStatus asc")
	public ArrayList<Objects[]> findAllFeedbackStatus();

	@Query("select feedbackStatusID from FeedbackStatus where deleted=false and providerServiceMapID is null "
			+ "and feedbackStatus='New' order by feedbackStatus asc")
	public Integer findNewFeedbackStatusID();

}
