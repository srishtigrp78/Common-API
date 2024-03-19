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
class GovtIdentityTypeTest {
    @InjectMocks
    private GovtIdentityType govtIdentityType;

   
    @Test
    void testGetDefaultConstructor() {
        // Arrange
        GovtIdentityType govtIdentityType2 = new GovtIdentityType();

        // Act and Assert
        assertSame(govtIdentityType2, govtIdentityType2.getDefaultConstructor());
    }

    @Test
    void testGetDefaultConstructor2() {
        // Arrange
        GovtIdentityType govtIdentityType2 = new GovtIdentityType();
        govtIdentityType2.setCreatedDate(mock(Timestamp.class));

        // Act and Assert
        assertSame(govtIdentityType2, govtIdentityType2.getDefaultConstructor());
    }

    @Test
    void testGetConstructor() {
        // Arrange
        GovtIdentityType govtIdentityType2 = new GovtIdentityType();

        // Act
        GovtIdentityType actualConstructor = govtIdentityType2.getConstructor(1, "Identity Type", true);

        // Assert
        assertEquals("Identity Type", actualConstructor.getIdentityType());
        assertEquals(1, actualConstructor.getGovtIdentityTypeID().intValue());
        assertTrue(actualConstructor.getIsGovtID());
        assertSame(govtIdentityType2, actualConstructor);
    }

    @Test
    void testGetConstructor2() {
        // Arrange
        GovtIdentityType govtIdentityType2 = new GovtIdentityType();
        govtIdentityType2.setCreatedDate(mock(Timestamp.class));

        // Act
        GovtIdentityType actualConstructor = govtIdentityType2.getConstructor(1, "Identity Type", true);

        // Assert
        assertEquals("Identity Type", actualConstructor.getIdentityType());
        assertEquals(1, actualConstructor.getGovtIdentityTypeID().intValue());
        assertTrue(actualConstructor.getIsGovtID());
        assertSame(govtIdentityType2, actualConstructor);
    }

    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "{\"govtIdentityTypeID\":null,\"identityType\":null,\"isGovtID\":null,\"deleted\":null,\"createdBy\":null}",
                (new GovtIdentityType()).toString());
    }
}
