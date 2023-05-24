package com.iemr.common.service.directory;

import java.util.List;

import com.iemr.common.data.directory.SubDirectory;

public interface SubDirectoryService {	
	public List<SubDirectory> getSubDirectories(int directoryID);
}
