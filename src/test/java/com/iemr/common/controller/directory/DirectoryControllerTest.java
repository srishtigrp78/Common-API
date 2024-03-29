package com.iemr.common.controller.directory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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

	@Mock
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private InputMapper inputMapper = new InputMapper();

	@Mock
	private SubDirectoryService subDirectoryService;
	@Mock
	private DirectoryMappingService directoryMappingService;

//	@Test
//	void testGetDirectory() throws Exception {
//		OutputResponse response = new OutputResponse();
////		Directory directory = new Directory();
////		directory.setCreatedBy("dona");
////		List<Directory> directories = new ArrayList<Directory>();
////		directories.add(directory);
////		when(directoryService.getDirectories()).thenReturn(directories);
////		Map<String, List> responseObj = new HashMap<>();
////		responseObj.put("directory", directories);
////	//	response.setResponse(responseObj.toString());
////		Assertions.assertEquals(responseObj.toString(), directoryController.getDirectory());
//		String request = "{[\"institutionID\":123,\"directoryName\":\"Parent Directory\"]}";
//		Directory directory = new Directory();
//		directory.setInstituteDirectoryID(123);
//		directory.setInstituteDirectoryName("Parent Directory");
//		List<Directory> directories = new ArrayList<Directory>();
//		directories.add(directory);
//		 
//		JSONObject responseObj = new JSONObject(directories.toString());
//		 
//		when(directoryService.getDirectories()).thenReturn(directories);
//		 
//		 
//		assertEquals(responseObj.toString(), directoryController.getDirectory());
//		
//	}

//	@Test
//	void testGetDirectoryV1() {
//		OutputResponse response = new OutputResponse();
//		Directory directory = new Directory();
//		directory.setProviderServiceMapID(123);
//		List<Directory> directories = new ArrayList<Directory>();
//		directories.add(directory);
//		Gson gson = new Gson();
//		String directoryRequest = gson.toJson(directory);
//		when(directoryService.getDirectories(directory.getProviderServiceMapID())).thenReturn(directories);
//		response.setResponse("{\"directory\":" + gson.toJson(directories) + "}");
//		Assertions.assertEquals(response.toString(), directoryController.getDirectoryV1(directoryRequest));
//	}

//	@Test
//	void testGetDirectorySuccess() throws Exception {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetDirectoryWithException() {
		// Arrange
		String errorMessage = "Failed to get directories";
		when(directoryService.getDirectories()).thenThrow(new RuntimeException(errorMessage));

		// Act
		String result = directoryController.getDirectory();

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("error"));
		verify(directoryService).getDirectories(); // Verify getDirectories() was called
	}

//	
//	@Test
//	void testGetDirectoryV1() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetDirectoryV1WithException() {
		// Arrange
		String directoryRequest = "";

		String errorMessage = "Failed to get directories";

		// Act
		String result = directoryController.getDirectoryV1(directoryRequest);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("error"));
	}

//	@Test
//	void testGetSubDirectory() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetSubDirectoryWithException() {
		// Arrange
		String subDirectoryRequest = "";

		String errorMessage = "Failed to get directories";

		// Act
		String result = directoryController.getSubDirectory(subDirectoryRequest);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("error"));
	}

//	@Test
//	void testGetInstitutesDirectories() throws IEMRException {
//		OutputResponse response = new OutputResponse();
//		InstituteDirectoryMapping directoryMap = new InstituteDirectoryMapping();
//		directoryMap.setInstituteDirectoryID(123);
//		directoryMap.setInstituteSubDirectoryID(345);
//		directoryMap.setStateID(432);
//		directoryMap.setDistrictID(12);
//		directoryMap.setBlockID(34);
//		String request = directoryMap.toString();
//		List<InstituteDirectoryMapping> instituteDirectoryMappings = new ArrayList<InstituteDirectoryMapping>();
//		instituteDirectoryMappings.add(directoryMap);
//		when(directoryMappingService.findAciveInstituteDirectories(request)).thenReturn(instituteDirectoryMappings);
//		response.setResponse(instituteDirectoryMappings.toString());
//		Assertions.assertEquals(response.toString(), directoryController.getInstitutesDirectories(request));
//	}

//	@Test
//	void testGetInstitutesDirectories_CatchBlock() throws IEMRException {
//		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
//		when(directoryMappingService.findAciveInstituteDirectories(request)).thenThrow(NotFoundException.class);
//		String response = directoryController.getInstitutesDirectories(request);
//		Assertions.assertEquals(response, directoryController.getInstitutesDirectories(request));
//	}

	@Test
	void testGetInstitutesDirectories_Exception() throws IEMRException, JsonMappingException, JsonProcessingException {
		// Prepare input JSON
		String requestJson = "{\"instituteDirectoryID\":\"1\", ...}";

		// Mock the service to throw an exception
		when(directoryMappingService.findAciveInstituteDirectories(anyString()))
				.thenThrow(new RuntimeException("Database error"));

		// Execute the method
		String result = directoryController.getInstitutesDirectories(requestJson);

		// Verify
		assertNotNull(result);
		assertTrue(result.contains("error")); // Assuming your OutputResponse's toString includes "error" on exceptions
	}

}
