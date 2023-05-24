package com.iemr.common.service.honeywell;

public interface HoneywellService {
	String getDistrictWiseCallReport(String request) throws Exception;
	String getRealtimeDistrictWiseCallReport() throws Exception;
	String getUrbanRuralCallReport(String request) throws Exception;
}
