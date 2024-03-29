package com.iemr.common.data.brd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

class BRDIntegrationDataTest {

    @Test
    void testGetBRDDetailsWithNonNullList() {
        ArrayList<Object[]> inputList = new ArrayList<>();
        Object[] data = {
            Timestamp.valueOf("2024-03-22 12:34:56"),
            BigInteger.valueOf(1),
            BigInteger.valueOf(2),
            BigInteger.valueOf(3),
            "RoleName",
            "Male",
            30,
            "Single",
            "State",
            "District",
            "Block",
            "Village",
            "123456",
            "GroupType",
            "CallType",
            BigInteger.valueOf(4),
            "DrugName",
            "DiseaseSummary",
            "SelectedDiagnosis",
            "CategoryName",
            "SubCategoryName"
        };
        inputList.add(data);

        List<BRDIntegrationData> result = BRDIntegrationData.getBRDDetails(inputList);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());

        BRDIntegrationData resultData = result.get(0);
        assertNotNull(resultData);
        assertEquals("Male", resultData.getGender());
        assertEquals("Single", resultData.getMartialStatus());
        assertEquals(BigInteger.valueOf(1), resultData.getBeneficiaryId());
    }

    @Test
    void testGetBRDDetailsWithNullList() {
        List<BRDIntegrationData> result = BRDIntegrationData.getBRDDetails(null);
        assertNull(result);
    }

    @Test
    void testGetBRDDetailsWithEmptyList() {
        ArrayList<Object[]> inputList = new ArrayList<>();
        List<BRDIntegrationData> result = BRDIntegrationData.getBRDDetails(inputList);
        assertNull(result);
    }
}
