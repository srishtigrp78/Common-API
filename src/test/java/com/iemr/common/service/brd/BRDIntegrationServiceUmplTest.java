package com.iemr.common.service.brd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.repository.beneficiary.BeneficiaryRelationshipTypeRepository;
import com.iemr.common.service.beneficiary.BenRelationshipTypeServiceImpl;

//@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class BRDIntegrationServiceUmplTest {

	private final BeneficiaryRelationshipTypeRepository beneficiaryRelationshipTypeRepositoryMock = mock(
			BeneficiaryRelationshipTypeRepository.class, "beneficiaryRelationshipTypeRepository");

	private AutoCloseable autoCloseableMocks;

	@InjectMocks()
	private BenRelationshipTypeServiceImpl target;

	@AfterEach()
	public void afterTest() throws Exception {
		if (autoCloseableMocks != null)
			autoCloseableMocks.close();
	}

	// Sapient generated method id: ${68d0032a-61f3-3970-bf0c-36240cd99490}, hash:
	// D228329B1BFF214A5EDF4C15C093FE2E
	@Test()
	void getActiveRelationshipTypesWhenObjectLengthGreaterThanOrEqualsTo2() {
		/*
		 * Branches:* (for-each(resultSet)) : true* (object != null) : true*
		 * (object.length >= 2) : true
		 */
		// Arrange Statement(s)
		target = new BenRelationshipTypeServiceImpl();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		Object[] objectArray = new Object[] { 0, "return_of_getActiveRelationshipsItem1Item1" };
		Set<Object[]> objectSet = new HashSet<>();
		objectSet.add(objectArray);
		doReturn(objectSet).when(beneficiaryRelationshipTypeRepositoryMock).getActiveRelationships();

		// Act Statement(s)
		List<BenRelationshipType> result = target.getActiveRelationshipTypes();

		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result.size(), equalTo(1));
			assertThat(result.get(0), is(instanceOf(BenRelationshipType.class)));
			verify(beneficiaryRelationshipTypeRepositoryMock).getActiveRelationships();
		});
	}
}
