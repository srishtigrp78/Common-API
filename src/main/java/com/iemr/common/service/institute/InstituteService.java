package com.iemr.common.service.institute;


import java.util.List;

import com.iemr.common.data.institute.Institute;

public interface InstituteService {

	public List<Institute> getInstitutesByStateDistrictBranch(Integer stateID, Integer districtID, Integer districtBranchID);
	
	public List<Institute> getInstitutesByBranch(Integer districtBranchID);
}
