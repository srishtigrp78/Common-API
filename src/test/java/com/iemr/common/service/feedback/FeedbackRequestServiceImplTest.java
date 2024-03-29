package com.iemr.common.service.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.repository.feedback.FeedbackRequestRepository;

@ExtendWith(MockitoExtension.class)
class FeedbackRequestServiceImplTest {

	@Mock
	private FeedbackRequestRepository feedbackRequestRepository;

	@InjectMocks
	private FeedbackRequestServiceImpl feedbackRequestService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetFeedbackRequest() {
		// Given
		Long feedbackRequestID = 1L;
		FeedbackRequest expectedFeedbackRequest = new FeedbackRequest();
		expectedFeedbackRequest.setFeedbackRequestID(feedbackRequestID);
		expectedFeedbackRequest.setFeedbackID(2L); // Additional properties as needed

		when(feedbackRequestRepository.findByFeedbackRequestID(feedbackRequestID)).thenReturn(expectedFeedbackRequest);

		// When
		FeedbackRequest result = feedbackRequestService.getFeedbackReuest(feedbackRequestID);

		// Then
		assertNotNull(result, "FeedbackRequest should not be null");
		assertEquals(expectedFeedbackRequest, result, "The returned FeedbackRequest does not match the expected");
		assertEquals(feedbackRequestID, result.getFeedbackRequestID(), "The FeedbackRequest ID does not match");

		// Verify the interaction with the mocked repository
		verify(feedbackRequestRepository, times(1)).findByFeedbackRequestID(feedbackRequestID);
	}

//	@Test
//	void testCreateFeedbackRequest() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testCreateFeedbackRequest() throws com.iemr.common.utils.exception.IEMRException {
//		// Given
//		String feedbackRequestJson = "{\"feedbackRequestID\":1,\"feedbackID\":2,\"comments\":\"Test comment\"}";
//		FeedbackRequest feedbackRequest = new FeedbackRequest();
//		feedbackRequest.setFeedbackRequestID(1L);
//		feedbackRequest.setFeedbackID(2L);
//		feedbackRequest.setComments("Test comment");
//
//		when(feedbackRequestRepository.save(any(FeedbackRequest.class))).thenReturn(feedbackRequest);
//
//		// When
//		String result = feedbackRequestService.createFeedbackRequest(feedbackRequestJson);
//
//		// Then
//		String expectedString = feedbackRequest.toString();
//		assertEquals(expectedString, result, "The returned string does not match the expected output");
//	}

//	@Test
//	void testGetAllFeedback() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetAllFeedbackSimple() throws IEMRException {
//		// Setup mock data
//		EmailStatus emailStatus = new EmailStatus();
//		emailStatus.setEmailStatusID(1);
//		emailStatus.setEmailStatus("Processed");
//
//		List<Object[]> mockData = new ArrayList<>();
//		mockData.add(new Object[] { 1L, 123L, "Summary", 1, "Comments", 1, emailStatus });
//
//		when(feedbackRequestRepository.getAllFeedback(anyLong())).thenReturn((ArrayList<Object[]>) mockData);
//
//		// Call the method to test
//		String feedbackRequestJson = "{\"feedbackID\":123}"; // Assuming this is how you're passing parameters
//		String result = feedbackRequestService.getAllFeedback(feedbackRequestJson);
//
//		assertNotNull(result, "The result should not be null");
//	}
}
