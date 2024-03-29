package com.iemr.common.controller.helpline104history;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.helpline104history.H104BenMedHistory;
import com.iemr.common.service.helpline104history.H104BenHistoryServiceImpl;
import com.iemr.common.utils.mapper.InputMapper;

import jakarta.ws.rs.NotFoundException;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class Helpline104BeneficiaryHistoryControllerTest2 {

	private final H104BenHistoryServiceImpl smpleBenHistoryServiceImplMock = mock(H104BenHistoryServiceImpl.class,
			"smpleBenHistoryServiceImpl");

	private AutoCloseable autoCloseableMocks;

	@InjectMocks()
	private Helpline104BeneficiaryHistoryController target;

	@AfterEach()
	public void afterTest() throws Exception {
		if (autoCloseableMocks != null)
			autoCloseableMocks.close();
	}

//	// Sapient generated method id: ${7bc3155a-f54a-37f8-b037-d14a553a69df}, hash:
//	// 0F6CF2727588DBB5F8460CF5FE2C3EEE
//	@Test()
//	void getBenCaseSheetTest() throws Exception {
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		H104BenMedHistory h104BenMedHistoryMock = mock(H104BenMedHistory.class, "getBenCaseSheet_object1");
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(h104BenMedHistoryMock).when(inputMapperMock).fromJson("request1", H104BenMedHistory.class);
//			doReturn(0L).when(h104BenMedHistoryMock).getBeneficiaryRegID();
//			target = new Helpline104BeneficiaryHistoryController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			ArrayList<Object[]> objectList = new ArrayList<>();
//			doReturn(objectList).when(smpleBenHistoryServiceImplMock).geSmpleBenHistory(0L);
//			// Act Statement(s)
//			String result = target.getBenCaseSheet("request1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("request1", H104BenMedHistory.class);
//				verify(h104BenMedHistoryMock).getBeneficiaryRegID();
//				verify(smpleBenHistoryServiceImplMock).geSmpleBenHistory(0L);
//			});
//		}
//	}
//
//	// Sapient generated method id: ${381c317a-c1df-3f37-b31d-d6737a467dd6}, hash:
//	// 4840F693373414DCA8366C43EF9C2D8F
//	@Test()
//	void getBenCaseSheetWhenCaughtException() throws Exception {
//		
//		// Arrange Statement(s)
//		InputMapper inputMapperMock = mock(InputMapper.class);
//		H104BenMedHistory h104BenMedHistoryMock = mock(H104BenMedHistory.class, "getBenCaseSheet_object1");
//		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//			doReturn(h104BenMedHistoryMock).when(inputMapperMock).fromJson("request1", H104BenMedHistory.class);
//			doReturn(0L).when(h104BenMedHistoryMock).getBeneficiaryRegID();
//			target = new Helpline104BeneficiaryHistoryController();
//			autoCloseableMocks = MockitoAnnotations.openMocks(this);
//			ArrayList<Object[]> objectList = new ArrayList<>();
//			doReturn(objectList).when(smpleBenHistoryServiceImplMock).geSmpleBenHistory(0L);
//			// Act Statement(s)
//			String result = target.getBenCaseSheet("request1");
//			// Assert statement(s)
//			assertAll("result", () -> {
//				assertThat(result, equalTo(
//						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//				verify(inputMapperMock).fromJson("request1", H104BenMedHistory.class);
//				verify(h104BenMedHistoryMock).getBeneficiaryRegID();
//				verify(smpleBenHistoryServiceImplMock).geSmpleBenHistory(0L);
//			});
//		}
//	}

	@Test
	public void testGetBenCaseSheet_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(smpleBenHistoryServiceImplMock.geSmpleBenHistory(any()).toString()).thenThrow(NotFoundException.class);

		String response = target.getBenCaseSheet(request);
		assertEquals(response, target.getBenCaseSheet(request));
	}
}
