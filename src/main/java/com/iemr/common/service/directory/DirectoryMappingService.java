package com.iemr.common.service.directory;

import java.util.List;

import com.iemr.common.data.directory.InstituteDirectoryMapping;
import com.iemr.common.utils.exception.IEMRException;

public interface DirectoryMappingService
{
	public List<InstituteDirectoryMapping> findAciveInstituteDirectories(String request) throws IEMRException;
}
