package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BeneficiaryTypeTest {
    @InjectMocks
    private BeneficiaryType beneficiaryType;

    @Test
    void testGettersAndSetters() {
        // Arrange
        BeneficiaryType beneficiaryType = new BeneficiaryType();

        // Act
        beneficiaryType.setBeneficiaryType("Beneficiary Type");
        beneficiaryType.setBeneficiaryTypeID((short) 1);
        beneficiaryType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        beneficiaryType.setCreatedDate(createdDate);
        Timestamp lastModDate = mock(Timestamp.class);
        beneficiaryType.setLastModDate(lastModDate);
        beneficiaryType.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        String actualToStringResult = beneficiaryType.toString();
        String actualBeneficiaryType = beneficiaryType.getBeneficiaryType();
        Short actualBeneficiaryTypeID = beneficiaryType.getBeneficiaryTypeID();
        String actualCreatedBy = beneficiaryType.getCreatedBy();
        Timestamp actualCreatedDate = beneficiaryType.getCreatedDate();
        Timestamp actualLastModDate = beneficiaryType.getLastModDate();
        String actualModifiedBy = beneficiaryType.getModifiedBy();
        beneficiaryType.isDeleted();

        // Assert that nothing has changed
        assertEquals("Beneficiary Type", actualBeneficiaryType);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals(
                "{\"beneficiaryTypeID\":1,\"beneficiaryType\":\"Beneficiary Type\",\"deleted\":null,\"createdBy\":\"Jan 1, 2020"
                        + " 8:00am GMT+0100\"}",
                actualToStringResult);
        assertEquals((short) 1, actualBeneficiaryTypeID.shortValue());
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
    }

    @Test
    void testSetDeleted() {
        // Arrange
        BeneficiaryType beneficiaryType2 = new BeneficiaryType();

        // Act
        beneficiaryType2.setDeleted(true);

        // Assert
        assertTrue(beneficiaryType2.getDeleted());
    }

    @Test
    void testSetDeleted2() {
        // Arrange
        BeneficiaryType beneficiaryType2 = new BeneficiaryType((short) 1, "Beneficiary Type", true,
                "Jan 1, 2020 8:00am GMT+0100", mock(Timestamp.class), "Jan 1, 2020 9:00am GMT+0100", mock(Timestamp.class));

        // Act
        beneficiaryType2.setDeleted(true);

        // Assert
        assertTrue(beneficiaryType2.getDeleted());
    }

    
    @Test
    void testNewBeneficiaryType() {
        // Arrange and Act
        BeneficiaryType actualBeneficiaryType = new BeneficiaryType();

        // Assert
        assertNull(actualBeneficiaryType.getDeleted());
        assertNull(actualBeneficiaryType.isDeleted());
        assertNull(actualBeneficiaryType.getBeneficiaryTypeID());
        assertNull(actualBeneficiaryType.getBeneficiaryType());
        assertNull(actualBeneficiaryType.getCreatedBy());
        assertNull(actualBeneficiaryType.getModifiedBy());
        assertNull(actualBeneficiaryType.getCreatedDate());
        assertNull(actualBeneficiaryType.getLastModDate());
    }

   
    @Test
    void testNewBeneficiaryType2() {
        // Arrange
        Timestamp createdDate = mock(Timestamp.class);
        Timestamp lastModDate = mock(Timestamp.class);

        // Act
        BeneficiaryType actualBeneficiaryType = new BeneficiaryType((short) 1, "Beneficiary Type", true,
                "Jan 1, 2020 8:00am GMT+0100", createdDate, "Jan 1, 2020 9:00am GMT+0100", lastModDate);

        // Assert
        assertEquals("Beneficiary Type", actualBeneficiaryType.getBeneficiaryType());
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualBeneficiaryType.getCreatedBy());
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualBeneficiaryType.getModifiedBy());
        assertEquals((short) 1, actualBeneficiaryType.getBeneficiaryTypeID().shortValue());
        assertTrue(actualBeneficiaryType.getDeleted());
        assertSame(createdDate, actualBeneficiaryType.getCreatedDate());
        assertSame(lastModDate, actualBeneficiaryType.getLastModDate());
    }
}
