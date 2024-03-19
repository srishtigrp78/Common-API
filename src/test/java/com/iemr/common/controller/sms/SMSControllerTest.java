package com.iemr.common.controller.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.common.model.sms.SMSRequest;
import com.iemr.common.service.sms.SMSService;
import com.iemr.common.utils.mapper.InputMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class SMSControllerTest {
	
	@InjectMocks
	SMSController sMSController;
	
	@Mock
	SMSService smsService;
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Mock
	InputMapper inputMapper = new InputMapper();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testGetSMSTemplates() throws Exception, JsonProcessingException {
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		Map<String, Object> testResponseMap = new HashMap<>();
		testResponseMap.put("key1", "value1");
		testResponseMap.put("key2", "value2");
		String requestJson = objectMapper.createObjectNode().put("providerServiceMapID", 123).toString();
		SMSRequest request = objectMapper.readValue(requestJson, SMSRequest.class);
		String testResponse = objectMapper.writeValueAsString(testResponseMap);
		when(smsService.getSMSTemplates(Mockito.any())).thenReturn(testResponse);
		String result = sMSController.getSMSTemplates(request, serverRequest);
		JsonNode resultJson = objectMapper.readTree(result);
		JsonNode expData = objectMapper.readTree(testResponse);
		assertEquals(expData, resultJson.get("data"));
		verify(smsService, times(1)).getSMSTemplates(Mockito.any());
	}
	
	@Test
	void testGetSMSTemplatesException() throws Exception {
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		SMSRequest request = new SMSRequest();
		request.setProviderServiceMapID(123); // Set the required fields for the request
		when(smsService.getSMSTemplates(Mockito.any())).thenThrow(NotFoundException.class);
		String response = sMSController.getSMSTemplates(request, serverRequest);
		assertEquals(response, sMSController.getSMSTemplates(request, serverRequest));
	}

	@Test
	void testGetFullSMSTemplate() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveSMSTemplate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSMSTemplate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSMSTypes() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSMSParameters() {
		fail("Not yet implemented");
	}

	@Test
	void testSendSMS() {
		fail("Not yet implemented");
	}

}
