package com.iemr.common.service.mctshistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.mctshistory.MctsCallResponseDetail;
import com.iemr.common.data.mctshistory.MctsOutboundCallDetail;
import com.iemr.common.repository.mctshistory.OutboundHistoryRepository;
import com.iemr.common.repository.mctshistory.OutboundResponseRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@ExtendWith(MockitoExtension.class)
class OutboundHistoryServiceImplTest {

	@Mock
	private OutboundHistoryRepository outboundHistoryRepository;

	@Mock
	private OutboundResponseRepository outboundResponseRepository;

	@Mock
	private InputMapper inputMapper; // Assuming this is a mockable dependency

	@InjectMocks
	private OutboundHistoryServiceImpl outboundHistoryService;

//	@Test
//	void testGetCallHistory() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void getCallHistoryTest() throws Exception {
//		String request = "";
//
//		List<MctsOutboundCallDetail> mctsOutboundCallDetails = new ArrayList<MctsOutboundCallDetail>();
//
//		MctsOutboundCallDetail callDetail = new MctsOutboundCallDetail();
//		callDetail.setCallDetailID(1L);
//		callDetail.setObCallID(1L);
//		callDetail.setAllocatedUserID(1);
//		callDetail.setBeneficiaryRegID(1L);
//		callDetail.setCallTypeID(1);
//		callDetail.setRemark("test");
//		callDetail.setSmsAdvice("test");
//		callDetail.setCallTime(Timestamp.valueOf("2024-01-01 00:00:00"));
//		callDetail.setIsMother(true);
//
//		mctsOutboundCallDetails.add(callDetail);
//
//		when(outboundHistoryRepository.getCallHistory(callDetail.getBeneficiaryRegID()))
//				.thenReturn((ArrayList<MctsOutboundCallDetail>) mctsOutboundCallDetails);
//
//		assertEquals(mctsOutboundCallDetails.toString(), outboundHistoryService.getCallHistory(request));
//
//	}

//	@Test
//	void getCallHistoryTest() throws IEMRException, Exception {
//		// Prepare the request as a JSON string, mirroring how the method expects to
//		// receive the parameter
//		MctsOutboundCallDetail inputCallDetail = new MctsOutboundCallDetail();
//		inputCallDetail.setBeneficiaryRegID(1L); // Assuming this is the key piece of information needed
//		Gson gson = new Gson();
//		String request = gson.toJson(inputCallDetail);
//
//		// Prepare the expected result
//		List<MctsOutboundCallDetail> expectedCallDetails = new ArrayList<>();
//		MctsOutboundCallDetail callDetail = new MctsOutboundCallDetail();
//		callDetail.setCallDetailID(1L);
//		callDetail.setObCallID(1L);
//		callDetail.setAllocatedUserID(1);
//		callDetail.setBeneficiaryRegID(1L);
//		callDetail.setCallTypeID(1);
//		callDetail.setRemark("test");
//		callDetail.setSmsAdvice("test");
//		callDetail.setCallTime(Timestamp.valueOf("2024-01-01 00:00:00")); // Correcting the timestamp format
//		callDetail.setIsMother(true);
//
//		expectedCallDetails.add(callDetail);
//
//		// Setup the mock behavior
//		when(outboundHistoryRepository.getCallHistory(inputCallDetail.getBeneficiaryRegID()))
//				.thenReturn((ArrayList<MctsOutboundCallDetail>) expectedCallDetails);
//
//		// Execute the method under test
//		String result = OutboundHistoryService.getCallHistory(request);
//
//		// Verify the output
//		assertEquals(gson.toJson(expectedCallDetails), result,
//				"The returned call history does not match the expected output.");
//	}

//	@Test
//	void testGetMctsCallResponse() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetMctsCallResponse() throws com.iemr.common.utils.exception.IEMRException {
//		
//		String request = "";
//		
//		MctsOutboundCallDetail callDetail =  new MctsOutboundCallDetail();
//		
//		List<MctsCallResponseDetail> callResponseDetails = new ArrayList<MctsCallResponseDetail>();
//		
//		callResponseDetails = outboundResponseRepository.getMctsCallResponse(callDetail.getCallDetailID());
//		
//		assertEquals(callResponseDetails , outboundHistoryService.getMctsCallResponse(request) );
//	}

//	@Test
//	void testGetMctsCallResponse() throws Exception {
//		// Prepare test data
//		String request = "{\"callDetailID\":\"1\"}";
//		MctsOutboundCallDetail callDetail = new MctsOutboundCallDetail();
//		callDetail.setCallDetailID(1L);
//
//		List<MctsCallResponseDetail> mockResponseDetails = new ArrayList<>();
//		// Populate mockResponseDetails as needed for your test
//
//		// Configure mock behavior
//		//when(inputMapper.gson().fromJson(anyString(), eq(MctsOutboundCallDetail.class))).thenReturn(callDetail);
//		when(outboundResponseRepository.getMctsCallResponse(anyLong())).thenReturn((ArrayList<MctsCallResponseDetail>) mockResponseDetails);
//
//		// Expected result (considering toString() method provides a suitable
//		// representation of mockResponseDetails)
//		String expectedResult = mockResponseDetails.toString();
//
//		// Execute
//		String actualResult = outboundHistoryService.getMctsCallResponse(request);
//
//		// Verify
//		assertEquals(expectedResult, actualResult);
//		// Optionally verify that your mocks were called as expected
////		verify(inputMapper.gson(), times(1)).fromJson(anyString(), eq(MctsOutboundCallDetail.class));
////		verify(outboundResponseRepository, times(1)).getMctsCallResponse(1L);
//	}
}
