//package com.iemr.common.controller.secondaryReport;
//
//import com.iemr.common.data.report.CallQualityReport;
//import com.iemr.common.service.reportSecondary.SecondaryReportService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//
//import java.io.ByteArrayInputStream;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class CustomerRelationshipSecondaryReportsTest2 {
//
//	@Mock
//	private SecondaryReportService mockSecondaryReportService;
//
//	@InjectMocks
//	private CustomerRelationshipSecondaryReports customerRelationshipSecondaryReportsUnderTest;
//
//	@Test
//	void testGetQualityReport() throws Exception {
//		// Setup
//		// Configure SecondaryReportService.getQualityReport(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getQualityReport("{\"int\": \"123\"}", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getQualityReport("{\"int\": \"123\"}");
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//
//	@Test
//	void testGetQualityReport_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		when(mockSecondaryReportService.getQualityReport("jsonRequest", "filename")).thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getQualityReport("jsonRequest");
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetComplaintDetailReport() throws Exception {
//		// Setup
//		// Configure SecondaryReportService.getComplaintDetailReport(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getComplaintDetailReport("jsonRequest", "Grievance_Details"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getComplaintDetailReport("jsonRequest");
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetComplaintDetailReport_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		when(mockSecondaryReportService.getComplaintDetailReport("jsonRequest", "Grievance_Details"))
//				.thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getComplaintDetailReport("jsonRequest");
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetCallSummaryReport() throws Exception {
//		// Setup
//		// Configure SecondaryReportService.getCallSummaryReport(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getCallSummaryReport("jsonRequest", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getCallSummaryReport("jsonRequest");
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetCallSummaryReport_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		when(mockSecondaryReportService.getCallSummaryReport("jsonRequest", "filename")).thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getCallSummaryReport("jsonRequest");
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetAllBySexualOrientation() throws Exception {
//		// Setup
//		// Configure SecondaryReportService.getAllBySexualOrientationReport(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getAllBySexualOrientationReport("jsonRequest", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllBySexualOrientation("jsonRequest");
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetAllBySexualOrientation_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		when(mockSecondaryReportService.getAllBySexualOrientationReport("jsonRequest", "filename"))
//				.thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllBySexualOrientation("jsonRequest");
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetDistrictWiseCallReport() throws Exception {
//		// Setup
//		// Configure SecondaryReportService.getDistrictWiseCallReport(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getDistrictWiseCallReport("jsonRequest", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getDistrictWiseCallReport("jsonRequest");
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetDistrictWiseCallReport_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		when(mockSecondaryReportService.getDistrictWiseCallReport("jsonRequest", "filename"))
//				.thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getDistrictWiseCallReport("jsonRequest");
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetUnblockedUserReport() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//		// Configure SecondaryReportService.getUnblockedUserReport(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getUnblockedUserReport("jsonRequest", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getUnblockedUserReport("jsonRequest", httpRequest);
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetUnblockedUserReport_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//		when(mockSecondaryReportService.getUnblockedUserReport("jsonRequest", "filename")).thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getUnblockedUserReport("jsonRequest", httpRequest);
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetCallQualityReport() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//		// Configure SecondaryReportService.getCallQualityReport(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		final CallQualityReport callQualityReport = new CallQualityReport();
//		callQualityReport.setFactBenCallID(0L);
//		callQualityReport.setBenCallID(0L);
//		callQualityReport.setBeneficiaryRegID(0L);
//		callQualityReport.setCallTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
//		callQualityReport.setFileName("fileName");
//		when(mockSecondaryReportService.getCallQualityReport(callQualityReport, "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getCallQualityReport("jsonRequest", httpRequest);
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetCallQualityReport_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//		// Configure SecondaryReportService.getCallQualityReport(...).
//		final CallQualityReport callQualityReport = new CallQualityReport();
//		callQualityReport.setFactBenCallID(0L);
//		callQualityReport.setBenCallID(0L);
//		callQualityReport.setBeneficiaryRegID(0L);
//		callQualityReport.setCallTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
//		callQualityReport.setFileName("fileName");
//		when(mockSecondaryReportService.getCallQualityReport(callQualityReport, "filename")).thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getCallQualityReport("jsonRequest", httpRequest);
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetCountsByPreferredLanguage() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//		// Configure SecondaryReportService.getCountsByPrefferedLanguage(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getCountsByPrefferedLanguage("jsonRequest", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getCountsByPreferredLanguage("jsonRequest", httpRequest);
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetCountsByPreferredLanguage_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//		when(mockSecondaryReportService.getCountsByPrefferedLanguage("jsonRequest", "filename"))
//				.thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getCountsByPreferredLanguage("jsonRequest", httpRequest);
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetAllByAgeGroup() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//		// Configure SecondaryReportService.getAllByAgeGroup(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getAllByAgeGroup("jsonRequest", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllByAgeGroup("jsonRequest", httpRequest);
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetAllByAgeGroup_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//		when(mockSecondaryReportService.getAllByAgeGroup("jsonRequest", "filename")).thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllByAgeGroup("jsonRequest", httpRequest);
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetAllReportsByDate() throws Exception {
//		// Setup
//		// Configure SecondaryReportService.getAllReportsByDate(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getAllReportsByDate("jsonRequest", "filename"))
//				.thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllReportsByDate("jsonRequest");
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetAllReportsByDate_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		when(mockSecondaryReportService.getAllReportsByDate("jsonRequest", "filename")).thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllReportsByDate("jsonRequest");
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetAllByGender() throws Exception {
//		// Setup
//		// Configure SecondaryReportService.getAllByGender(...).
//		final ByteArrayInputStream spyByteArrayInputStream = spy(new ByteArrayInputStream("arrayContent".getBytes()));
//		when(mockSecondaryReportService.getAllByGender("jsonRequest", "filename")).thenReturn(spyByteArrayInputStream);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllByGender("jsonRequest");
//
//		// Verify the results
//		verify(spyByteArrayInputStream).close();
//	}
//
//	@Test
//	void testGetAllByGender_SecondaryReportServiceThrowsException() throws Exception {
//		// Setup
//		when(mockSecondaryReportService.getAllByGender("jsonRequest", "filename")).thenThrow(Exception.class);
//
//		// Run the test
//		final ResponseEntity<Object> result = customerRelationshipSecondaryReportsUnderTest
//				.getAllByGender("jsonRequest");
//
//		// Verify the results
//	}
//
//	@Test
//	void testGetFileName() {
//		// Setup
//		// Run the test
//		final String result = customerRelationshipSecondaryReportsUnderTest.getFileName("jsonRequest", "name");
//
//		// Verify the results
//		assertEquals("name", result);
//	}
//}
