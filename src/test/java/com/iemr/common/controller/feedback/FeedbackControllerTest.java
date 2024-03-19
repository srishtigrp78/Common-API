package com.iemr.common.controller.feedback;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.data.feedback.FeedbackResponse;
import com.iemr.common.service.feedback.FeedbackRequestService;
import com.iemr.common.service.feedback.FeedbackResponseService;
import com.iemr.common.service.feedback.FeedbackService;
import com.iemr.common.service.feedback.FeedbackTypeService;

import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;
@ExtendWith(MockitoExtension.class)
class FeedbackControllerTest {
	
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Mock
	private FeedbackService feedbackService;
	@InjectMocks
	FeedbackController feedbackController;
	@Mock
	private FeedbackTypeService feedbackTypeService;
	@Mock
	private FeedbackResponseService feedbackResponseService;
	@Mock
	private FeedbackRequestService feedbackRequestService;


	@Test
	void testFeedbackRequest() {

		OutputResponse response = new OutputResponse();
		FeedbackDetails feedbackDetails = new FeedbackDetails();
		feedbackDetails.setBenCallID(1234L);
		feedbackDetails.setBeneficiaryName("ben name");
		feedbackDetails.setBeneficiaryRegID(5432L);
		feedbackDetails.setBlockID(123);
		feedbackDetails.setCategoryID(54);
		feedbackDetails.setCreatedBy("created by");
		feedbackDetails.setCreatedDate(Timestamp.from(Instant.now()));
		feedbackDetails.setDeleted(false);
		feedbackDetails.setDesignationID(32);
		feedbackDetails.setDesignationName("designation name");
		feedbackDetails.setDistrictBranchID(54);
		feedbackDetails.setDistrictID(65);
		feedbackDetails.setEmailStatusID(87);
		feedbackDetails.setEmailStatusName("email sttus name");
		feedbackDetails.setEndDate(Timestamp.from(Instant.now()));
		feedbackDetails.setFeedback("feedback");
		feedbackDetails.setFeedbackAgainst("feedback against");
		feedbackDetails.setFeedbackID(76L);
		feedbackDetails.setFeedbackNatureID(876);
		feedbackDetails.setInstituteName("institute name");
		feedbackDetails.setInstiName("insit name");
		feedbackDetails.setInstituteTypeID(54);
		feedbackDetails.setServiceID(85);
		feedbackDetails.setRequestID("76");
		feedbackDetails.setServiceID(764);
		feedbackDetails.setServiceName("service name");
		feedbackDetails.setsMSPhoneNo("sms ph no");
		feedbackDetails.setUserName("user name");
		FeedbackRequest feedbackRequest = new FeedbackRequest();
		feedbackRequest.setDeleted(false);
		List<FeedbackRequest> feedbackRequests = new ArrayList<FeedbackRequest>();
		feedbackRequests.add(feedbackRequest);
		feedbackDetails.setFeedbackRequests(feedbackRequests);
		FeedbackResponse feedbackResponse = new FeedbackResponse();
		feedbackResponse.setAuthUserID(123);
		List<FeedbackResponse> feedbackResponses = new ArrayList<FeedbackResponse>();
		feedbackResponses.add(feedbackResponse);
		feedbackDetails.setFeedbackResponses(feedbackResponses);
		List<FeedbackDetails> feedbackList = new ArrayList<FeedbackDetails>();
		feedbackList.add(feedbackDetails);
		feedbackDetails.toString();
		String request = feedbackList.toString();
//		when(feedbackService.getFeedbackRequests(feedbackDetails.getBeneficiaryRegID())).thenReturn(feedbackList);
//		response.setResponse(request);
//		String result = feedbackController.feedbackRequest(request);
//		assertEquals(response.toString(), result);
	
	}
	

	@Test
	void testGetFeedbackByPost() {
		Long feedbackID = 123L;
		FeedbackDetails feedbackDetails = new FeedbackDetails();
		List<FeedbackDetails> savedDetails = new ArrayList<>();
		savedDetails.add(feedbackDetails);
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setResponse(savedDetails.toString());
		when(feedbackService.getFeedbackRequests(feedbackID)).thenReturn(savedDetails);
		String result = feedbackController.getFeedbackByPost(feedbackID);
		assertEquals(expectedResponse.toString(), result);
	}
	
	@Test
	void testGetFeedbackByPost_CatchBlock() {
		Long feedbackID = null;
		when(feedbackService.getFeedbackRequests(feedbackID)).thenThrow(NotFoundException.class);
		String response = feedbackController.getFeedbackByPost(feedbackID);
		assertEquals(response, feedbackController.getFeedbackByPost(feedbackID));
	}

