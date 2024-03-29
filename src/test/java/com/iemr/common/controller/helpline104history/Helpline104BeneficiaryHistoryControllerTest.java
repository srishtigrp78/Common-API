//package com.iemr.common.controller.helpline104history;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.iemr.common.service.helpline104history.H104BenHistoryServiceImpl;
//import com.iemr.common.utils.response.OutputResponse;
//
//import jakarta.ws.rs.NotFoundException;
//
//@ExtendWith(MockitoExtension.class)
//class Helpline104BeneficiaryHistoryControllerTest {
//
//	@InjectMocks
//	Helpline104BeneficiaryHistoryController helpline104BeneficiaryHistoryController;
//
//	@Mock
//	private H104BenHistoryServiceImpl smpleBenHistoryServiceImpl;
//
//	@Test
//	public void testGetBenCaseSheetSuccess() throws Exception {
//
//		String request = "{\"beneficiaryRegID\":\"123\"}";
//
//		OutputResponse output = new OutputResponse();
//
//		ArrayList<Object[]> smpleBenHistory = new ArrayList<>(); // Simulate your service layer response
//		when(smpleBenHistoryServiceImpl.geSmpleBenHistory(anyLong())).thenReturn(smpleBenHistory);
//
//		output.setResponse(smpleBenHistory.toString());
//
//		String expRes = helpline104BeneficiaryHistoryController.getBenCaseSheet(request);
//
//		assertEquals(output, expRes);
//	}
//
//	@Test
//	public void testGetBenCaseSheet_Exception() throws Exception {
//		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
//
//		when(smpleBenHistoryServiceImpl.geSmpleBenHistory(any()).toString()).thenThrow(NotFoundException.class);
//
//		String response = helpline104BeneficiaryHistoryController.getBenCaseSheet(request);
//		assertEquals(response, helpline104BeneficiaryHistoryController.getBenCaseSheet(request));
//	}
//
//}
