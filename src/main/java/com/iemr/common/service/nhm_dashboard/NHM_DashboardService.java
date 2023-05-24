package com.iemr.common.service.nhm_dashboard;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iemr.common.data.nhm_dashboard.AbandonCallSummary;
import com.iemr.common.data.nhm_dashboard.AgentSummaryReport;
import com.iemr.common.data.nhm_dashboard.DetailedCallReport;
import com.iemr.common.notification.exception.IEMRException;

@Service
public interface NHM_DashboardService {

	public String pushAbandonCalls(AbandonCallSummary abandonCallSummary) throws Exception;

	public String getAbandonCalls() throws Exception;

	public String saveAgentSummaryReport(List<AgentSummaryReport> agentSummaryReportList) throws IEMRException;

	public String saveDetailedCallReport(List<DetailedCallReport> detailedCallReportList) throws IEMRException;

	public String pull_NHM_Data_CTI() throws IEMRException;

	public String getAgentSummaryReport() throws Exception;

	public String getDetailedCallReport() throws Exception;

}
