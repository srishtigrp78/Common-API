package com.iemr.common.covidVaccination;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.iemr.common.utils.exception.IEMRException;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(SpringExtension.class)
public class CovidVaccinationControllerTest {

	@Mock
	private CovidVaccinationService covidVaccinationService;

	@InjectMocks
	private CovidVaccinationController covidVaccinationController;

	@BeforeEach
	void setUp() {
		// Initialization, if needed
	}

	@Test
	void getVaccinationTypeAndDoseTaken_Success() throws Exception {
		// Arrange
		when(covidVaccinationService.getVaccinationTypeAndDoseTaken()).thenReturn("ExpectedResponse");

		// Act
		String response = covidVaccinationController.getVaccinationTypeAndDoseTaken("AuthorizationDummyValue");

		// Assert
		assertTrue(response.contains("Success"));
	}

	@Test
	void getVaccinationTypeAndDoseTaken_ThrowsException() throws IEMRException {
		// Arrange
		when(covidVaccinationService.getVaccinationTypeAndDoseTaken())
				.thenThrow(new RuntimeException("Error occurred"));

		// Act
		String response = covidVaccinationController.getVaccinationTypeAndDoseTaken("AuthorizationDummyValue");

		assertTrue(response.contains("Error"));
	}

	@Test
	void getCovidVaccinationDetails_Success() throws Exception {
		// Arrange
		CovidVaccinationStatus validCovidVaccinationStatus = new CovidVaccinationStatus();
		validCovidVaccinationStatus.setBeneficiaryRegID(123L);

		when(covidVaccinationService.getCovidVaccinationDetails(anyLong())).thenReturn("VaccinationDetails");

		// Act
		String response = covidVaccinationController.getCovidVaccinationDetails(validCovidVaccinationStatus,
				"AuthorizationToken");

		// Assert
		assertNotNull(response);
		assertTrue(response.contains("VaccinationDetails"));
	}

	@Test
	void getCovidVaccinationDetails_InvalidBeneficiaryId() {
		// Arrange
		CovidVaccinationStatus invalidCovidVaccinationStatus = new CovidVaccinationStatus();
		// Simulating invalid input by not setting beneficiaryRegID

		// Act
		String response = covidVaccinationController.getCovidVaccinationDetails(invalidCovidVaccinationStatus,
				"AuthorizationToken");

		// Assert
		assertNotNull(response);
		assertTrue(response.contains("Invalid beneficiary Id")
				|| response.contains("Error in getting beneficiary vaccination details"));
	}

	@Test
	void getCovidVaccinationDetails_ExceptionThrown() throws Exception {
		// Arrange
		CovidVaccinationStatus covidVaccinationStatus = new CovidVaccinationStatus();
		covidVaccinationStatus.setBeneficiaryRegID(123L);

		when(covidVaccinationService.getCovidVaccinationDetails(anyLong())).thenThrow(NotFoundException.class);

		// Act
		String response = covidVaccinationController.getCovidVaccinationDetails(covidVaccinationStatus,
				"AuthorizationToken");

		System.out.println(response);

		// Assert
		assertTrue(response.contains("5000"));
	}

	@Test
	void getCovidVaccinationDetails_ErrorInGettingDetails() throws Exception {
		// Arrange
		Long validBeneficiaryRegID = 123L; // Assume this is a valid ID for the purpose of this test
		CovidVaccinationStatus status = new CovidVaccinationStatus();
		status.setBeneficiaryRegID(validBeneficiaryRegID);

		// Mocking the service to return null to simulate the condition where details
		// cannot be retrieved
		when(covidVaccinationService.getCovidVaccinationDetails(anyLong())).thenReturn(null);

		// Act
		String response = covidVaccinationController.getCovidVaccinationDetails(status, "AuthorizationToken");

		// Assert
		assertTrue(response.contains("Error in getting beneficiary vaccination details"));
	}

	@Test
	void saveCovidVaccinationDetails_RequestIsNull() {
		// Arrange
		String request = null;

		// Act
		String response = covidVaccinationController.saveCovidVaccinationDetails(request, "AuthorizationToken");

		// Assert
		assertTrue(response.contains("Empty / null request object"));
	}

	@Test
	void saveCovidVaccinationDetails_ServiceSavesSuccessfully() throws Exception {
		// Arrange
		String request = "{\"beneficiaryRegID\":123}";
		String expectedResponse = "Covid vaccination details saved successfully";
		when(covidVaccinationService.saveBenCovidVaccinationDetails(anyString())).thenReturn(expectedResponse);

		// Act
		String response = covidVaccinationController.saveCovidVaccinationDetails(request, "AuthorizationToken");

		// Assert
		assertTrue(response.contains(expectedResponse));
	}

	@Test
	void saveCovidVaccinationDetails_ServiceFailsToSave() throws Exception {
		// Arrange
		String request = "{\"beneficiaryRegID\":123}";
		when(covidVaccinationService.saveBenCovidVaccinationDetails(anyString()))
				.thenThrow(new IEMRException("Error in saving covid vaccination details"));

		// Act
		String response = covidVaccinationController.saveCovidVaccinationDetails(request, "AuthorizationToken");

		// Assert
		assertTrue(response.contains("Error in saving covid vaccination details"));
	}

	@Test
	void saveCovidVaccinationDetails_ServiceFailsToSave1() throws IEMRException {
		// Arrange
		String request = "{\"beneficiaryRegID\":123}";
		String errorMessage = "Error in saving covid vaccination details";
		when(covidVaccinationService.saveBenCovidVaccinationDetails(anyString()))
				.thenThrow(new RuntimeException(errorMessage));

		// Act
		String response = covidVaccinationController.saveCovidVaccinationDetails(request, "AuthorizationToken");

		// Assert
		assertTrue(response.contains(errorMessage), "Response should contain the error message.");
	}

	@Test
	void saveCovidVaccinationDetails_ThrowsIEMRException() throws IEMRException {
		// Setup
		String requestJson = "{\"covidVSID\": \"1\",\"beneficiaryRegID\":\"2\"," + "\"CovidVaccineTypeID\":\"1\","
				+ "\"ProviderServiceMapID\":\"1\",\"CreatedBy\":\"User\"," + "\"ModifiedBy\":\"User\",\"VanID\":\"1\"}";
		String authorizationToken = "Bearer validToken";
		String expectedErrorMessage = "Error in saving covid vaccination details";

		// Mock behavior to simulate throwing IEMRException when service method is
		// called
		doThrow(new IEMRException(expectedErrorMessage)).when(covidVaccinationService)
				.saveBenCovidVaccinationDetails(anyString());

		// Execute the controller method
		String response = covidVaccinationController.saveCovidVaccinationDetails(requestJson, authorizationToken);

		// Assert that the response contains the expected error message
		assertTrue(response.contains(expectedErrorMessage), "The response should contain the expected error message.");
	}
}
