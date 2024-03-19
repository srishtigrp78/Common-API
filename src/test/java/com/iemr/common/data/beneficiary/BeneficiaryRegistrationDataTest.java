package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class BeneficiaryRegistrationDataTest {
   
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "{\"m_Title\":null,\"m_Status\":null,\"i_BeneficiaryEducation\":null,\"states\":null,\"m_genders\":null,\"m"
                        + "_maritalStatuses\":null,\"m_communities\":null,\"m_language\":null,\"directory\":null,\"sexualOrientations"
                        + "\":null,\"callTypes\":null,\"benRelationshipTypes\":null,\"beneficiaryOccupations\":null,\"govtIdentityTypes"
                        + "\":null}",
                (new BeneficiaryRegistrationData()).toString());
    }
}
