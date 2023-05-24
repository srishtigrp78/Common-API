package com.iemr.common.repository.nhm_dashboard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.nhm_dashboard.LineCallSummary;

@Repository
public interface LineCallSummaryRepo extends CrudRepository<LineCallSummary, Long> {

}
