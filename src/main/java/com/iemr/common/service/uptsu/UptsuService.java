package com.iemr.common.service.uptsu;

import com.iemr.common.utils.exception.IEMRException;

public interface UptsuService {
	
	public String getFacility(Integer providerServiceMapID, String blockname);
	
	public String saveAppointmentDetails(String request, String Authorization) throws Exception;

}
