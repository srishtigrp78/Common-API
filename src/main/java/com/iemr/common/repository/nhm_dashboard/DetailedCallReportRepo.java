package com.iemr.common.repository.nhm_dashboard;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.nhm_dashboard.DetailedCallReport;

@Repository
public interface DetailedCallReportRepo extends CrudRepository<DetailedCallReport, Long> {
	List<DetailedCallReport> findByCallStartTimeBetween(Timestamp startDate, Timestamp endDate);
}
