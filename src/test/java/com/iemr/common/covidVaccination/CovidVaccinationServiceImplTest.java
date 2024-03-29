package com.iemr.common.covidVaccination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.iemr.common.utils.exception.IEMRException;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class CovidVaccinationServiceImplTest {

	private final CovidVaccineTypeRepo covidVaccineTypeRepoMock = mock(CovidVaccineTypeRepo.class,
			"covidVaccineTypeRepo");

	private final CovidDoseTypeRepo covidDoseTypeRepoMock = mock(CovidDoseTypeRepo.class, "covidDoseTypeRepo");

	private final CovidVaccinationRepo covidVaccinationRepoMock = mock(CovidVaccinationRepo.class,
			"covidVaccinationRepo");

	private AutoCloseable autoCloseableMocks;

	@InjectMocks()
	private CovidVaccinationServiceImpl target;

	@AfterEach()
	public void afterTest() throws Exception {
		if (autoCloseableMocks != null)
			autoCloseableMocks.close();
	}

	@Test
	void getVaccinationTypeAndDoseTaken_ReturnsCorrectData() {
		// Given
		List<CovidVaccineType> mockVaccineTypeList = Arrays.asList(new CovidVaccineType(), new CovidVaccineType()); // Assuming
		List<CovidDoseType> mockDoseTypeList = Arrays.asList(new CovidDoseType(), new CovidDoseType()); // Ditto

		when(covidVaccineTypeRepoMock.findAll()).thenReturn(mockVaccineTypeList);
		when(covidDoseTypeRepoMock.findAll()).thenReturn(mockDoseTypeList);

		// When
		String result = target.getVaccinationTypeAndDoseTaken();

		// Then
		Gson gson = new Gson();
		String expectedJson = gson.toJson(Map.of("doseType", mockVaccineTypeList, "vaccineType", mockDoseTypeList));

		assertTrue(result.contains("vaccineType"));
		//assertEquals(expectedJson, result);
	}

	@Test
	void getCovidVaccinationDetails_ReturnsData() throws IEMRException {
		// Given
		Long benRegId = 1L;
		CovidVaccinationStatus mockResponse = new CovidVaccinationStatus(); // Assuming a constructor exists
		mockResponse.setCovidVSID(1L); // Assuming the setter method exists
		when(covidVaccinationRepoMock.findByBeneficiaryRegID(benRegId)).thenReturn(mockResponse);

		// When
		String result = target.getCovidVaccinationDetails(benRegId);

		// Then
		assertEquals(new Gson().toJson(mockResponse), result);
	}

	@Test
	void getCovidVaccinationDetails_ReturnsNoDataFound() throws IEMRException {
		// Given
		Long benRegId = 2L;
		when(covidVaccinationRepoMock.findByBeneficiaryRegID(benRegId)).thenReturn(null);

		// When
		String result = target.getCovidVaccinationDetails(benRegId);

		// Then
		assertEquals("No data found", result);
	}

	@Test
	void getCovidVaccinationDetails_ThrowsIEMRException() {
		// Given
		Long benRegId = 3L;
		doThrow(new RuntimeException("Database error")).when(covidVaccinationRepoMock).findByBeneficiaryRegID(benRegId);

		// When & Then
		assertThrows(IEMRException.class, () -> target.getCovidVaccinationDetails(benRegId));
	}

	@Test
	void saveBenCovidVaccinationDetails_Success() throws IEMRException {
		// Given
		String requestJson = "{\"covidVSID\": 1, \"processed\": \"N\"}";
		CovidVaccinationStatus mockResponse = new CovidVaccinationStatus();
		mockResponse.setCovidVSID(1L);
		mockResponse.setProcessed("U");

		when(covidVaccinationRepoMock.save(any(CovidVaccinationStatus.class))).thenReturn(mockResponse);

		// When
		String result = target.saveBenCovidVaccinationDetails(requestJson);

		// Then
		assertEquals(new Gson().toJson(mockResponse), result);
	}

	@Test
	void saveBenCovidVaccinationDetails_Failure() {
		// Given
		String requestJson = "{\"covidVSID\": 1, \"processed\": \"N\"}";
		when(covidVaccinationRepoMock.save(any(CovidVaccinationStatus.class))).thenReturn(null);

		// When & Then
		assertThrows(IEMRException.class, () -> target.saveBenCovidVaccinationDetails(requestJson),
				"Failed to save covid vaccination details");
	}

	@Test
	void saveBenCovidVaccinationDetails_ThrowsException() {
		// Given
		String requestJson = "{\"covidVSID\": null, \"processed\": \"N\"}";
		when(covidVaccinationRepoMock.save(any(CovidVaccinationStatus.class)))
				.thenThrow(new RuntimeException("Database error"));

		// When & Then
		assertThrows(IEMRException.class, () -> target.saveBenCovidVaccinationDetails(requestJson));
	}

}
