package com.iemr.common.repository.nhm_dashboard;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.nhm_dashboard.AbandonCallSummary;

@Repository
public interface AbandonCallSummaryRepo extends CrudRepository<AbandonCallSummary, Long> {

	List<AbandonCallSummary> findByCreatedDateBetween(Timestamp startDate, Timestamp endDate);

}
