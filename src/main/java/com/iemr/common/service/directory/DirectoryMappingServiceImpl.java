package com.iemr.common.service.directory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.directory.InstituteDirectoryMapping;
import com.iemr.common.repository.directory.DirectoryMappingRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class DirectoryMappingServiceImpl implements DirectoryMappingService
{
	private DirectoryMappingRepository directoryMappingRepository;

	@Autowired
	public void setDirectoryRepository(DirectoryMappingRepository directoryMappingRepository)
	{
		this.directoryMappingRepository = directoryMappingRepository;
	}

	@Override
	public List<InstituteDirectoryMapping> findAciveInstituteDirectories(String request) throws IEMRException
	{
		InstituteDirectoryMapping requestObj = InputMapper.gson().fromJson(request, InstituteDirectoryMapping.class);
		List<InstituteDirectoryMapping> instituteDirectoryMappings = null;
		if (requestObj.getBlockID() != null)
		{
			instituteDirectoryMappings = directoryMappingRepository.findAciveInstituteDirectories(
					requestObj.getInstituteDirectoryID(), requestObj.getInstituteSubDirectoryID(),
					requestObj.getStateID(), requestObj.getDistrictID(), requestObj.getBlockID());
		} else if (requestObj.getStateID() != null && requestObj.getDistrictID() != null)
		{
			instituteDirectoryMappings = directoryMappingRepository.findAciveInstituteDirectories(
					requestObj.getInstituteDirectoryID(), requestObj.getInstituteSubDirectoryID(),
					requestObj.getStateID(), requestObj.getDistrictID());
		} else
		{
			instituteDirectoryMappings = directoryMappingRepository.findAciveInstituteDirectories(
					requestObj.getInstituteDirectoryID(), requestObj.getInstituteSubDirectoryID());
		}
		return instituteDirectoryMappings;
	}
}
