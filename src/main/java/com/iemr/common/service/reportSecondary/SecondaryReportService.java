package com.iemr.common.service.reportSecondary;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.data.report.CallQualityReport;

public interface SecondaryReportService {
	ByteArrayInputStream getQualityReport(String request, String filename) throws Exception;

	ByteArrayInputStream getComplaintDetailReport(String jsonRequest,String filename) throws Exception;
	
	ByteArrayInputStream getCallSummaryReport(String jsonRequest,String filename) throws Exception;

	ByteArrayInputStream getDistrictWiseCallReport1(String jsonRequest, String filename) throws Exception;

	ByteArrayInputStream getDistrictWiseCallReport(String jsonRequest, String filename) throws Exception;
	
	ByteArrayInputStream getUnblockedUserReport(String jsonRequest,String filename) throws Exception;
	
	ByteArrayInputStream getAllBySexualOrientationReport(String jsonRequest,String filename) throws Exception;

	ByteArrayInputStream getCallQualityReport(CallQualityReport callQualityReport, String filename) throws Exception;

    ByteArrayInputStream getCountsByPrefferedLanguage(String jsonRequest, String filename) throws Exception;

	ByteArrayInputStream getAllByAgeGroup(String jsonRequest, String filename) throws Exception;
	
	ByteArrayInputStream getAllReportsByDate(String jsonRequest, String filename) throws Exception;
	
	ByteArrayInputStream getAllByGender(String jsonRequest, String filename) throws Exception;

}
