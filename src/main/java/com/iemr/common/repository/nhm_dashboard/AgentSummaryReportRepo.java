package com.iemr.common.repository.nhm_dashboard;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.nhm_dashboard.AgentSummaryReport;

@Repository
public interface AgentSummaryReportRepo extends CrudRepository<AgentSummaryReport, Long> {
	List<AgentSummaryReport> findByCreatedDateBetween(Timestamp startDate, Timestamp endDate);
}
