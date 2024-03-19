package com.iemr.common.controller.helpline104history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.common.data.helpline104history.H104BenMedHistory;
import com.iemr.common.service.helpline104history.H104BenHistoryServiceImpl;
import com.iemr.common.utils.response.OutputResponse;
@ExtendWith(MockitoExtension.class)
class Helpline104BeneficiaryHistoryControllerTest {
	
	@InjectMocks
	Helpline104BeneficiaryHistoryController helpline104BeneficiaryHistoryController;
	
	@Mock
	private H104BenHistoryServiceImpl smpleBenHistoryServiceImpl;

	@Test
	void testGetBenCaseSheet() {
		H104BenMedHistory smpleBenreq = new H104BenMedHistory();
		smpleBenreq.setBeneficiaryRegID(123L);
		Gson gson = new GsonBuilder().create();
		String request = gson.toJson(smpleBenreq);
		ArrayList<Object[]> smpleBenHistory = new ArrayList<>();
		when(smpleBenHistoryServiceImpl.geSmpleBenHistory(smpleBenreq.getBeneficiaryRegID())).thenReturn(smpleBenHistory);
		String result = helpline104BeneficiaryHistoryController.getBenCaseSheet(request);
		OutputResponse expectedOutput = new OutputResponse();
		expectedOutput.setResponse(smpleBenHistory.toString());
		assertEquals(expectedOutput.toString(), result);
		verify(smpleBenHistoryServiceImpl, times(1)).geSmpleBenHistory(smpleBenreq.getBeneficiaryRegID());
	}

}
