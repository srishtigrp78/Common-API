package com.iemr.common.service.reports;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.mapper.Report1097Mapper;
import com.iemr.common.repository.report.CRMCallReportRepo;
import com.iemr.common.repository.report.CallReportRepo;
import com.iemr.common.utils.exception.IEMRException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@ExtendWith(MockitoExtension.class)
class CallReportsServiceImplTest {

	@InjectMocks
	private CallReportsServiceImpl callReportsService;

	@Mock
	private CRMCallReportRepo crmCallReportRepository;

	@Mock
	private CallReportRepo callReportRepo;

	@Mock
	Report1097Mapper mapper;
	
	@PersistenceContext
	private EntityManager entityManager;

//	@Test
//	void testGetAllReportsByDate() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetAllReportsByDateWithValidRequest() throws IEMRException {
//		// Mocks creation
//		EntityManager entityManager = mock(EntityManager.class);
//		CRMCallReportRepo crmCallReportRepository = mock(CRMCallReportRepo.class);
//
//		CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
//		CriteriaQuery<CallDetailsReport> criteriaQuery = mock(CriteriaQuery.class);
//		TypedQuery<CallDetailsReport> typedQuery = mock(TypedQuery.class);
//		Root<CallDetailsReport> root = mock(Root.class);
//
//		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
//		when(criteriaBuilder.createQuery(CallDetailsReport.class)).thenReturn(criteriaQuery);
//		when(criteriaQuery.from(CallDetailsReport.class)).thenReturn(root);
//		when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
//
//		// Service initialization
//		CallReportsServiceImpl callReportsService = new CallReportsServiceImpl();
//		//callReportsService.setEntityManager(entityManager); // Assuming a setter method for EntityManager
//		callReportsService.setCrmCallReportRepository(crmCallReportRepository); // Assuming a setter method
//
//		CallDetailsReport callDetailsReportRequest = new CallDetailsReport();
//		// Configure callDetailsReportRequest as needed
//
//		List<CallDetailsReport> expectedResult = Collections.singletonList(new CallDetailsReport());
//		when(typedQuery.getResultList()).thenReturn(expectedResult);
//
//		// Method under test
//		List<CallDetailsReport> result = callReportsService.getAllReportsByDate(callDetailsReportRequest);
//
//		// Assertions
//		assertFalse(result.isEmpty());
//
//		// Verify interactions or more assertions as needed
//	}

//	@Test
//	void testGetReportTypes() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllByAgeGroup() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllByGender() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllBySexualOrientation() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCountsByPreferredLanguage() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetComplaintDetailReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetUnblockedUserReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCallQualityReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetDistrictWiseCallReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetQualityReport() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetRandomPickup() {
//		fail("Not yet implemented");
//	}
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
//	void testGetLAHTAlgorithmCalls() {
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
//	void testGetTimeInSeconds() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetHAHTValidClosedCalls() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCallReportsServiceImpl() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCallUrl() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCallSummaryReport() {
//		fail("Not yet implemented");
//	}

}
