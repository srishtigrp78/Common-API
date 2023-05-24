package com.iemr.common.repository.feedback;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.feedback.FeedbackType;

@Repository
@RestResource(exported = false)
public interface FeedbackTypeRepository extends CrudRepository<FeedbackType, Long>
{
	@Query("select feedbackTypeID, feedbackTypeName from FeedbackType where deleted = false "
			+ "order by feedbackTypeName asc")
	Set<Objects[]> findActiveFeedbackTypes();

	@Query("select new FeedbackType(feedbackTypeID, feedbackTypeName) from FeedbackType type where "
			+ "providerServiceMapID = :providerServiceMapID and deleted = false order by feedbackTypeName asc")
	List<FeedbackType> findActiveFeedbackTypes(@Param("providerServiceMapID") Integer providerServiceMapID);
}
