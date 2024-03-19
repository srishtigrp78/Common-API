package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BenRelationshipTypeTest {
    @InjectMocks
    private BenRelationshipType benRelationshipType;

    @Test
    void testGettersAndSetters() {
        // Arrange
        BenRelationshipType benRelationshipType = new BenRelationshipType();

        // Act
        String actualToStringResult = benRelationshipType.toString();
        Integer actualBenRelationshipID = benRelationshipType.getBenRelationshipID();
        String actualBenRelationshipType = benRelationshipType.getBenRelationshipType();

        // Assert
        assertEquals(
                "{\"benRelationshipID\":null,\"benPhoneMap\":null,\"benRelationshipType\":null,\"deleted\":null,\"createdBy"
                        + "\":null}",
                actualToStringResult);
        assertNull(benRelationshipType.getDeleted());
        assertNull(actualBenRelationshipID);
        assertNull(actualBenRelationshipType);
    }

    @Test
    void testNewBenRelationshipType() {
        // Arrange and Act
        BenRelationshipType actualBenRelationshipType = new BenRelationshipType();

        // Assert
        assertNull(actualBenRelationshipType.getDeleted());
        assertNull(actualBenRelationshipType.getBenRelationshipID());
        assertNull(actualBenRelationshipType.getBenRelationshipType());
        assertNull(actualBenRelationshipType.getCreatedBy());
        assertNull(actualBenRelationshipType.getModifiedBy());
        assertNull(actualBenRelationshipType.getCreatedDate());
        assertNull(actualBenRelationshipType.getLastModDate());
        assertNull(actualBenRelationshipType.getBenPhoneMap());
    }

   
    @Test
    void testNewBenRelationshipType2() {
        // Arrange and Act
        BenRelationshipType actualBenRelationshipType = new BenRelationshipType(1, "Ben Relationship Type", true);

        // Assert
        assertEquals("Ben Relationship Type", actualBenRelationshipType.getBenRelationshipType());
        assertEquals(1, actualBenRelationshipType.getBenRelationshipID().intValue());
        assertTrue(actualBenRelationshipType.getDeleted());
    }
}
