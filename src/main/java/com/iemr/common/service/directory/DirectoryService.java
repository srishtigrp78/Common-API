package com.iemr.common.service.directory;

import java.util.List;

import com.iemr.common.data.directory.Directory;

public interface DirectoryService
{
	public List<Directory> getDirectories();

	public List<Directory> getDirectories(Integer providerServiceMapID);
}