	@Test
	void testCreateFeedback() throws Exception {
		OutputResponse response = new OutputResponse();
		FeedbackDetails feedbackDetail = new FeedbackDetails();
		feedbackDetail.setBenCallID(1234L);
		feedbackDetail.setBeneficiaryName("ben name");
		feedbackDetail.setBeneficiaryRegID(5432L);
		feedbackDetail.setBlockID(123);
		feedbackDetail.setCategoryID(54);
		feedbackDetail.setCreatedBy("created by");
		feedbackDetail.setCreatedDate(Timestamp.from(Instant.now()));
		feedbackDetail.setDeleted(false);
		feedbackDetail.setDesignationID(32);
		feedbackDetail.setDesignationName("designation name");
		feedbackDetail.setDistrictBranchID(54);
		feedbackDetail.setDistrictID(65);
		feedbackDetail.setEmailStatusID(87);
		feedbackDetail.setEmailStatusName("email sttus name");
		feedbackDetail.setEndDate(Timestamp.from(Instant.now()));
		feedbackDetail.setFeedback("feedback");
		feedbackDetail.setFeedbackAgainst("feedback against");
		feedbackDetail.setFeedbackID(76L);
		feedbackDetail.setFeedbackNatureID(876);
		feedbackDetail.setInstituteName("institute name");
		feedbackDetail.setInstiName("insit name");
		feedbackDetail.setInstituteTypeID(54);
		feedbackDetail.setServiceID(85);
		feedbackDetail.setRequestID("76");
		feedbackDetail.setServiceID(764);
		feedbackDetail.setServiceName("service name");
		feedbackDetail.setsMSPhoneNo("sms ph no");
		feedbackDetail.setUserName("user name");
		FeedbackRequest feedbackRequest = new FeedbackRequest();
		feedbackRequest.setDeleted(false);
		List<FeedbackRequest> feedbackRequests = new ArrayList<FeedbackRequest>();
		feedbackRequests.add(feedbackRequest);
		feedbackDetail.setFeedbackRequests(feedbackRequests);
		FeedbackResponse feedbackResponse = new FeedbackResponse();
		feedbackResponse.setAuthUserID(123);
		List<FeedbackResponse> feedbackResponses = new ArrayList<FeedbackResponse>();
		feedbackResponses.add(feedbackResponse);
		feedbackDetail.setFeedbackResponses(feedbackResponses);
		String feedbackDetails = feedbackDetail.toString();
		when(feedbackService.saveFeedback(feedbackDetails)).thenReturn(feedbackDetails);
		response.setResponse(feedbackDetails.toString());
		assertEquals(response.toString(), feedbackController.createFeedback(feedbackDetails));
	}
	
	@Test
	void testCreateFeedback_CatchBlock() throws Exception {
		String feedbackDetails = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(feedbackService.saveFeedback(feedbackDetails)).thenThrow(NotFoundException.class);
		String response = feedbackController.createFeedback(feedbackDetails);
		assertEquals(response, feedbackController.createFeedback(feedbackDetails));
	}

	@Test
	void testFeedbacksList() {
	}

