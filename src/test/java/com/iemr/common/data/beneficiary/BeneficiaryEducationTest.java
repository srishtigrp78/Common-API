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
class BeneficiaryEducationTest {
    @InjectMocks
    private BeneficiaryEducation beneficiaryEducation;

    @Test
    void testNewBeneficiaryEducation() {
        // Arrange and Act
        BeneficiaryEducation actualBeneficiaryEducation = new BeneficiaryEducation();

        // Assert
        assertNull(actualBeneficiaryEducation.getDeleted());
        assertNull(actualBeneficiaryEducation.getEducationID());
        assertNull(actualBeneficiaryEducation.getCreatedBy());
        assertNull(actualBeneficiaryEducation.getEducationType());
        assertNull(actualBeneficiaryEducation.getModifiedBy());
        assertNull(actualBeneficiaryEducation.getI_BenDemographics());
    }

    @Test
    void testNewBeneficiaryEducation2() {
        // Arrange and Act
        BeneficiaryEducation actualBeneficiaryEducation = new BeneficiaryEducation(1L, "Education Type");

        // Assert
        assertEquals("Education Type", actualBeneficiaryEducation.getEducationType());
        assertEquals(1L, actualBeneficiaryEducation.getEducationID().longValue());
    }

    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals("{\"educationID\":null,\"educationType\":null,\"deleted\":null,\"createdBy\":null}",
                (new BeneficiaryEducation()).toString());
    }
}
