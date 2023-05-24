package com.iemr.common.repository.feedback;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.feedback.FeedbackLog;

@Repository
@RestResource(exported = false)
public interface FeedbackLogRepository extends CrudRepository<FeedbackLog, Long>{

	@Query("select feedbacklog from FeedbackLog feedbacklog "
			+ "where feedbacklog.feedbackID = :feedbackID ")
	public List<FeedbackLog> getFeedbackLogs(@Param("feedbackID") Long feedbackID);
	
}
