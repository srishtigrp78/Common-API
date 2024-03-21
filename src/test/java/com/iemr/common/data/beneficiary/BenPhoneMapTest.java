package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.Phone;
import com.iemr.common.utils.mapper.OutputMapper;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BenPhoneMapTest {
    @InjectMocks
    private BenPhoneMap benPhoneMap;

//    @Test
//    void testCreateBenPhoneMaps() {
//        // Arrange
//        ArrayList<BenFamilyDTO> familyMembers = new ArrayList<>();
//        ArrayList<Phone> phones = new ArrayList<>();
//
//        // Act
//        List<BenPhoneMap> actualCreateBenPhoneMapsResult = BenPhoneMap.createBenPhoneMaps(familyMembers, phones,
//                BigInteger.valueOf(1L));
//
//        // Assert
//        assertTrue(actualCreateBenPhoneMapsResult.isEmpty());
//    }
//
//    @Test
//    void testCreateBenPhoneMaps2() {
//        // Arrange
//        BenFamilyDTO benFamilyDTO = new BenFamilyDTO();
//        benFamilyDTO.setAssociatedBenRegId(BigInteger.valueOf(1L));
//        benFamilyDTO.setBenFamilyMapId(BigInteger.valueOf(1L));
//        benFamilyDTO.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//        benFamilyDTO.setCreatedDate(mock(Timestamp.class));
//        benFamilyDTO.setDeleted(true);
//        benFamilyDTO.setIsEmergencyContact(true);
//        benFamilyDTO.setLastModDate(mock(Timestamp.class));
//        benFamilyDTO.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//        benFamilyDTO.setParkingPlaceID(1);
//        benFamilyDTO.setRelationshipID(1);
//        benFamilyDTO.setRelationshipToSelf("Relationship To Self");
//        benFamilyDTO.setVanID(1);
//
//        ArrayList<BenFamilyDTO> familyMembers = new ArrayList<>();
//        familyMembers.add(benFamilyDTO);
//        ArrayList<Phone> phones = new ArrayList<>();
//
//        // Act
//        List<BenPhoneMap> actualCreateBenPhoneMapsResult = BenPhoneMap.createBenPhoneMaps(familyMembers, phones,
//                BigInteger.valueOf(1L));
//
//        // Assert
//        assertTrue(actualCreateBenPhoneMapsResult.isEmpty());
//    }
//
//  
//    @Test
//    void testCreateBenPhoneMaps3() {
//        // Arrange
//        BenFamilyDTO benFamilyDTO = new BenFamilyDTO();
//        benFamilyDTO.setAssociatedBenRegId(BigInteger.valueOf(1L));
//        benFamilyDTO.setBenFamilyMapId(BigInteger.valueOf(1L));
//        benFamilyDTO.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//        benFamilyDTO.setCreatedDate(mock(Timestamp.class));
//        benFamilyDTO.setDeleted(true);
//        benFamilyDTO.setIsEmergencyContact(true);
//        benFamilyDTO.setLastModDate(mock(Timestamp.class));
//        benFamilyDTO.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//        benFamilyDTO.setParkingPlaceID(1);
//        benFamilyDTO.setRelationshipID(1);
//        benFamilyDTO.setRelationshipToSelf("Relationship To Self");
//        benFamilyDTO.setVanID(1);
//
//        BenFamilyDTO benFamilyDTO2 = new BenFamilyDTO();
//        benFamilyDTO2.setAssociatedBenRegId(BigInteger.valueOf(1L));
//        benFamilyDTO2.setBenFamilyMapId(BigInteger.valueOf(1L));
//        benFamilyDTO2.setCreatedBy("Created By");
//        benFamilyDTO2.setCreatedDate(mock(Timestamp.class));
//        benFamilyDTO2.setDeleted(false);
//        benFamilyDTO2.setIsEmergencyContact(false);
//        benFamilyDTO2.setLastModDate(mock(Timestamp.class));
//        benFamilyDTO2.setModifiedBy("Modified By");
//        benFamilyDTO2.setParkingPlaceID(2);
//        benFamilyDTO2.setRelationshipID(2);
//        benFamilyDTO2.setRelationshipToSelf("BenFamilyDTO(benFamilyMapId=");
//        benFamilyDTO2.setVanID(2);
//
//        ArrayList<BenFamilyDTO> familyMembers = new ArrayList<>();
//        familyMembers.add(benFamilyDTO2);
//        familyMembers.add(benFamilyDTO);
//        ArrayList<Phone> phones = new ArrayList<>();
//
//        // Act
//        List<BenPhoneMap> actualCreateBenPhoneMapsResult = BenPhoneMap.createBenPhoneMaps(familyMembers, phones,
//                BigInteger.valueOf(1L));
//
//        // Assert
//        assertTrue(actualCreateBenPhoneMapsResult.isEmpty());
//    }
//
//    @Test
//    void testCreateBenPhoneMaps4() {
//        // Arrange
//        ArrayList<BenFamilyDTO> familyMembers = new ArrayList<>();
//
//        Phone phone = new Phone();
//        phone.setBelongsToBenRegId("42");
//        phone.setBelongsToName("Belongs To Name");
//        phone.setIsPreferredCallIncoming(true);
//        phone.setIsPreferredCallOutgoing(true);
//        phone.setIsPreferredForSMSRecv(true);
//        phone.setIsPreferredForSMSSend(true);
//        phone.setIsSelfNumber(true);
//        phone.setIsSmartPhone(true);
//        phone.setPhoneNum("6625550144");
//        phone.setPhoneType("6625550144");
//
//        ArrayList<Phone> phones = new ArrayList<>();
//        phones.add(phone);
//
//        // Act
//        List<BenPhoneMap> actualCreateBenPhoneMapsResult = BenPhoneMap.createBenPhoneMaps(familyMembers, phones,
//                BigInteger.valueOf(1L));
//
//        // Assert
//        assertTrue(actualCreateBenPhoneMapsResult.isEmpty());
//    }
//
//   
//    @Test
//    void testCreateBenPhoneMaps5() {
//        // Arrange
//        ArrayList<BenFamilyDTO> familyMembers = new ArrayList<>();
//
//        Phone phone = new Phone();
//        phone.setBelongsToBenRegId("42");
//        phone.setBelongsToName("Belongs To Name");
//        phone.setIsPreferredCallIncoming(true);
//        phone.setIsPreferredCallOutgoing(true);
//        phone.setIsPreferredForSMSRecv(true);
//        phone.setIsPreferredForSMSSend(true);
//        phone.setIsSelfNumber(true);
//        phone.setIsSmartPhone(true);
//        phone.setPhoneNum("6625550144");
//        phone.setPhoneType("6625550144");
//
//        Phone phone2 = new Phone();
//        phone2.setBelongsToBenRegId("Belongs To Ben Reg Id");
//        phone2.setBelongsToName("Phone(phoneNum=");
//        phone2.setIsPreferredCallIncoming(false);
//        phone2.setIsPreferredCallOutgoing(false);
//        phone2.setIsPreferredForSMSRecv(false);
//        phone2.setIsPreferredForSMSSend(false);
//        phone2.setIsSelfNumber(false);
//        phone2.setIsSmartPhone(false);
//        phone2.setPhoneNum("8605550118");
//        phone2.setPhoneType("8605550118");
//
//        ArrayList<Phone> phones = new ArrayList<>();
//        phones.add(phone2);
//        phones.add(phone);
//
//        // Act
//        List<BenPhoneMap> actualCreateBenPhoneMapsResult = BenPhoneMap.createBenPhoneMaps(familyMembers, phones,
//                BigInteger.valueOf(1L));
//
//        // Assert
//        assertTrue(actualCreateBenPhoneMapsResult.isEmpty());
//    }
//
//    @Test
//    void testGettersAndSetters() {
//        // Arrange
//        BenPhoneMap benPhoneMap = new BenPhoneMap();
//
//        // Act
//        benPhoneMap.setBenificiaryRegID(1L);
//        benPhoneMap.setDeleted(true);
//        benPhoneMap.setNuisanceCallCount(3);
//        benPhoneMap.setParentBenRegID(1L);
//        String actualToStringResult = benPhoneMap.toString();
//        benPhoneMap.getBenPhMapID();
//        benPhoneMap.getBenRelationshipID();
//        benPhoneMap.getBenRelationshipType();
//        benPhoneMap.getBeneficiary();
//        Long actualBenificiaryRegID = benPhoneMap.getBenificiaryRegID();
//        benPhoneMap.getCreatedBy();
//        benPhoneMap.getCreatedDate();
//        Boolean actualDeleted = benPhoneMap.getDeleted();
//        benPhoneMap.getLastModDate();
//        benPhoneMap.getModifiedBy();
//        Integer actualNuisanceCallCount = benPhoneMap.getNuisanceCallCount();
//        benPhoneMap.getOutputMapper();
//        Long actualParentBenRegID = benPhoneMap.getParentBenRegID();
//        benPhoneMap.getParentBeneficiary();
//        benPhoneMap.getPhoneNo();
//        benPhoneMap.getPhoneType();
//        benPhoneMap.getPhoneTypeID();
//
//        // Assert that nothing has changed
//        assertEquals(
//                "{\"benPhMapID\":null,\"benificiaryRegID\":\"1\",\"parentBenRegID\":\"1\",\"benRelationshipID\":null,\"benRelationshipName"
//                        + "\":null,\"benRelationshipType\":null,\"phoneNo\":null,\"phoneTypeID\":null,\"phoneTypeName\":null,\"deleted\""
//                        + ":true,\"createdBy\":null}",
//                actualToStringResult);
//        assertEquals(1L, actualBenificiaryRegID.longValue());
//        assertEquals(1L, actualParentBenRegID.longValue());
//        assertEquals(3, actualNuisanceCallCount.intValue());
//        assertTrue(actualDeleted);
//    }
//
//  
//    @Test
//    void testNewBenPhoneMap() {
//        // Arrange and Act
//        BenPhoneMap actualBenPhoneMap = new BenPhoneMap();
//
//        // Assert
//        assertEquals(0, actualBenPhoneMap.getNuisanceCallCount().intValue());
//        assertFalse(actualBenPhoneMap.getIs1097());
//    }
//
//   
//    @Test
//    void testNewBenPhoneMap2() {
//        // Arrange and Act
//        BenPhoneMap actualBenPhoneMap = new BenPhoneMap(1, "6625550144", "Jan 1, 2020 8:00am GMT+0100", true);
//
//        // Assert
//        assertEquals("6625550144", actualBenPhoneMap.getPhoneNo());
//        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualBenPhoneMap.getCreatedBy());
//        assertEquals(0, actualBenPhoneMap.getNuisanceCallCount().intValue());
//        assertEquals(1, actualBenPhoneMap.getBenRelationshipID().intValue());
//        assertTrue(actualBenPhoneMap.getDeleted());
//        assertTrue(actualBenPhoneMap.getIs1097());
//    }
//
//   
//    @Test
//    void testNewBenPhoneMap3() {
//        // Arrange and Act
//        BenPhoneMap actualBenPhoneMap = new BenPhoneMap(1L, 1L, 1L, 1, "6625550144", 1, true);
//
//        // Assert
//        assertEquals("6625550144", actualBenPhoneMap.getPhoneNo());
//        assertEquals(0, actualBenPhoneMap.getNuisanceCallCount().intValue());
//        assertEquals(1, actualBenPhoneMap.getBenRelationshipID().intValue());
//        assertEquals(1, actualBenPhoneMap.getPhoneTypeID().intValue());
//        assertEquals(1L, actualBenPhoneMap.getBenPhMapID().longValue());
//        assertEquals(1L, actualBenPhoneMap.getBenificiaryRegID().longValue());
//        assertEquals(1L, actualBenPhoneMap.getParentBenRegID().longValue());
//        assertFalse(actualBenPhoneMap.getIs1097());
//        assertTrue(actualBenPhoneMap.getDeleted());
//    }
//
//   
//    @Test
//    void testNewBenPhoneMap4() {
//        // Arrange
//        BenRelationshipType benRelationshipType = new BenRelationshipType();
//        benRelationshipType.setBenPhoneMap(new HashSet<>());
//        benRelationshipType.setBenRelationshipID(1);
//        benRelationshipType.setBenRelationshipType("Ben Relationship Type");
//        benRelationshipType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//        benRelationshipType.setCreatedDate(mock(Timestamp.class));
//        benRelationshipType.setDeleted(true);
//        benRelationshipType.setLastModDate(mock(Timestamp.class));
//        benRelationshipType.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//        benRelationshipType.setOutputMapper(new OutputMapper());
//
//        // Act
//        BenPhoneMap actualBenPhoneMap = new BenPhoneMap(1L, 1L, 1L, 1, "6625550144", 1, true, benRelationshipType, 3);
//
//        // Assert
//        assertEquals("6625550144", actualBenPhoneMap.getPhoneNo());
//        BenRelationshipType benRelationshipType2 = actualBenPhoneMap.getBenRelationshipType();
//        assertEquals("Ben Relationship Type", benRelationshipType2.getBenRelationshipType());
//        assertEquals(1, actualBenPhoneMap.getBenRelationshipID().intValue());
//        assertEquals(1, actualBenPhoneMap.getPhoneTypeID().intValue());
//        assertEquals(1, benRelationshipType2.getBenRelationshipID().intValue());
//        assertEquals(1L, actualBenPhoneMap.getBenPhMapID().longValue());
//        assertEquals(1L, actualBenPhoneMap.getBenificiaryRegID().longValue());
//        assertEquals(1L, actualBenPhoneMap.getParentBenRegID().longValue());
//        assertEquals(3, actualBenPhoneMap.getNuisanceCallCount().intValue());
//        assertFalse(actualBenPhoneMap.getIs1097());
//        assertTrue(actualBenPhoneMap.getDeleted());
//        assertTrue(benRelationshipType2.getDeleted());
//    }
//
//    @Test
//    void testNewBenPhoneMap5() {
//        // Arrange
//        BenRelationshipType benRelationshipType = mock(BenRelationshipType.class);
//        when(benRelationshipType.getDeleted()).thenReturn(true);
//        when(benRelationshipType.getBenRelationshipID()).thenReturn(1);
//        when(benRelationshipType.getBenRelationshipType()).thenReturn("Ben Relationship Type");
//        doNothing().when(benRelationshipType).setBenPhoneMap(Mockito.<Set<BenPhoneMap>>any());
//        doNothing().when(benRelationshipType).setBenRelationshipID(Mockito.<Integer>any());
//        doNothing().when(benRelationshipType).setBenRelationshipType(Mockito.<String>any());
//        doNothing().when(benRelationshipType).setCreatedBy(Mockito.<String>any());
//        doNothing().when(benRelationshipType).setCreatedDate(Mockito.<Timestamp>any());
//        doNothing().when(benRelationshipType).setDeleted(Mockito.<Boolean>any());
//        doNothing().when(benRelationshipType).setLastModDate(Mockito.<Timestamp>any());
//        doNothing().when(benRelationshipType).setModifiedBy(Mockito.<String>any());
//        doNothing().when(benRelationshipType).setOutputMapper(Mockito.<OutputMapper>any());
//        benRelationshipType.setBenPhoneMap(new HashSet<>());
//        benRelationshipType.setBenRelationshipID(1);
//        benRelationshipType.setBenRelationshipType("Ben Relationship Type");
//        benRelationshipType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//        benRelationshipType.setCreatedDate(mock(Timestamp.class));
//        benRelationshipType.setDeleted(true);
//        benRelationshipType.setLastModDate(mock(Timestamp.class));
//        benRelationshipType.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//        benRelationshipType.setOutputMapper(new OutputMapper());
//
//        // Act
//        BenPhoneMap actualBenPhoneMap = new BenPhoneMap(1L, 1L, 1L, 1, "6625550144", 1, true, benRelationshipType, 3);
//
//        // Assert
//        verify(benRelationshipType).getBenRelationshipID();
//        verify(benRelationshipType).getBenRelationshipType();
//        verify(benRelationshipType).getDeleted();
//        verify(benRelationshipType).setBenPhoneMap(Mockito.<Set<BenPhoneMap>>any());
//        verify(benRelationshipType).setBenRelationshipID(Mockito.<Integer>any());
//        verify(benRelationshipType).setBenRelationshipType(eq("Ben Relationship Type"));
//        verify(benRelationshipType).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
//        verify(benRelationshipType).setCreatedDate(Mockito.<Timestamp>any());
//        verify(benRelationshipType).setDeleted(Mockito.<Boolean>any());
//        verify(benRelationshipType).setLastModDate(Mockito.<Timestamp>any());
//        verify(benRelationshipType).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
//        verify(benRelationshipType).setOutputMapper(Mockito.<OutputMapper>any());
//        assertEquals("6625550144", actualBenPhoneMap.getPhoneNo());
//        BenRelationshipType benRelationshipType2 = actualBenPhoneMap.getBenRelationshipType();
//        assertEquals("Ben Relationship Type", benRelationshipType2.getBenRelationshipType());
//        assertEquals(1, actualBenPhoneMap.getBenRelationshipID().intValue());
//        assertEquals(1, actualBenPhoneMap.getPhoneTypeID().intValue());
//        assertEquals(1, benRelationshipType2.getBenRelationshipID().intValue());
//        assertEquals(1L, actualBenPhoneMap.getBenPhMapID().longValue());
//        assertEquals(1L, actualBenPhoneMap.getBenificiaryRegID().longValue());
//        assertEquals(1L, actualBenPhoneMap.getParentBenRegID().longValue());
//        assertEquals(3, actualBenPhoneMap.getNuisanceCallCount().intValue());
//        assertFalse(actualBenPhoneMap.getIs1097());
//        assertTrue(actualBenPhoneMap.getDeleted());
//        assertTrue(benRelationshipType2.getDeleted());
//    }
}
