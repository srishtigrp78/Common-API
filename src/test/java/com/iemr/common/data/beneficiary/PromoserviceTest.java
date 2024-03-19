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
class PromoserviceTest {
    @InjectMocks
    private Promoservice promoservice;

    @Test
    void testGettersAndSetters() {
        // Arrange
        Promoservice promoservice = new Promoservice();

        // Act
        promoservice.setFamilyFriends("Family Friends");
        promoservice.setHealthcareWorker("Healthcare Worker");
        promoservice.setNotDisclosed("Not Disclosed");
        promoservice.setOthers("Others");
        promoservice.setPamphlet("Pamphlet");
        promoservice.setRadio("Radio");
        promoservice.setTelevision("Television");
        String actualToStringResult = promoservice.toString();
        String actualFamilyFriends = promoservice.getFamilyFriends();
        String actualHealthcareWorker = promoservice.getHealthcareWorker();
        promoservice.getId();
        String actualNotDisclosed = promoservice.getNotDisclosed();
        String actualOthers = promoservice.getOthers();
        String actualPamphlet = promoservice.getPamphlet();
        String actualRadio = promoservice.getRadio();

        // Assert that nothing has changed
        assertEquals("Family Friends", actualFamilyFriends);
        assertEquals("Healthcare Worker", actualHealthcareWorker);
        assertEquals("Not Disclosed", actualNotDisclosed);
        assertEquals("Others", actualOthers);
        assertEquals("Pamphlet", actualPamphlet);
        assertEquals("Radio", actualRadio);
        assertEquals("Television", promoservice.getTelevision());
        assertEquals(
                "{\"id\":null,\"pamphlet\":\"Pamphlet\",\"radio\":\"Radio\",\"television\":\"Television\",\"familyFriends\":\"Family"
                        + " Friends\",\"healthcareWorker\":\"Healthcare Worker\",\"others\":\"Others\",\"notDisclosed\":\"Not Disclosed\"}",
                actualToStringResult);
    }

   
    @Test
    void testNewPromoservice() {
        // Arrange and Act
        Promoservice actualPromoservice = new Promoservice();

        // Assert
        assertNull(actualPromoservice.getId());
        assertNull(actualPromoservice.getFamilyFriends());
        assertNull(actualPromoservice.getHealthcareWorker());
        assertNull(actualPromoservice.getNotDisclosed());
        assertNull(actualPromoservice.getOthers());
        assertNull(actualPromoservice.getPamphlet());
        assertNull(actualPromoservice.getRadio());
        assertNull(actualPromoservice.getTelevision());
    }

    @Test
    void testNewPromoservice2() {
        // Arrange and Act
        Promoservice actualPromoservice = new Promoservice("Pamphlet", "Radio", "Television", "Family Friends",
                "Healthcare Worker", "Others", "Not Disclosed");

        // Assert
        assertEquals("Family Friends", actualPromoservice.getFamilyFriends());
        assertEquals("Healthcare Worker", actualPromoservice.getHealthcareWorker());
        assertEquals("Not Disclosed", actualPromoservice.getNotDisclosed());
        assertEquals("Others", actualPromoservice.getOthers());
        assertEquals("Pamphlet", actualPromoservice.getPamphlet());
        assertEquals("Radio", actualPromoservice.getRadio());
        assertEquals("Television", actualPromoservice.getTelevision());
    }
}
