package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.iemr.common.data.healthCareWorkerType.HealthCareWorker;
import com.iemr.common.data.location.CityDetails;
import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.data.userbeneficiarydata.Religion;
import com.iemr.common.utils.mapper.OutputMapper;

import java.sql.Timestamp;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BenDemographicsTest {
    @InjectMocks
    private BenDemographics benDemographics;

   
    @Test
    void testGetBenDemograhics() {
        // Arrange and Act
        BenDemographics actualBenDemograhics = benDemographics.getBenDemograhics(1L, 1, "Education Type", 1,
                "Occupation Type", 1, "Income Status", 1, "Community Type", 1, "en", 1, "Relegion Type", true,
                "/directory/foo.txt", "42 Main St", "42 Main St", "42 Main St", "42 Main St", "42 Main St", 1, "Oxford", 1,
                "MD", 1, "GB", "Pin Code", true, true);

        // Assert
        Religion m_religion = actualBenDemograhics.getM_religion();
        assertEquals("", m_religion.getReligionDesc());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine1());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine2());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine3());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine4());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine5());
        Community m_community = actualBenDemograhics.getM_community();
        assertEquals("Community Type", m_community.getCommunityType());
        BeneficiaryEducation i_beneficiaryeducation = actualBenDemograhics.getI_beneficiaryeducation();
        assertEquals("Education Type", i_beneficiaryeducation.getEducationType());
        Country m_country = actualBenDemograhics.getM_country();
        assertEquals("GB", m_country.getCountryName());
        BeneficiaryIncomeStatus i_beneficiaryincomestatus = actualBenDemograhics.getI_beneficiaryincomestatus();
        assertEquals("Income Status", i_beneficiaryincomestatus.getIncomeStatus());
        States m_state = actualBenDemograhics.getM_state();
        assertEquals("MD", m_state.getStateIName());
        BeneficiaryOccupation i_beneficiaryoccupation = actualBenDemograhics.getI_beneficiaryoccupation();
        assertEquals("Occupation Type", i_beneficiaryoccupation.getOccupationType());
        CityDetails m_city = actualBenDemograhics.getM_city();
        assertEquals("Oxford", m_city.getCityName());
        assertEquals("Pin Code", actualBenDemograhics.getPinCode());
        assertEquals("Relegion Type", m_religion.getReligionType());
        Language m_language = actualBenDemograhics.getM_language();
        assertEquals("en", m_language.getLanguageName());
        assertEquals(1, m_state.getStateID());
        assertEquals(1, i_beneficiaryincomestatus.getIncomeStatusID().intValue());
        assertEquals(1, m_city.getCityID().intValue());
        assertEquals(1, m_country.getCountryID().intValue());
        assertEquals(1, m_community.getCommunityID().intValue());
        assertEquals(1, m_language.getLanguageID().intValue());
        assertEquals(1, m_religion.getReligionID().intValue());
        assertEquals(1L, actualBenDemograhics.getBenDemographicsID().longValue());
        assertEquals(1L, i_beneficiaryeducation.getEducationID().longValue());
        assertEquals(1L, i_beneficiaryoccupation.getOccupationID().longValue());
        assertTrue(actualBenDemograhics.getIsAddPermanent());
        assertTrue(actualBenDemograhics.getIsAddPresent());
        assertTrue(actualBenDemograhics.getIsPhoto());
        assertSame(benDemographics, actualBenDemograhics);
    }

 
    @Test
    void testGetBenDemograhics2() {
        // Arrange
        BeneficiaryEducation i_beneficiaryeducation = new BeneficiaryEducation();
        i_beneficiaryeducation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        i_beneficiaryeducation.setDeleted(true);
        i_beneficiaryeducation.setEducationID(1L);
        i_beneficiaryeducation.setEducationType("Education Type");
        i_beneficiaryeducation.setI_BenDemographics(new HashSet<>());
        i_beneficiaryeducation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        i_beneficiaryeducation.setOutputMapper(new OutputMapper());

        BeneficiaryOccupation i_beneficiaryoccupation = new BeneficiaryOccupation();
        i_beneficiaryoccupation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        i_beneficiaryoccupation.setDeleted(true);
        i_beneficiaryoccupation.setI_BenDemographics(new HashSet<>());
        i_beneficiaryoccupation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        i_beneficiaryoccupation.setOccupationID(1L);
        i_beneficiaryoccupation.setOccupationType("Occupation Type");
        i_beneficiaryoccupation.setOutputMapper(new OutputMapper());

        BeneficiaryIncomeStatus i_beneficiaryincomestatus = new BeneficiaryIncomeStatus();
        i_beneficiaryincomestatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        i_beneficiaryincomestatus.setCreatedDate(mock(Timestamp.class));
        i_beneficiaryincomestatus.setDeleted(true);
        i_beneficiaryincomestatus.setI_bendemographics(new HashSet<>());
        i_beneficiaryincomestatus.setIncomeStatus("Income Status");
        i_beneficiaryincomestatus.setIncomeStatusID(1);
        i_beneficiaryincomestatus.setLastModDate(mock(Timestamp.class));
        i_beneficiaryincomestatus.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        i_beneficiaryincomestatus.setOutputMapper(new OutputMapper());

        Community m_community = new Community();
        m_community.setCommunityDesc("Community Desc");
        m_community.setCommunityID(1);
        m_community.setCommunityType("Community Type");
        m_community.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_community.setCreatedDate(mock(Timestamp.class));
        m_community.setDeleted(true);
        m_community.setI_bendemographics(new HashSet<>());
        m_community.setLastModDate(mock(Timestamp.class));
        m_community.setM_userdemographics(new HashSet<>());
        m_community.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_community.setOutputMapper(new OutputMapper());

        Language m_language = new Language();
        m_language.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_language.setCreatedDate(mock(Timestamp.class));
        m_language.setDeleted(true);
        m_language.setI_bendemographics(new HashSet<>());
        m_language.setIvrFilePath("/directory/foo.txt");
        m_language.setLanguageDesc("en");
        m_language.setLanguageID(1);
        m_language.setLanguageName("en");
        m_language.setLastModDate(mock(Timestamp.class));
        m_language.setM_UserLangMappings(new HashSet<>());
        m_language.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_language.setNotifications(new HashSet<>());
        m_language.setOutputMapper(new OutputMapper());
        m_language.setPropertyFilePath("/directory/foo.txt");
        Religion m_religion = new Religion(1, "Religion Type", "Religion Desc");

        CityDetails m_city = new CityDetails();
        m_city.setCityID(1);
        m_city.setCityName("Oxford");
        m_city.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_city.setCreatedDate(mock(Timestamp.class));
        m_city.setDeleted(true);
        m_city.setDistrictID(1);
        m_city.setI_bendemographics(new HashSet<>());
        m_city.setLastModDate(mock(Timestamp.class));
        m_city.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_city.setOutputMapper(new OutputMapper());
        m_city.setStateID(1);

        States m_state = new States();
        m_state.setCountryID(1);
        m_state.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_state.setCreatedDate(mock(Timestamp.class));
        m_state.setDeleted(true);
        m_state.setDistricts(new HashSet<>());
        m_state.setI_bendemographics(new HashSet<>());
        m_state.setInstitutes(new HashSet<>());
        m_state.setLanguage("en");
        m_state.setLastModDate(mock(Timestamp.class));
        m_state.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_state.setOutputMapper(new OutputMapper());
        m_state.setStateCode("MD");
        m_state.setStateID(1);
        m_state.setStateIName("MD");
        m_state.setStateName("MD");

        Country m_country = new Country();
        m_country.setContinent("Continent");
        m_country.setCountryCode("GB");
        m_country.setCountryID(1);
        m_country.setCountryName("GB");
        m_country.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_country.setCreatedDate(mock(Timestamp.class));
        m_country.setDeleted(true);
        m_country.setI_bendemographics(new HashSet<>());
        m_country.setLastModDate(mock(Timestamp.class));
        m_country.setM_userdemographics(new HashSet<>());
        m_country.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_country.setOutputMapper(new OutputMapper());

        DistrictBranchMapping m_districtbranchmapping = new DistrictBranchMapping();
        m_districtbranchmapping.setBlockID(1);
        m_districtbranchmapping.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_districtbranchmapping.setCreatedDate(mock(Timestamp.class));
        m_districtbranchmapping.setDeleted(true);
        m_districtbranchmapping.setDistrictBranchID(1);
        m_districtbranchmapping.setHabitat("Habitat");
        m_districtbranchmapping.setI_bendemographics(new HashSet<>());
        m_districtbranchmapping.setLastModDate(mock(Timestamp.class));
        m_districtbranchmapping.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_districtbranchmapping.setOutputMapper(new OutputMapper());
        m_districtbranchmapping.setPanchayatName("Panchayat Name");
        m_districtbranchmapping.setPinCode("Pin Code");
        m_districtbranchmapping.setVillageName("Village Name");

        DistrictBlock m_districtblock = new DistrictBlock();
        m_districtblock.setBlockID(1);
        m_districtblock.setBlockName("Block Name");
        m_districtblock.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_districtblock.setCreatedDate(mock(Timestamp.class));
        m_districtblock.setDeleted(true);
        m_districtblock.setDistrictID(1);
        m_districtblock.setI_bendemographics(new HashSet<>());
        m_districtblock.setInstitutes(new HashSet<>());
        m_districtblock.setLastModDate(mock(Timestamp.class));
        m_districtblock.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_districtblock.setOutputMapper(new OutputMapper());
        m_districtblock.setStateID(1);

        States states = new States();
        states.setCountryID(1);
        states.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        states.setCreatedDate(mock(Timestamp.class));
        states.setDeleted(true);
        states.setDistricts(new HashSet<>());
        states.setI_bendemographics(new HashSet<>());
        states.setInstitutes(new HashSet<>());
        states.setLanguage("en");
        states.setLastModDate(mock(Timestamp.class));
        states.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        states.setOutputMapper(new OutputMapper());
        states.setStateCode("MD");
        states.setStateID(1);
        states.setStateIName("MD");
        states.setStateName("MD");

        Districts m_district = new Districts();
        m_district.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_district.setCreatedDate(mock(Timestamp.class));
        m_district.setDeleted(true);
        m_district.setDistrictID(1);
        m_district.setDistrictName("District Name");
        m_district.setI_bendemographics(new HashSet<>());
        m_district.setInstitutes(new HashSet<>());
        m_district.setLastModDate(mock(Timestamp.class));
        m_district.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_district.setOutputMapper(new OutputMapper());
        m_district.setStateID(1);
        m_district.setStates(states);

        HealthCareWorker healthcareWorkerType = new HealthCareWorker();
        healthcareWorkerType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        healthcareWorkerType.setCreatedDate(mock(Timestamp.class));
        healthcareWorkerType.setDeleted(true);
        healthcareWorkerType.setHealthCareWorkerDesc("Health Care Worker Desc");
        healthcareWorkerType.setHealthCareWorkerID((short) 1);
        healthcareWorkerType.setHealthCareWorkerType("Health Care Worker Type");
        healthcareWorkerType.setLastModDate(mock(Timestamp.class));
        healthcareWorkerType.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");

        // Act
        BenDemographics actualBenDemograhics = benDemographics.getBenDemograhics(1L, 1L, 1, i_beneficiaryeducation, 1,
                i_beneficiaryoccupation, 1, i_beneficiaryincomestatus, 1, m_community, 1, m_language, 1, m_religion, true,
                "/directory/foo.txt", true, "/directory/foo.txt", "42 Main St", "42 Main St", "42 Main St", "42 Main St",
                "42 Main St", 1, m_city, 1, m_state, 1, m_country, "Pin Code", true, true, true, 1, m_districtbranchmapping, 1,
                m_districtblock, 1, m_district, (short) 1, healthcareWorkerType);

        // Assert
        assertEquals("/directory/foo.txt", actualBenDemograhics.getBiometricFilePath());
        assertEquals("/directory/foo.txt", actualBenDemograhics.getPhotoFilePath());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine1());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine2());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine3());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine4());
        assertEquals("42 Main St", actualBenDemograhics.getAddressLine5());
        assertEquals("Pin Code", actualBenDemograhics.getPinCode());
        assertEquals(1, actualBenDemograhics.getBlockID().intValue());
        assertEquals(1, actualBenDemograhics.getCityID().intValue());
        assertEquals(1, actualBenDemograhics.getCommunityID().intValue());
        assertEquals(1, actualBenDemograhics.getCountryID().intValue());
        assertEquals(1, actualBenDemograhics.getDistrictBranchID().intValue());
        assertEquals(1, actualBenDemograhics.getDistrictID().intValue());
        assertEquals(1, actualBenDemograhics.getEducationID().intValue());
        assertEquals(1, actualBenDemograhics.getIncomeStatusID().intValue());
        assertEquals(1, actualBenDemograhics.getOccupationID().intValue());
        assertEquals(1, actualBenDemograhics.getPreferredLangID().intValue());
        assertEquals(1, actualBenDemograhics.getReligionID().intValue());
        assertEquals(1, actualBenDemograhics.getStateID().intValue());
        assertEquals(1L, actualBenDemograhics.getBenDemographicsID().longValue());
        assertEquals(1L, actualBenDemograhics.getBeneficiaryRegID().longValue());
        assertEquals((short) 1, actualBenDemograhics.getHealthCareWorkerID().shortValue());
        assertTrue(actualBenDemograhics.getDeleted());
        assertTrue(actualBenDemograhics.getIsAddPermanent());
        assertTrue(actualBenDemograhics.getIsAddPresent());
        assertTrue(actualBenDemograhics.getIsBiometric());
        assertTrue(actualBenDemograhics.getIsPhoto());
        assertSame(i_beneficiaryeducation, actualBenDemograhics.getI_beneficiaryeducation());
        assertSame(i_beneficiaryincomestatus, actualBenDemograhics.getI_beneficiaryincomestatus());
        assertSame(i_beneficiaryoccupation, actualBenDemograhics.getI_beneficiaryoccupation());
        assertSame(healthcareWorkerType, actualBenDemograhics.getHealthCareWorkerType());
        assertSame(m_city, actualBenDemograhics.getM_city());
        assertSame(m_country, actualBenDemograhics.getM_country());
        assertSame(m_districtblock, actualBenDemograhics.getM_districtblock());
        assertSame(m_districtbranchmapping, actualBenDemograhics.getM_districtbranchmapping());
        assertSame(m_district, actualBenDemograhics.getM_district());
        assertSame(m_state, actualBenDemograhics.getM_state());
        assertSame(m_community, actualBenDemograhics.getM_community());
        assertSame(m_language, actualBenDemograhics.getM_language());
        assertSame(m_religion, actualBenDemograhics.getM_religion());
        assertSame(benDemographics, actualBenDemograhics);
    }

    
    @Test
    void testNewBenDemographics() {
        // Arrange and Act
        BenDemographics actualBenDemographics = new BenDemographics();

        // Assert
        assertNull(actualBenDemographics.getI_beneficiary());
        assertNull(actualBenDemographics.getI_beneficiaryeducation());
        assertNull(actualBenDemographics.getI_beneficiaryincomestatus());
        assertNull(actualBenDemographics.getI_beneficiaryoccupation());
        assertNull(actualBenDemographics.getHealthCareWorkerType());
        assertNull(actualBenDemographics.getM_city());
        assertNull(actualBenDemographics.getM_country());
        assertNull(actualBenDemographics.getM_districtblock());
        assertNull(actualBenDemographics.getM_districtbranchmapping());
        assertNull(actualBenDemographics.getM_district());
        assertNull(actualBenDemographics.getM_state());
        assertNull(actualBenDemographics.getM_community());
        assertNull(actualBenDemographics.getM_language());
        assertNull(actualBenDemographics.getM_religion());
        assertNull(actualBenDemographics.getDeleted());
        assertNull(actualBenDemographics.getIsAddPermanent());
        assertNull(actualBenDemographics.getIsAddPresent());
        assertNull(actualBenDemographics.getIsBiometric());
        assertNull(actualBenDemographics.getIsPhoto());
        assertNull(actualBenDemographics.getBlockID());
        assertNull(actualBenDemographics.getCityID());
        assertNull(actualBenDemographics.getCommunityID());
        assertNull(actualBenDemographics.getCountryID());
        assertNull(actualBenDemographics.getDistrictBranchID());
        assertNull(actualBenDemographics.getDistrictID());
        assertNull(actualBenDemographics.getEducationID());
        assertNull(actualBenDemographics.getIncomeStatusID());
        assertNull(actualBenDemographics.getOccupationID());
        assertNull(actualBenDemographics.getPreferredLangID());
        assertNull(actualBenDemographics.getReligionID());
        assertNull(actualBenDemographics.getStateID());
        assertNull(actualBenDemographics.getBenDemographicsID());
        assertNull(actualBenDemographics.getBeneficiaryRegID());
        assertNull(actualBenDemographics.getHealthCareWorkerID());
        assertNull(actualBenDemographics.getAddressLine1());
        assertNull(actualBenDemographics.getAddressLine2());
        assertNull(actualBenDemographics.getAddressLine3());
        assertNull(actualBenDemographics.getAddressLine4());
        assertNull(actualBenDemographics.getAddressLine5());
        assertNull(actualBenDemographics.getBiometricFilePath());
        assertNull(actualBenDemographics.getCreatedBy());
        assertNull(actualBenDemographics.getModifiedBy());
        assertNull(actualBenDemographics.getPhotoFilePath());
        assertNull(actualBenDemographics.getPinCode());
    }

   
    @Test
    void testNewBenDemographics2() {
        // Arrange and Act
        BenDemographics actualBenDemographics = new BenDemographics(1L, 1L, 1, 1, 1, 1, 1, 1, true, "/directory/foo.txt",
                true, "/directory/foo.txt", "42 Main St", "42 Main St", "42 Main St", "42 Main St", "42 Main St", 1, 1, 1,
                "Pin Code", true, true, true, "Jan 1, 2020 8:00am GMT+0100", "Jan 1, 2020 9:00am GMT+0100");

        // Assert
        assertEquals("/directory/foo.txt", actualBenDemographics.getBiometricFilePath());
        assertEquals("/directory/foo.txt", actualBenDemographics.getPhotoFilePath());
        assertEquals("42 Main St", actualBenDemographics.getAddressLine1());
        assertEquals("42 Main St", actualBenDemographics.getAddressLine2());
        assertEquals("42 Main St", actualBenDemographics.getAddressLine3());
        assertEquals("42 Main St", actualBenDemographics.getAddressLine4());
        assertEquals("42 Main St", actualBenDemographics.getAddressLine5());
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualBenDemographics.getCreatedBy());
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualBenDemographics.getModifiedBy());
        assertEquals("Pin Code", actualBenDemographics.getPinCode());
        assertEquals(1, actualBenDemographics.getCityID().intValue());
        assertEquals(1, actualBenDemographics.getCommunityID().intValue());
        assertEquals(1, actualBenDemographics.getCountryID().intValue());
        assertEquals(1, actualBenDemographics.getEducationID().intValue());
        assertEquals(1, actualBenDemographics.getIncomeStatusID().intValue());
        assertEquals(1, actualBenDemographics.getOccupationID().intValue());
        assertEquals(1, actualBenDemographics.getPreferredLangID().intValue());
        assertEquals(1, actualBenDemographics.getReligionID().intValue());
        assertEquals(1, actualBenDemographics.getStateID().intValue());
        assertEquals(1L, actualBenDemographics.getBenDemographicsID().longValue());
        assertEquals(1L, actualBenDemographics.getBeneficiaryRegID().longValue());
        assertTrue(actualBenDemographics.getDeleted());
        assertTrue(actualBenDemographics.getIsAddPermanent());
        assertTrue(actualBenDemographics.getIsAddPresent());
        assertTrue(actualBenDemographics.getIsBiometric());
        assertTrue(actualBenDemographics.getIsPhoto());
    }

   
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "{\"benDemographicsID\":null,\"beneficiaryRegID\":null,\"educationID\":null,\"i_beneficiaryeducation\":null,"
                        + "\"occupationID\":null,\"i_beneficiaryoccupation\":null,\"healthCareWorkerID\":null,\"healthCareWorkerType\""
                        + ":null,\"incomeStatusID\":null,\"i_beneficiaryincomestatus\":null,\"communityID\":null,\"m_community\":null,"
                        + "\"preferredLangID\":null,\"m_language\":null,\"religionID\":null,\"m_religion\":null,\"isPhoto\":null,\"photoFilePath"
                        + "\":null,\"isBiometric\":null,\"biometricFilePath\":null,\"addressLine1\":null,\"addressLine2\":null,\"addressLine3"
                        + "\":null,\"addressLine4\":null,\"addressLine5\":null,\"cityID\":null,\"m_city\":null,\"stateID\":null,\"m_state\""
                        + ":null,\"districtID\":null,\"m_district\":null,\"blockID\":null,\"m_districtblock\":null,\"districtBranchID\""
                        + ":null,\"m_districtbranchmapping\":null,\"countryID\":null,\"m_country\":null,\"pinCode\":null,\"isAddPresent\""
                        + ":null,\"isAddPermanent\":null,\"deleted\":null,\"createdBy\":null}",
                (new BenDemographics()).toString());
    }
}
