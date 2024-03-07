package com.iemr.common.controller.directory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.directory.Directory;
import com.iemr.common.service.directory.DirectoryMappingService;
import com.iemr.common.service.directory.DirectoryService;
import com.iemr.common.service.directory.SubDirectoryService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class DirectoryControllerTest {
	
	@InjectMocks
	DirectoryController directoryController;
	
	@Mock
	private DirectoryService directoryService;
	
	private InputMapper inputMapper = new InputMapper();
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Mock
	private SubDirectoryService subDirectoryService;
	@Mock
	private DirectoryMappingService directoryMappingService;

	


	@Test
	void testGetDirectory() throws Exception {
		OutputResponse response = new OutputResponse();
		Directory directory = new Directory();
		directory.setCreatedBy("dona");
		List<Directory> directories = new ArrayList<Directory>();
		directories.add(directory);
		when(directoryService.getDirectories()).thenReturn(directories);
		JSONObject responseObj = new JSONObject();
		responseObj.put("directory", directories);
		String expResp = directoryController.getDirectory();
		Assertions.assertEquals(expResp, directoryController.getDirectory());
		
	}

	@Test
	void testGetDirectoryV1() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSubDirectory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInstitutesDirectories() {
		fail("Not yet implemented");
	}

}
