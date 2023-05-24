package com.iemr.common.service.reports;

import java.util.List;

import com.iemr.common.data.report.CallDetailsReport;

public interface CallReportsService
{
	List<CallDetailsReport> getAllReportsByDate(CallDetailsReport request) throws Exception;

	String getAllByAgeGroup(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getAllByGender(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getAllBySexualOrientation(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getCountsByPreferredLanguage(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getComplaintDetailReport(String request) throws Exception;

	String getUnblockedUserReport(String request) throws Exception;

	String getCallQualityReport(String request) throws Exception;

	String getDistrictWiseCallReport(String request) throws Exception;

	String callUrl(String urlRequest);

	String getQualityReport(String request) throws Exception;

	String getCallSummaryReport(String request) throws Exception;
	
	String getReportTypes(Integer providerServiceMapID) throws Exception;
}
