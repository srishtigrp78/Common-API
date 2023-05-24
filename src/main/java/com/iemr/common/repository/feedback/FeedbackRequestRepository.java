package com.iemr.common.repository.feedback;

import java.util.ArrayList;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.feedback.FeedbackRequest;

@Repository
@RestResource(exported = false)
public interface FeedbackRequestRepository extends CrudRepository<FeedbackRequest, Long>
{
	@Transactional
	@Modifying
	@Query("update FeedbackRequest set " + "feedbackSupSummary = :feedbackSupSummary, " + "supUserID = :supUserID, "
			+ "comments = :comments, " + "emailStatusID = :emailStatusID "
			+ "where feedbackRequestID = :feedbackRequestID")
	Integer update(@Param("feedbackRequestID") Long feedbackRequestID,
			@Param("feedbackSupSummary") String feedbackSupSummary, @Param("supUserID") Integer supUserID,
			@Param("comments") String comments, @Param("emailStatusID") Integer emailStatusID);

	@Transactional
	@Modifying
	@Query("update FeedbackRequest set emailStatusID = :emailStatusID " + "where feedbackID = :feedbackID")
	Integer updateFeedbackRequestStatus(@Param("emailStatusID") Integer emailStatusID,
			@Param("feedbackID") Long feedbackID);

	@Query("select req.feedbackRequestID, req.feedbackID, req.feedbackSupSummary, req.supUserID, req.comments, "
			+ "req.emailStatusID, req.emailStatus, req.createdDate, req.createdBy from FeedbackRequest req "
			+ "left join req.emailStatus where req.feedbackID = :feedbackID order by feedbackRequestID desc")
	ArrayList<Object[]> getAllFeedback(@Param("feedbackID") Long feedbackID);

	@Transactional
	@Modifying
	@Query("update FeedbackRequest set emailStatusID = :emailStatusID "
			+ "where feedbackRequestID = :feedbackRequestID")
	Integer updateEmailStatus(@Param("emailStatusID") Integer emailStatusID,
			@Param("feedbackRequestID") Long feedbackRequestID);

}
