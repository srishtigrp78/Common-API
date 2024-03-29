package com.iemr.common.service.uptsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iemr.common.data.uptsu.FacilityMaster;
import com.iemr.common.data.uptsu.SmsRequestOBJ;
import com.iemr.common.repository.uptsu.FacilityMasterRepo;
import com.iemr.common.repository.uptsu.T_104AppointmentDetailsRepo;
import com.iemr.common.service.sms.SMSService;
@ExtendWith(MockitoExtension.class)
class UptsuServiceImplTest {

	@InjectMocks
	private UptsuServiceImpl uptsuService;

	@Mock
	private FacilityMasterRepo facilityMasterRepo;

	@Mock
	private T_104AppointmentDetailsRepo t_104AppointmentDetailsRepo;
	@Mock
	private SMSService smsService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetFacility() {
		Integer providerServiceMapID = 1;
		String blockname = "TestBlock";
		FacilityMaster facility1 = new FacilityMaster(); // Assuming FacilityMaster has a parameterless constructor
		facility1.setId(1); // Assuming there's a method to set an ID or relevant fields
		facility1.setBlockName(blockname);

		FacilityMaster facility2 = new FacilityMaster();
		facility2.setId(2);
		facility2.setBlockName(blockname);

		List<FacilityMaster> expectedFacilities = Arrays.asList(facility1, facility2);

		when(facilityMasterRepo.findByProviderServiceMapIDAndBlockNameAndDeleted(providerServiceMapID, blockname,
				false)).thenReturn(expectedFacilities);

		String result = uptsuService.getFacility(providerServiceMapID, blockname);

		assertEquals(new Gson().toJson(expectedFacilities), result,
				"The returned JSON does not match the expected JSON.");
	}

//	@Test
//	void testSaveAppointmentDetails() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testCreateSmsGateway() {
//		fail("Not yet implemented");
//	}

	@Test
	void testCreateSmsGateway() throws Exception {
		// Arrange
		// Assuming we have some dummy data to pass to the method
		String appointmentDate = "2024-03-17";
		String appointmentTime = "10:00 AM";
		String facilityPhoneNo = "1234567890";
		String choName = "Test CHO";
		String employeeCode = "EMP123";
		String beneficiaryName = "John Doe";
		Long beneficiaryId = 12345L;
		String facilityName = "Test Facility";
		String hfrId = "HFR123";
		String benPhoneNo = "0987654321";
		Long benRegId = 67890L;
		String Authorization = "Bearer someAuthToken";
		String createdBy = "TestUser";

		// Act
		uptsuService.createSmsGateway(appointmentDate, appointmentTime, facilityPhoneNo, choName, employeeCode,
				beneficiaryName, beneficiaryId, facilityName, hfrId, benPhoneNo, benRegId, Authorization, createdBy);

		// Assert
		// Verify that smsService.sendSMS was called twice (once for CHO and once for
		// the beneficiary)
		verify(smsService, times(2)).sendSMS(anyList(), eq(Authorization));
	}

//	@Test
//	void testCreateSMSRequestForCho() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCreateSMSRequestForBeneficiary() {
//		fail("Not yet implemented");
//	}

//	@Test
//	    public void testCreateSMSRequestForBeneficiary() {
//	        // Setup mocks
//	        String benSms = "benSms";
//	        String appointmentDate = "2022-01-01";
//	        String appointmentTime = "10:00";
//	        String benPhoneNo = "1234567890";
//	        String beneficiaryName = "John Doe";
//	        Long beneficiaryId = 123L;
//	        String facilityName = "Facility";
//	        String hfrId = "hfrId";
//	        Long benRegId = 456L;
//	        String createdBy = "User";
//	        SmsRequestOBJ objBen = new SmsRequestOBJ();
//
//	        // Setup return values for mock methods
//	        when(t_104AppointmentDetailsRepo.getSMSTypeIDBen(benSms)).thenReturn(1);
//	        when(t_104AppointmentDetailsRepo.getSMSTemplateIDBen(1)).thenReturn(1);
//
//	        // Call the method under test
//	        String response = uptsuService.createSMSRequestForBeneficiary(benSms, appointmentDate, appointmentTime, benPhoneNo, beneficiaryName, beneficiaryId, facilityName, hfrId, benRegId, createdBy);
//
//	        // Verify mocked method calls
//	        verify(t_104AppointmentDetailsRepo, times(1)).getSMSTypeIDBen(benSms);
//	        verify(t_104AppointmentDetailsRepo, times(1)).getSMSTemplateIDBen(1);
//
//	        // Convert the response to a list of SmsRequestOBJ objects
//	        List<SmsRequestOBJ> objList1 = new Gson().fromJson(response, new TypeToken<List<SmsRequestOBJ>>() {
//	        }.getType());
//
//	        // Assertions
//	        assertNotNull(objList1);
//	        assertEquals(1, objList1.size());
//	        assertEquals("templateId", objList1.get(0).getSmsTemplateID());
//	}

	@Mock
	private RestTemplate restTemplate;

//	@Test
//	void testRestTemplate() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testRestTemplate() {
//		// Mock response
//		String expectedResponse = "response";
//		when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class)))
//				.thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
//
//		// Test method call
//		String response = uptsuService.restTemplate(anyString(), anyString(), anyString());
//
//		// Verify that the exchange method was called correctly
//		verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class),
//				eq(String.class));
//
//		// Assert the response
//		assertEquals(expectedResponse, response);
//	}

}
