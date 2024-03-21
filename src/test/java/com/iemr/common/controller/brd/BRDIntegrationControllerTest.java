package com.iemr.common.controller.brd;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.service.brd.BRDIntegrationService;
import com.iemr.common.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class BRDIntegrationControllerTest {

	@InjectMocks
	BRDIntegrationController bRDIntegrationController;
	@Mock
	private BRDIntegrationService integrationService;
	@Mock
	private Logger logger = LoggerFactory.getLogger(BRDIntegrationController.class);

//	@Test
//	void testGetDetails() {
//		OutputResponse response = new OutputResponse();
//		String brdDetails = null;
//		String startDate = "start date";
//		String endDate = "end date";
//		String expResp = bRDIntegrationController.getDetails(brdDetails);
//		
//		try {
//			response.setResponse(expResp);
//		}catch (Exception e) {
//			logger.error("Error while getching BRD Integration data :" + e);
//			response.setError(5000, "Unable to get BRD data");
//		}
//		
//		Assertions.assertEquals(expResp, bRDIntegrationController.getDetails(brdDetails));
//	}


}
