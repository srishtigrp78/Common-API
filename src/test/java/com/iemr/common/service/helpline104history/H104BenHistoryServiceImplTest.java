package com.iemr.common.service.helpline104history;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.repository.helpline104history.H104BenHistoryRepository;

@ExtendWith(MockitoExtension.class)
class H104BenHistoryServiceImplTest {

	@Mock
	private H104BenHistoryRepository h104BenHistoryRepository;

	@InjectMocks
	private H104BenHistoryServiceImpl h104BenHistoryService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGeSmpleBenHistory() {
		// Given
		Long beneficiaryId = 1L;
		ArrayList<Object[]> mockResponse = new ArrayList<>();
		Object[] historyRecord = { "Test Data 1", "Test Data 2" };
		mockResponse.add(historyRecord);

		// When
		when(h104BenHistoryRepository.getBenHistory(beneficiaryId)).thenReturn(mockResponse);

		// Then
		ArrayList<Object[]> result = h104BenHistoryService.geSmpleBenHistory(beneficiaryId);

		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		assertArrayEquals(historyRecord, result.get(0));

		// Verify the interaction with the mocked repository
		verify(h104BenHistoryRepository, times(1)).getBenHistory(beneficiaryId);
	}
}
