package com.iemr.common.service.directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.directory.SubDirectory;
import com.iemr.common.repository.directory.SubDirectoryRepository;

@Service
public class SubDirectoryServiceImpl implements SubDirectoryService {
	private SubDirectoryRepository subDirectoryRepository;

	@Autowired
	public void setSubDirectoryRepository(SubDirectoryRepository subDirectoryRepository) {
		this.subDirectoryRepository = subDirectoryRepository;
	}

	@Override
	public List<SubDirectory> getSubDirectories(int directoryID) {
		ArrayList<SubDirectory> subDirectories = new ArrayList<SubDirectory>();
		Set<Objects[]> subDirectoryResult = subDirectoryRepository.findAciveSubDirectories(directoryID);
		for (Object[] objects : subDirectoryResult) {
			if (objects != null && objects.length == 2) {
				subDirectories.add(new SubDirectory((Integer) objects[0], (String) objects[1]));
			}
		}
		return subDirectories;
	}
}
