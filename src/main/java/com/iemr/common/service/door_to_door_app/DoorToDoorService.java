package com.iemr.common.service.door_to_door_app;

import com.iemr.common.data.door_to_door_app.RequestParser;

public interface DoorToDoorService {
	public String getUserDetails(String request) throws Exception;

	public String get_NCD_TB_HRP_Suspected_Status(RequestParser rp) throws Exception;
	
	public void scheduleJobForRegisterAvniBeneficiary() throws Exception;
}
