package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
class PhoneTypeTest {
    @InjectMocks
    private PhoneType phoneType;

  
    @Test
    void testCreatePhoneType() {
        // Arrange
        PhoneType phoneType2 = new PhoneType();

        // Act
        PhoneType actualCreatePhoneTypeResult = phoneType2.createPhoneType(1, "6625550144", true);

        // Assert
        assertEquals("6625550144", actualCreatePhoneTypeResult.getPhoneType());
        assertEquals(1, actualCreatePhoneTypeResult.getPhoneTypeID().intValue());
        assertTrue(actualCreatePhoneTypeResult.getDeleted());
        assertSame(phoneType2, actualCreatePhoneTypeResult);
    }

    @Test
    void testCreatePhoneType2() {
        // Arrange
        PhoneType phoneType2 = new PhoneType();
        phoneType2.setCreatedDate(mock(Timestamp.class));

        // Act
        PhoneType actualCreatePhoneTypeResult = phoneType2.createPhoneType(1, "6625550144", true);

        // Assert
        assertEquals("6625550144", actualCreatePhoneTypeResult.getPhoneType());
        assertEquals(1, actualCreatePhoneTypeResult.getPhoneTypeID().intValue());
        assertTrue(actualCreatePhoneTypeResult.getDeleted());
        assertSame(phoneType2, actualCreatePhoneTypeResult);
    }

   
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals("{\"phoneTypeID\":null,\"deleted\":null,\"createdBy\":null}", (new PhoneType()).toString());
    }
}
