package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class BenMedHistoryTest {
   
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "{\"benMedHistoryID\":null,\"beneficiaryRegID\":null,\"yearofIllness\":null,\"illnessTypeID\":null,\"illnessType"
                        + "\":null,\"surgeryID\":null,\"yearofSurgery\":null,\"deleted\":null,\"createdBy\":null}",
                (new BenMedHistory()).toString());
    }
}
