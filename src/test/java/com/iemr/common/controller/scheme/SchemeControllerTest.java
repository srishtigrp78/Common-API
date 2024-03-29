//package com.iemr.common.controller.scheme;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.atLeast;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.mockStatic;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Timeout;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockedStatic;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.github.dozermapper.core.Mapper;
//import com.google.gson.Gson;
//import com.iemr.common.data.scheme.Scheme;
//import com.iemr.common.service.scheme.SchemeServiceImpl;
//import com.iemr.common.utils.mapper.InputMapper;
//
//@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
//@ExtendWith(MockitoExtension.class)
//class SchemeControllerTest {
//
//	private final SchemeServiceImpl schemeServiceImplMock = mock(SchemeServiceImpl.class, "schemeServiceImpl");
//
//	private AutoCloseable autoCloseableMocks;
//
//	@InjectMocks()
//	private SchemeController target;
//
//	@AfterEach()
//	public void afterTest() throws Exception {
//		if (autoCloseableMocks != null)
//			autoCloseableMocks.close();
//	}
//
//	// Sapient generated method id: ${8327a369-3f5d-3693-85f8-54ade40d15ec}, hash:
//	// 8C5DBB9337F7828196ECA33A8B2946F2
//	@Test()
//	void saveSchemeDetailsTest() throws Exception {
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		Scheme schemeMock2 = mock(Scheme.class, "saveSchemeDetails_scheme1");
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("request1", Scheme.class);
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			doReturn(schemeMock2).when(schemeServiceImplMock).save(schemeMock);
//			// Act Statement(s)
//			String result = target.saveSchemeDetails("request1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":{\"response\":\"saveSchemeDetails_scheme1\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("request1", Scheme.class);
//				verify(schemeServiceImplMock).save(schemeMock);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${4b837c34-ef70-38f3-99aa-fe553c413546}, hash:
//	// 22E5B4B0557E7EE1C132507DACD0C8CC
//	@Test()
//	void saveSchemeDetailsWhenCaughtException() throws Exception {
//		/*
//		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
//		 * method is not unit testable!* Following variables could not be
//		 * isolated/mocked: output* Suggestions:* You can pass them as constructor
//		 * arguments or create a setter for them (avoid new operator)* or adjust the
//		 * input/test parameter values manually to satisfy the requirements of the given
//		 * test scenario.* The test code, including the assertion statements, has been
//		 * successfully generated.
//		 */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		Scheme schemeMock2 = mock(Scheme.class, "saveSchemeDetails_scheme1");
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("request1", Scheme.class);
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			doReturn(schemeMock2).when(schemeServiceImplMock).save(schemeMock);
//			// Act Statement(s)
//			String result = target.saveSchemeDetails("request1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":{\"response\":\"saveSchemeDetails_scheme1\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("request1", Scheme.class);
//				verify(schemeServiceImplMock).save(schemeMock);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${a8bb1740-0c3c-372c-bbda-f573ee981e85}, hash:
//	// 8C2FAD7610D55A296A44C63111E3D940
//	@Test()
//	void getSchemeListWhenSchemesIsNotNull() throws Exception {
//		/* Branches:* (schemes != null) : true */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("", Scheme.class);
//			doReturn(0).when(schemeMock).getProviderServiceMapID();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			List<Scheme> schemeList = new ArrayList<>();
//			doReturn(schemeList).when(schemeServiceImplMock).getSchemeList(0);
//			// Act Statement(s)
//			String result = target.getSchemeList("");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("", Scheme.class);
//				verify(schemeMock).getProviderServiceMapID();
//				verify(schemeServiceImplMock).getSchemeList(0);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${bc4a06bf-0cd3-3262-b062-1182ffc0c637}, hash:
//	// 9007F2E0932EC052C082AD9624938613
//	@Test()
//	void getSchemeListWhenSchemesIsNull() throws Exception {
//		/* Branches:* (schemes != null) : false */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("A", Scheme.class);
//			doReturn(0).when(schemeMock).getProviderServiceMapID();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			doReturn(null).when(schemeServiceImplMock).getSchemeList(0);
//			// Act Statement(s)
//			String result = target.getSchemeList("A");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"statusCode\":5000,\"errorMessage\":\"No schemes available\",\"status\":\"No schemes available\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("A", Scheme.class);
//				verify(schemeMock).getProviderServiceMapID();
//				verify(schemeServiceImplMock).getSchemeList(0);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${51f6c62d-091d-3260-9b47-725d5f3bf5ce}, hash:
//	// E0BC07881256CB7D14F1813FEC96132A
//	@Test()
//	void getSchemeListWhenCaughtException() throws Exception {
//		/*
//		 * Branches:* (schemes != null) : true* (catch-exception (Exception)) : true**
//		 * TODO: Help needed! This method is not unit testable!* Following variables
//		 * could not be isolated/mocked: output* Suggestions:* You can pass them as
//		 * constructor arguments or create a setter for them (avoid new operator)* or
//		 * adjust the input/test parameter values manually to satisfy the requirements
//		 * of the given test scenario.* The test code, including the assertion
//		 * statements, has been successfully generated.
//		 */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("", Scheme.class);
//			doReturn(0).when(schemeMock).getProviderServiceMapID();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			List<Scheme> schemeList = new ArrayList<>();
//			doReturn(schemeList).when(schemeServiceImplMock).getSchemeList(0);
//			// Act Statement(s)
//			String result = target.getSchemeList("");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("", Scheme.class);
//				verify(schemeMock).getProviderServiceMapID();
//				verify(schemeServiceImplMock).getSchemeList(0);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${f9323b45-e9db-3c09-8333-0159f1a7e27e}, hash:
//	// 6E224FF7CAB6BC07E50D213967EA1379
//	@Test()
//	void getSchemeListWhenSchemesIsNullAndCaughtException() throws Exception {
//		/*
//		 * Branches:* (schemes != null) : false* (catch-exception (Exception)) : true**
//		 * TODO: Help needed! This method is not unit testable!* Following variables
//		 * could not be isolated/mocked: output* Suggestions:* You can pass them as
//		 * constructor arguments or create a setter for them (avoid new operator)* or
//		 * adjust the input/test parameter values manually to satisfy the requirements
//		 * of the given test scenario.* The test code, including the assertion
//		 * statements, has been successfully generated.
//		 */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("A", Scheme.class);
//			doReturn(0).when(schemeMock).getProviderServiceMapID();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			doReturn(null).when(schemeServiceImplMock).getSchemeList(0);
//			// Act Statement(s)
//			String result = target.getSchemeList("A");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"statusCode\":5000,\"errorMessage\":\"No schemes available\",\"status\":\"No schemes available\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("A", Scheme.class);
//				verify(schemeMock).getProviderServiceMapID();
//				verify(schemeServiceImplMock).getSchemeList(0);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${ba838e5a-eb84-3ee8-9644-b82954189d08}, hash:
//	// FAF1296C8DE28ACFA2D505453C096621
//	@Test()
//	void deleteSchemeWhenSchemeIsNotNull() throws Exception {
//		/* Branches:* (scheme != null) : true */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("D", Scheme.class);
//			doReturn(0).when(schemeMock).getSchemeID();
//			doReturn(false).when(schemeMock).getDeleted();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			Scheme scheme = new Scheme();
//			scheme.setDeleted(false);
//			doReturn(scheme).when(schemeServiceImplMock).getSchemeByID(0);
//			doReturn("B").when(schemeServiceImplMock).deletedata(scheme);
//			// Act Statement(s)
//			String result = target.deleteScheme("D");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("D", Scheme.class);
//				verify(schemeMock).getSchemeID();
//				verify(schemeMock).getDeleted();
//				verify(schemeServiceImplMock).getSchemeByID(0);
//				verify(schemeServiceImplMock).deletedata(scheme);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${b4db4071-4bed-3431-b36a-7077ad0c5f28}, hash:
//	// 7F3ADE7E4B2D4CDAA06693D70A7047C6
//	@Test()
//	void deleteSchemeWhenSchemeIsNull() throws Exception {
//		/* Branches:* (scheme != null) : false */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("A", Scheme.class);
//			doReturn(0).when(schemeMock).getSchemeID();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			doReturn(null).when(schemeServiceImplMock).getSchemeByID(0);
//			// Act Statement(s)
//			String result = target.deleteScheme("A");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"statusCode\":5000,\"errorMessage\":\"No schemes available\",\"status\":\"No schemes available\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("A", Scheme.class);
//				verify(schemeMock).getSchemeID();
//				verify(schemeServiceImplMock).getSchemeByID(0);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${da85cac9-e3b4-32ed-b20a-86cdc7c83d7c}, hash:
//	// 43507C136BE84A4E6A3A10922DD7F202
//	@Test()
//	void deleteSchemeWhenCaughtException() throws Exception {
//		/*
//		 * Branches:* (scheme != null) : true* (catch-exception (Exception)) : true**
//		 * TODO: Help needed! This method is not unit testable!* Following variables
//		 * could not be isolated/mocked: output* Suggestions:* You can pass them as
//		 * constructor arguments or create a setter for them (avoid new operator)* or
//		 * adjust the input/test parameter values manually to satisfy the requirements
//		 * of the given test scenario.* The test code, including the assertion
//		 * statements, has been successfully generated.
//		 */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("G", Scheme.class);
//			doReturn(0).when(schemeMock).getSchemeID();
//			doReturn(false).when(schemeMock).getDeleted();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			Scheme scheme = new Scheme();
//			scheme.setDeleted(false);
//			doReturn(scheme).when(schemeServiceImplMock).getSchemeByID(0);
//			doReturn("B").when(schemeServiceImplMock).deletedata(scheme);
//			// Act Statement(s)
//			String result = target.deleteScheme("G");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("G", Scheme.class);
//				verify(schemeMock).getSchemeID();
//				verify(schemeMock).getDeleted();
//				verify(schemeServiceImplMock).getSchemeByID(0);
//				verify(schemeServiceImplMock).deletedata(scheme);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${68887bab-3bcf-3e73-8786-013fb42c45aa}, hash:
//	// 66140CD6C373DED6034F88032E781ED5
//	@Test()
//	void deleteSchemeWhenSchemeIsNullAndCaughtException() throws Exception {
//		/*
//		 * Branches:* (scheme != null) : false* (catch-exception (Exception)) : true**
//		 * TODO: Help needed! This method is not unit testable!* Following variables
//		 * could not be isolated/mocked: output* Suggestions:* You can pass them as
//		 * constructor arguments or create a setter for them (avoid new operator)* or
//		 * adjust the input/test parameter values manually to satisfy the requirements
//		 * of the given test scenario.* The test code, including the assertion
//		 * statements, has been successfully generated.
//		 */
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		Scheme schemeMock = mock(Scheme.class);
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(schemeMock).when(inputMapperMock).fromJson("A", Scheme.class);
//			doReturn(0).when(schemeMock).getSchemeID();
//			target = new SchemeController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			doReturn(null).when(schemeServiceImplMock).getSchemeByID(0);
//			// Act Statement(s)
//			String result = target.deleteScheme("A");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"statusCode\":5000,\"errorMessage\":\"No schemes available\",\"status\":\"No schemes available\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("A", Scheme.class);
//				verify(schemeMock).getSchemeID();
//				verify(schemeServiceImplMock).getSchemeByID(0);
//			});
//		}
//	}
//
//	@Test
//	void testSaveSchemeDetailsWithServiceException() throws Exception {
//		// Mocks setup
//		SchemeServiceImpl mockSchemeServiceImpl = mock(SchemeServiceImpl.class);
//		InputMapper mockInputMapper = mock(InputMapper.class);
//
//		// Simulating exception on service call
//		when(mockSchemeServiceImpl.save(any(Scheme.class)))
//				.thenThrow(new RuntimeException("Simulated ServiceException"));
//
//		// Test input
//		String requestJson = "{\"schemeName\":\"Test Scheme\"}";
//
//		// Execute
//		String response = target.saveSchemeDetails(requestJson);
//
//		// Verify and assert
//		assertTrue(response.contains("error")); // Assuming the response includes some error indication
//	}
//
//	@Test
//	void testGetSchemeListServiceException() throws Exception {
//		// Mock setup
//		SchemeServiceImpl mockSchemeServiceImpl = mock(SchemeServiceImpl.class);
//		Mapper mockMapper = mock(Mapper.class); // Assuming Mapper is your class for JSON operations
//
//		// Given
//		String requestJson = "{\"providerServiceMapID\": 1}";
//		Scheme mockScheme = new Scheme(); // Assuming Scheme is a valid class
//		mockScheme.setProviderServiceMapID(1);
//
//		// When
//		when(mockSchemeServiceImpl.getSchemeList(anyInt()))
//				.thenThrow(new RuntimeException("Simulated service exception"));
//
//		// Execute
//		String response = target.getSchemeList(requestJson);
//
//		// Then
//		assertTrue(response.contains("error")); // Asserting that the error is part of the response
//	}
//
//	@Test
//	void testDeleteSchemeServiceException() throws Exception {
//		// Mock setup
//		SchemeServiceImpl mockSchemeServiceImpl = mock(SchemeServiceImpl.class);
//		Mapper mockMapper = mock(Mapper.class); // Assuming Mapper is your class for handling JSON
//
//		// Preparing the input JSON
//		String requestJson = "{\"schemeID\":1,\"deleted\":true}";
//		Scheme mockScheme = new Scheme(); // Assuming Scheme is a valid class you have
//		mockScheme.setSchemeID(1);
//		mockScheme.setDeleted(true);
//
//		// Simulating an exception when calling getSchemeByID or deletedata
//		when(mockSchemeServiceImpl.getSchemeByID(anyInt()))
//				.thenThrow(new RuntimeException("Simulated service exception"));
//
//		// Execution
//		String response = target.deleteScheme(requestJson);
//
//		// Assertions
//		assertTrue(response.contains("error")); // Ensure the response indicates an error occurred
//	}
//}
