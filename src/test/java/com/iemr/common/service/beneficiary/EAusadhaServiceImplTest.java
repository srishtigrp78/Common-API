package com.iemr.common.service.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.iemr.common.data.eausadha.ItemMaster;
import com.iemr.common.model.eAusadha.EAusadhaDTO;
import com.iemr.common.repository.eausadha.ItemMasterRepo;
import com.iemr.common.repository.eausadha.ItemStockEntryRepo;
import com.iemr.common.repository.facility.FacilityRepo;

@ExtendWith(MockitoExtension.class)
class EAusadhaServiceImplTest {

	@Mock
	private FacilityRepo facilityRepo;
	@Mock
	private ItemMasterRepo itemMasterRepo;
	@Mock
	private ItemStockEntryRepo itemStockEntryRepo;
	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private EAusadhaServiceImpl service;

//	@Test
//	void testCreateEAusadhaSuccess() throws Exception {
//		MockitoAnnotations.openMocks(this);
//
//		// Mocking
//		when(facilityRepo.fetchInstitutionId(any())).thenReturn("inst123");
//		JSONArray responseArray = new JSONArray();
//		responseArray.put(new JSONObject().put("Drug_id", "drug123").put("Batch_number", "batch123")
//				.put("Drug_name", "Paracetamol").put("Quantity_In_Units", 100).put("Exp_date", "2024-12-31"));
////		when(restTemplate.exchange(any(String.class), any(), any(), any(Class.class)))
////				.thenReturn(new ResponseEntity<>(responseArray.toString(), HttpStatus.OK));
//		when(itemMasterRepo.findByItemCode(any())).thenReturn(List.of(new ItemMaster()));
//		when(itemStockEntryRepo.getItemStocks(any(), any())).thenReturn(null);
//
//		// Execute
//		EAusadhaDTO dto = new EAusadhaDTO();
//		dto.setFacilityId(1);
//		dto.setInwardDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
//		String result = service.createEAusadha(dto, "Auth");
//
//		System.out.println("result is = " + result);
//
//		// Verify
//		assertTrue(result.contains("InstituteId=inst123"));
//	}
//
//	@Test
//	void testCreateEAusadhaFailureOnApiCall() {
//		MockitoAnnotations.openMocks(this);
//
//		when(facilityRepo.fetchInstitutionId(any())).thenReturn("inst123");
//		when(restTemplate.exchange(any(String.class), any(), any(), any(Class.class)))
//				.thenReturn(new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR));
//
//		EAusadhaDTO dto = new EAusadhaDTO();
//		dto.setFacilityId(1);
//		dto.setInwardDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
//
//		Exception exception = assertThrows(Exception.class, () -> {
//			service.createEAusadha(dto, "Auth");
//		});
//
//		assertEquals("Error while getting stock response", exception.getMessage().substring(0, 30));
//	}
}
