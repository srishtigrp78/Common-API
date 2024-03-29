package com.iemr.common.service.reportSecondary;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.report.MedHistory;
import com.iemr.common.model.excel.ExcelHelper;
import com.iemr.common.notification.exception.IEMRException;
import com.iemr.common.repository.report.CRMCallReportRepo;
import com.iemr.common.secondary.repository.callreport.CallReportSecondaryRepo;

@ExtendWith(MockitoExtension.class)
class SecondaryReportServiceImplTest {

	@InjectMocks
	SecondaryReportServiceImpl secondaryReportService;

	@Mock
	public CallReportSecondaryRepo callReportRepoSecondary;

	@Mock
	private CRMCallReportRepo crmCallReportRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

//	@Test
//	void testGetQualityReport() {
//		fail("Not yet implemented");
//	}
//
//	
//	@Test
//	void testGetRandomPickup() {
//		fail("Not yet implemented");
//	}
//
//
//	@Test
//	void testGetOtherAdviceCalls() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetLAHTTransferCallsAtMO() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetHAHTValidClosedCalls() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetHAHTDisconnectedCalls() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetDSusedValidCallAtHAO() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetPreviousQualityReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetLAHTAlgorithmCalls() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetComplaintDetailReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCallSummaryReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetDistrictWiseCallReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetDistrictWiseCallReport1() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetUnblockedUserReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllBySexualOrientationReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCallQualityReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCountsByPrefferedLanguage() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllByAgeGroup() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllReportsByDate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllByGender() {
//		fail("Not yet implemented");
//	}

}
