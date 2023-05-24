package com.iemr.common.service.institute;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.institute.Institute;
import com.iemr.common.data.institute.InstituteType;
import com.iemr.common.repository.institute.InstituteRepository;
import com.iemr.common.repository.institute.InstituteTypeRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class InstituteTypeServiceImpl implements InstituteTypeService
{
	InstituteTypeRepository instituteTypeRepository;
	
	@Autowired	
	private InstituteRepository instituteRepository;
	

	InputMapper inputMapper = new InputMapper();

	@Autowired
	public void setInstituteTypeRepository(InstituteTypeRepository instituteTypeRepository)
	{
		this.instituteTypeRepository = instituteTypeRepository;
	}

	@Override
	public List<InstituteType> getInstitutionTypes(String instituteTypeRequest) throws Exception 
	{
		InstituteType instituteType = inputMapper.gson().fromJson(instituteTypeRequest, InstituteType.class);
		if (instituteType.getProviderServiceMapID() != null)
		{
			return instituteTypeRepository.findAciveInstitutesTypes(instituteType.getProviderServiceMapID());
		} else
		{
			return instituteTypeRepository.findAciveInstitutesTypes();
		}
	}
	
	@Override
	public List<Institute> getInstitutionName(Integer institutionTypeID) throws Exception
	
	{
		ArrayList<Institute> institutes = new ArrayList<Institute>();
		ArrayList<Object[]> instituteResult = instituteRepository.getInstitutionNameByType(institutionTypeID);
		for (Object[] objects : instituteResult) {
			if (objects != null && objects.length == 2) {
				institutes.add(new Institute((Integer) objects[0], (String) objects[1]));
			}
		}
		return institutes;
//		return instituteRepository.getInstitutionNameByType(institutionTypeID);
	}
	@Override
	public List<Institute> getInstitutionNameByTypeAndDistrict(Integer institutionTypeID, Integer districtID) throws Exception
	
	{
		ArrayList<Institute> institutes = new ArrayList<Institute>();
		ArrayList<Object[]> instituteResult = instituteRepository.getInstitutionNameByTypeAndDistrict(institutionTypeID,districtID);
		for (Object[] objects : instituteResult) {
			if (objects != null && objects.length == 2) {
				institutes.add(new Institute((Integer) objects[0], (String) objects[1]));
			}
		}
		return institutes;
//		return instituteRepository.getInstitutionNameByType(institutionTypeID);
	}
}
