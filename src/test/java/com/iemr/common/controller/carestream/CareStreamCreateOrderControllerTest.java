package com.iemr.common.controller.carestream;

import static org.junit.jupiter.api.Assertions.fail;

import java.net.Socket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.carestream.CreateOrderData;
import com.iemr.common.utils.response.OutputResponse;
@ExtendWith(MockitoExtension.class)
class CareStreamCreateOrderControllerTest {
	
	@InjectMocks
	CareStreamCreateOrderController careStreamCreateOrderController;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private static final char END_OF_BLOCK = '\u001c';
	private static final char START_OF_BLOCK = '\u000b';
	private static final char CARRIAGE_RETURN = 13;
	
	private String carestreamSocketIP;
	private int carestreamSocketPort;

	@Test
	void testCreateOrder() {
		
		OutputResponse response = new OutputResponse();
		Socket socket = null;
		CreateOrderData benificiaryDetails = new CreateOrderData();
		benificiaryDetails.setFirstName("first name");
		benificiaryDetails.setMiddleName("mid name");
		benificiaryDetails.setLastName("last name");
		benificiaryDetails.setGender("female");
		benificiaryDetails.setDob("yyyy-MM-dd");
		benificiaryDetails.setPatientID("123");
		String createOrder = benificiaryDetails.toString();
	}

	@Test
	void testUpdateOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteOrder() {
		fail("Not yet implemented");
	}

}
