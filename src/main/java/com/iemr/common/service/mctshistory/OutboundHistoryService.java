/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.service.mctshistory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iemr.common.utils.exception.IEMRException;

public interface OutboundHistoryService {


	/**
	 * this method define to get previous history of the call
	 * @param request
	 * @return
	 * @throws IEMRException 
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	String getCallHistory(String request) throws IEMRException, JsonMappingException, JsonProcessingException;

	String getMctsCallResponse(String request) throws IEMRException, JsonMappingException, JsonProcessingException;

}
