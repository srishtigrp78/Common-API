package com.iemr.common.service.institute;

import java.util.List;

import com.iemr.common.data.institute.Institute;
import com.iemr.common.data.institute.InstituteType;

public interface InstituteTypeService
{
	public List<InstituteType> getInstitutionTypes(String institutionTypeRequest) throws Exception;
	public List<Institute> getInstitutionName( Integer institutionTypeID) throws Exception;
	public List<Institute> getInstitutionNameByTypeAndDistrict( Integer institutionTypeID,Integer districtID) throws Exception;
}
