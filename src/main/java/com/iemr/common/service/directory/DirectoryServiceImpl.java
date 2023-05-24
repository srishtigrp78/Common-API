package com.iemr.common.service.directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.directory.Directory;
import com.iemr.common.repository.directory.DirectoryRepository;

@Service
public class DirectoryServiceImpl implements DirectoryService
{
	private DirectoryRepository directoryRepository;

	@Autowired
	public void setDirectoryRepository(DirectoryRepository directoryRepository)
	{
		this.directoryRepository = directoryRepository;
	}

	@Override
	public List<Directory> getDirectories()
	{
		ArrayList<Directory> directories = new ArrayList<Directory>();
		Set<Objects[]> directoryResult = directoryRepository.findAciveDirectories();
		for (Object[] objects : directoryResult)
		{
			if (objects != null && objects.length >= 2)
			{
				directories.add(new Directory((Integer) objects[0], (String) objects[1]));
			}
		}
		return directories;
	}

	@Override
	public List<Directory> getDirectories(Integer providerServiceMapID)
	{
		List<Directory> directories = new ArrayList<Directory>();
		directories = directoryRepository.findAciveDirectories(providerServiceMapID);
		// for (Object[] objects : directoryResult) {
		// if (objects != null && objects.length == 2) {
		// directories.add(new Directory((Integer) objects[0], (String) objects[1]));
		// }
		// }
		return directories;
	}
}
