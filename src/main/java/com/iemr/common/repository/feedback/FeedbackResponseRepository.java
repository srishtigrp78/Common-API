package com.iemr.common.repository.feedback;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.feedback.FeedbackResponse;

@Repository
@RestResource(exported = false)
public interface FeedbackResponseRepository extends CrudRepository<FeedbackResponse, Long> {
	@Query("SELECT response.responseSummary, response.feedbackRequestID, "
			+ "response.comments, response.authName, response.authDesignation, "
			+ "request.feedbackID as FeedbackID, request.feedbackSupSummary as FeedbackSupSummary, "
			+ "request.comments as Comments, details.feedback as Feedback " + "FROM FeedbackResponse response "
			+ "JOIN response.feedbackRequest request " + "JOIN response.feedbackDetails details "
			+ "WHERE response.feedbackID =:feedbackID order by response.feedbackRequestID desc")
	ArrayList<Object[]> getdatabyId(@Param("feedbackID") Long feedbackID);

	@Query("SELECT r.responseSummary, r.feedbackRequestID, r.comments, r.authName, r.authDesignation, "
			+ "r.feedbackID, r.feedbackResponseID, r.createdDate, r.createdBy, r.kmFileManagerID, r.kmFileManager "
			+ "FROM FeedbackResponse r left join r.kmFileManager WHERE feedbackID =:feedbackID order by feedbackResponseID desc")
	ArrayList<Object[]> getDataByFeedbackID(@Param("feedbackID") Long feedbackID);

	@Transactional
	@Modifying
	@Query("update FeedbackResponse set kmFileManagerID = :kmFileManagerID where feedbackResponseID=:feedbackResponseID")
	Integer updateFileID(@Param("kmFileManagerID") Integer kmFileManagerID,
			@Param("feedbackResponseID") Long feedbackResponseID);
}
