package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BeneficiaryIncomeStatusTest {
    @InjectMocks
    private BeneficiaryIncomeStatus beneficiaryIncomeStatus;

    @Test
    void testNewBeneficiaryIncomeStatus() {
        // Arrange and Act
        BeneficiaryIncomeStatus actualBeneficiaryIncomeStatus = new BeneficiaryIncomeStatus();

        // Assert
        assertNull(actualBeneficiaryIncomeStatus.getDeleted());
        assertNull(actualBeneficiaryIncomeStatus.getIncomeStatusID());
        assertNull(actualBeneficiaryIncomeStatus.getCreatedBy());
        assertNull(actualBeneficiaryIncomeStatus.getIncomeStatus());
        assertNull(actualBeneficiaryIncomeStatus.getModifiedBy());
        assertNull(actualBeneficiaryIncomeStatus.getCreatedDate());
        assertNull(actualBeneficiaryIncomeStatus.getLastModDate());
        assertNull(actualBeneficiaryIncomeStatus.getI_bendemographics());
    }

    @Test
    void testNewBeneficiaryIncomeStatus2() {
        // Arrange and Act
        BeneficiaryIncomeStatus actualBeneficiaryIncomeStatus = new BeneficiaryIncomeStatus(1, "Income Status");

        // Assert
        assertEquals("Income Status", actualBeneficiaryIncomeStatus.getIncomeStatus());
        assertEquals(1, actualBeneficiaryIncomeStatus.getIncomeStatusID().intValue());
    }

    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals("{\"incomeStatusID\":null,\"incomeStatus\":null,\"deleted\":null,\"createdBy\":null}",
                (new BeneficiaryIncomeStatus()).toString());
    }
}