	@Test
	void testGetFeedback() throws Exception {
		OutputResponse response = new OutputResponse();
		FeedbackDetails feedbackDetails = new FeedbackDetails();
		feedbackDetails.setBenCallID(1234L);
		feedbackDetails.setBeneficiaryName("ben name");
		feedbackDetails.setBeneficiaryRegID(5432L);
		feedbackDetails.setBlockID(123);
		feedbackDetails.setCategoryID(54);
		feedbackDetails.setCreatedBy("created by");
		feedbackDetails.setCreatedDate(Timestamp.from(Instant.now()));
		feedbackDetails.setDeleted(false);
		feedbackDetails.setDesignationID(32);
		feedbackDetails.setDesignationName("designation name");
		feedbackDetails.setDistrictBranchID(54);
		feedbackDetails.setDistrictID(65);
		feedbackDetails.setEmailStatusID(87);
		feedbackDetails.setEmailStatusName("email sttus name");
		feedbackDetails.setEndDate(Timestamp.from(Instant.now()));
		feedbackDetails.setFeedback("feedback");
		feedbackDetails.setFeedbackAgainst("feedback against");
		feedbackDetails.setFeedbackID(76L);
		feedbackDetails.setFeedbackNatureID(876);
		feedbackDetails.setInstituteName("institute name");
		feedbackDetails.setInstiName("insit name");
		feedbackDetails.setInstituteTypeID(54);
		feedbackDetails.setServiceID(85);
		feedbackDetails.setRequestID("76");
		feedbackDetails.setServiceID(764);
		feedbackDetails.setServiceName("service name");
		feedbackDetails.setsMSPhoneNo("sms ph no");
		feedbackDetails.setUserName("user name");
		FeedbackRequest feedbackRequest1 = new FeedbackRequest();
		feedbackRequest1.setDeleted(false);
		List<FeedbackRequest> feedbackRequests = new ArrayList<FeedbackRequest>();
		feedbackRequests.add(feedbackRequest1);
		feedbackDetails.setFeedbackRequests(feedbackRequests);
		FeedbackResponse feedbackResponse = new FeedbackResponse();
		feedbackResponse.setAuthUserID(123);
		List<FeedbackResponse> feedbackResponses = new ArrayList<FeedbackResponse>();
		feedbackResponses.add(feedbackResponse);
		feedbackDetails.setFeedbackResponses(feedbackResponses);
		List<FeedbackDetails> feedbackList = new ArrayList<FeedbackDetails>();
		feedbackList.add(feedbackDetails);
		feedbackDetails.toString();
		String feedbackRequest = feedbackDetails.toString();
		when(feedbackService.getAllData(feedbackRequest)).thenReturn(feedbackRequest);
		response.setResponse(feedbackRequest.toString());
		assertEquals(response.toString(), feedbackController.getFeedback(feedbackRequest));
	}
	
	@Test
	void testGetFeedback_CatchBlock() throws Exception {
		String feedbackRequest = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(feedbackService.getAllData(feedbackRequest)).thenThrow(NotFoundException.class);
		String response = feedbackController.getFeedback(feedbackRequest);
		assertEquals(response, feedbackController.getFeedback(feedbackRequest));
	}

	@Test
	void testUpdateFeedback() throws Exception {
		OutputResponse response = new OutputResponse();
		FeedbackDetails feedbackDetail = new FeedbackDetails();
		feedbackDetail.setBenCallID(1234L);
		feedbackDetail.setBeneficiaryName("ben name");
		String feedbackDetails = feedbackDetail.toString();
		Integer severityID = 123;
		when(feedbackService.updateFeedback(feedbackDetails)).thenReturn(severityID);
		response.setResponse(severityID.toString());
		assertEquals(response.toString(), feedbackController.updateFeedback(feedbackDetails));
	}
	
	@Test
	void testUpdateFeedback_CatchBlock() throws Exception {
		String feedbackDetails = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(feedbackService.updateFeedback(feedbackDetails)).thenThrow(NotFoundException.class);
		String response = feedbackController.updateFeedback(feedbackDetails);
		assertEquals(response, feedbackController.updateFeedback(feedbackDetails));
	}

	@Test
	void testUpdateFeedbackStatus() throws Exception {
		OutputResponse response = new OutputResponse();
		FeedbackDetails feedbackDetail = new FeedbackDetails();
		feedbackDetail.setBenCallID(1234L);
		feedbackDetail.setBeneficiaryName("ben name");
		String feedbackDetails = feedbackDetail.toString();
		when(feedbackService.updateFeedbackStatus(feedbackDetails)).thenReturn(feedbackDetails);
		response.setResponse(feedbackDetails.toString());
		assertEquals(response.toString(), feedbackController.updateFeedbackStatus(feedbackDetails));
	}
	
	@Test
	void testUpdateFeedbackStatus_CatchBlock() throws Exception {
		String feedbackDetails = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(feedbackService.updateFeedbackStatus(feedbackDetails)).thenThrow(NotFoundException.class);
		String response = feedbackController.updateFeedbackStatus(feedbackDetails);
		assertEquals(response, feedbackController.updateFeedbackStatus(feedbackDetails));
	}

	@Test
	void testSearchFeedback() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchFeedback1() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllFeedbackById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllfeedback() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedbackStatusTypes() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmailStatus() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedbackRequestById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedbackResponseById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedbacksList() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateResponse() {
		fail("Not yet implemented");
	}

	@Test
	void testRequestFeedback() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFeedbackSeverityService() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedbackSeverity() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedbackType() {
		fail("Not yet implemented");
	}

	@Test
	void testGetGrievancesByCreatedDate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetGrievancesByUpdatedDate() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateFeedbackRequest() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedbackLogs() {
		fail("Not yet implemented");
	}

}
