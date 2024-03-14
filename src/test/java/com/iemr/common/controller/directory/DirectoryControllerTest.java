package com.iemr.common.controller.directory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.google.gson.Gson;
import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.directory.InstituteDirectoryMapping;
import com.iemr.common.service.directory.DirectoryMappingService;
import com.iemr.common.service.directory.DirectoryService;
import com.iemr.common.service.directory.SubDirectoryService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

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
//		Directory directory = new Directory();
//		directory.setCreatedBy("dona");
//		List<Directory> directories = new ArrayList<Directory>();
//		directories.add(directory);
//		when(directoryService.getDirectories()).thenReturn(directories);
//		Map<String, List> responseObj = new HashMap<>();
//		responseObj.put("directory", directories);
//	//	response.setResponse(responseObj.toString());
//		Assertions.assertEquals(responseObj.toString(), directoryController.getDirectory());
		String request = "{[\"institutionID\":123,\"directoryName\":\"Parent Directory\"]}";
		Directory directory = new Directory();
		directory.setInstituteDirectoryID(123);
		directory.setInstituteDirectoryName("Parent Directory");
		List<Directory> directories = new ArrayList<Directory>();
		directories.add(directory);
		 
		JSONObject responseObj = new JSONObject(directories.toString());
		 
		when(directoryService.getDirectories()).thenReturn(directories);
		 
		 
		assertEquals(responseObj.toString(), directoryController.getDirectory());
		
	}

	@Test
	void testGetDirectoryV1() {
		OutputResponse response = new OutputResponse();
		Directory directory = new Directory();
		directory.setProviderServiceMapID(123);
		List<Directory> directories = new ArrayList<Directory>();
		directories.add(directory);
		Gson gson = new Gson();
		String directoryRequest = gson.toJson(directory);
		when(directoryService.getDirectories(directory.getProviderServiceMapID())).thenReturn(directories);
		response.setResponse("{\"directory\":" + gson.toJson(directories) + "}");
		Assertions.assertEquals(response.toString(), directoryController.getDirectoryV1(directoryRequest));
	}

	@Test
	void testGetSubDirectory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInstitutesDirectories() throws IEMRException {
		OutputResponse response = new OutputResponse();
		InstituteDirectoryMapping directoryMap = new InstituteDirectoryMapping();
		directoryMap.setInstituteDirectoryID(123);
		directoryMap.setInstituteSubDirectoryID(345);
		directoryMap.setStateID(432);
		directoryMap.setDistrictID(12);
		directoryMap.setBlockID(34);
		String request = directoryMap.toString();
		List<InstituteDirectoryMapping> instituteDirectoryMappings = new ArrayList<InstituteDirectoryMapping>();
		instituteDirectoryMappings.add(directoryMap);
		when(directoryMappingService.findAciveInstituteDirectories(request)).thenReturn(instituteDirectoryMappings);
		response.setResponse(instituteDirectoryMappings.toString());
		Assertions.assertEquals(response.toString(), directoryController.getInstitutesDirectories(request));
	}
	
	@Test
	void testGetInstitutesDirectories_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(directoryMappingService.findAciveInstituteDirectories(request)).thenThrow(NotFoundException.class);
		String response = directoryController.getInstitutesDirectories(request);
		Assertions.assertEquals(response, directoryController.getInstitutesDirectories(request));
	}

}
