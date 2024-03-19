package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BeneficiaryOccupationTest {
    @InjectMocks
    private BeneficiaryOccupation beneficiaryOccupation;

    @Test
    void testGetOccupation() {
        // Arrange
        BeneficiaryOccupation beneficiaryOccupation2 = new BeneficiaryOccupation();

        // Act
        BeneficiaryOccupation actualOccupation = beneficiaryOccupation2.getOccupation(1L, "Occupationtype");

        // Assert
        assertEquals("Occupationtype", actualOccupation.getOccupationType());
        assertEquals(1L, actualOccupation.getOccupationID().longValue());
        assertSame(beneficiaryOccupation2, actualOccupation);
    }

    @Test
    void testGetOccupation2() {
        // Arrange
        BeneficiaryOccupation beneficiaryOccupation2 = new BeneficiaryOccupation();

        // Act
        BeneficiaryOccupation actualOccupation = beneficiaryOccupation2.getOccupation(1L, "Occupation Type", true,
                "Jan 1, 2020 8:00am GMT+0100", "Jan 1, 2020 9:00am GMT+0100");

        // Assert
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualOccupation.getCreatedBy());
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualOccupation.getModifiedBy());
        assertEquals("Occupation Type", actualOccupation.getOccupationType());
        assertEquals(1L, actualOccupation.getOccupationID().longValue());
        assertTrue(actualOccupation.getDeleted());
        assertSame(beneficiaryOccupation2, actualOccupation);
    }

 
    @Test
    void testGettersAndSetters() {
        // Arrange
        BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();

        // Act
        beneficiaryOccupation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        beneficiaryOccupation.setDeleted(true);
        beneficiaryOccupation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        beneficiaryOccupation.setOccupationType("Occupation Type");
        String actualToStringResult = beneficiaryOccupation.toString();
        String actualCreatedBy = beneficiaryOccupation.getCreatedBy();
        Boolean actualDeleted = beneficiaryOccupation.getDeleted();
        String actualModifiedBy = beneficiaryOccupation.getModifiedBy();
        beneficiaryOccupation.getOccupationID();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Occupation Type", beneficiaryOccupation.getOccupationType());
        assertEquals(
                "{\"occupationID\":null,\"occupationType\":\"Occupation Type\",\"deleted\":true,\"createdby\":\"Jan 1, 2020 8:00am"
                        + " GMT+0100\"}",
                actualToStringResult);
        assertTrue(actualDeleted);
    }
}
