package com.iemr.common.repository.report;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.data.report.CallReport;

@Repository
@RestResource(exported = false)

public interface CallReportRepo extends CrudRepository<BeneficiaryCall, Integer> {
	@Query("select report from BeneficiaryCall report "
			+ "where (report.cZcallDuration is null or report.recordingPath is null) and report.agentID is not null and report.phoneNo!='undefined' and report.phoneNo is not null "
			+ "and report.createdDate >= :startDate and report.createdDate <= :endDate ")
	public List<BeneficiaryCall> getAllBenCallIDetails(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);//start date and end date as param for x days.
}
