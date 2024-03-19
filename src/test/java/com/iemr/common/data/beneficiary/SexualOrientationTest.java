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
class SexualOrientationTest {
    @InjectMocks
    private SexualOrientation sexualOrientation;

   
    @Test
    void testNewSexualOrientation() {
        // Arrange and Act
        SexualOrientation actualSexualOrientation = new SexualOrientation();

        // Assert
        assertNull(actualSexualOrientation.getDeleted());
        assertNull(actualSexualOrientation.getSexualOrientationId());
        assertNull(actualSexualOrientation.getCreatedBy());
        assertNull(actualSexualOrientation.getModifiedBy());
        assertNull(actualSexualOrientation.getSexualOrientation());
        assertNull(actualSexualOrientation.getSexualOrientationDesc());
        assertNull(actualSexualOrientation.getCreatedDate());
        assertNull(actualSexualOrientation.getLastModDate());
        assertNull(actualSexualOrientation.getI_Beneficiaries());
    }

    @Test
    void testNewSexualOrientation2() {
        // Arrange and Act
        SexualOrientation actualSexualOrientation = new SexualOrientation((short) 1, "Sexual Orientation");

        // Assert
        assertEquals("Sexual Orientation", actualSexualOrientation.getSexualOrientation());
        assertEquals((short) 1, actualSexualOrientation.getSexualOrientationId().shortValue());
    }

   
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "{\"sexualOrientationId\":null,\"i_Beneficiaries\":null,\"sexualOrientation\":null,\"sexualOrientationDesc\""
                        + ":null,\"deleted\":null,\"createdBy\":null}",
                (new SexualOrientation()).toString());
    }
}
