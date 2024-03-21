package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.utils.mapper.OutputMapper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class BeneficiaryTest {
    @InjectMocks
    private Beneficiary beneficiary;

    @Test
    void testNewBeneficiary() {
        // Arrange, Act and Assert
        SimpleDateFormat formatYear = (new Beneficiary()).getFormatYear();
        TimeZone expectedTimeZone = formatYear.getTimeZone();
        assertSame(expectedTimeZone, formatYear.getCalendar().getTimeZone());
    }

//    @Test
//    void testNewBeneficiary2() {
//      
//        // Arrange
//        Gender m_gender = new Gender();
//        m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//        m_gender.setCreatedDate(mock(Timestamp.class));
//        m_gender.setDeleted(true);
//        m_gender.setGenderID(1);
//        m_gender.setGenderName("Gender Name");
//        m_gender.setI_beneficiary(new HashSet<>());
//        m_gender.setLastModDate(mock(Timestamp.class));
//        m_gender.setM_user(new HashSet<>());
//        m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//        m_gender.setOutputMapper(new OutputMapper());
//
//        // Act
//        new Beneficiary(1L, "Beneficiary ID", "Jane", "Middle Name", "Doe", m_gender, mock(Timestamp.class));
//
//    }

 
    @Test
    void testNewBeneficiary3() {
        // Arrange
        Gender m_gender = new Gender();
        m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_gender.setCreatedDate(mock(Timestamp.class));
        m_gender.setDeleted(true);
        m_gender.setGenderID(1);
        m_gender.setGenderName("Gender Name");
        m_gender.setI_beneficiary(new HashSet<>());
        m_gender.setLastModDate(mock(Timestamp.class));
        m_gender.setM_user(new HashSet<>());
        m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_gender.setOutputMapper(new OutputMapper());
        Timestamp DOB = mock(Timestamp.class);
        when(DOB.getTime()).thenReturn(10L);

        Title m_title = new Title();
        m_title.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_title.setCreatedDate(mock(Timestamp.class));
        m_title.setDeleted(true);
        m_title.setI_beneficiary(new HashSet<>());
        m_title.setLastModDate(mock(Timestamp.class));
        m_title.setM_user(new HashSet<>());
        m_title.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_title.setOutputMapper(new OutputMapper());
        m_title.setTitleDesc("Dr");
        m_title.setTitleID(1);
        m_title.setTitleName("Dr");

        Status m_status = new Status();
        m_status.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_status.setCreatedDate(mock(Timestamp.class));
        m_status.setDeleted(true);
        m_status.setI_Beneficiaries(new HashSet<>());
        m_status.setLastModDate(mock(Timestamp.class));
        m_status.setM_Users(new HashSet<>());
        m_status.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_status.setOutputMapper(new OutputMapper());
        m_status.setProviderServiceMappings(new HashSet<>());
        m_status.setServiceProviders(new HashSet<>());
        m_status.setStatus("Status");
        m_status.setStatusDesc("Status Desc");
        m_status.setStatusID(1);

        MaritalStatus m_maritalstatus = new MaritalStatus();
        m_maritalstatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        m_maritalstatus.setCreatedDate(mock(Timestamp.class));
        m_maritalstatus.setDeleted(true);
        m_maritalstatus.setI_beneficiary(new HashSet<>());
        m_maritalstatus.setLastModDate(mock(Timestamp.class));
        m_maritalstatus.setM_user(new HashSet<>());
        m_maritalstatus.setMaritalStatusID(1);
        m_maritalstatus.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        m_maritalstatus.setOutputMapper(new OutputMapper());
        m_maritalstatus.setStatus("Status");
        m_maritalstatus.setStatusDesc("Status Desc");

        SexualOrientation sexualOrientation = new SexualOrientation();
        sexualOrientation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        sexualOrientation.setCreatedDate(mock(Timestamp.class));
        sexualOrientation.setDeleted(true);
        sexualOrientation.setI_Beneficiaries(new HashSet<>());
        sexualOrientation.setLastModDate(mock(Timestamp.class));
        sexualOrientation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        sexualOrientation.setOutputMapper(new OutputMapper());
        sexualOrientation.setSexualOrientation("Sexual Orientation");
        sexualOrientation.setSexualOrientationDesc("Sexual Orientation Desc");
        sexualOrientation.setSexualOrientationId((short) 1);

        // Act
        Beneficiary actualBeneficiary = new Beneficiary(1L, "Beneficiary ID", "Jane", "Middle Name", "Doe", m_gender, DOB,
                m_title, m_status, m_maritalstatus, sexualOrientation, "Father Name", "Spouse Name", new ArrayList<>(),
                "Govt Identity No", 1, 1, true, 1, 1, 1, 1, 1, "Is HIVPos", "Place Of Work", "Remarks",
                "Source Of Information");

        // Assert
        verify(DOB).getTime();
        SimpleDateFormat formatYear = actualBeneficiary.getFormatYear();
        TimeZone expectedTimeZone = formatYear.getTimeZone();
        assertSame(expectedTimeZone, formatYear.getCalendar().getTimeZone());
    }

   
    @Test
    void testNewBeneficiary4() {
        // Arrange
        Timestamp DOB = mock(Timestamp.class);
        when(DOB.getTime()).thenReturn(10L);

        // Act
        Beneficiary actualBeneficiary = new Beneficiary(1L, "Beneficiary ID", "Jane", "Middle Name", "Doe", 1,
                "Gender Name", DOB);

        // Assert
        verify(DOB).getTime();
        SimpleDateFormat formatYear = actualBeneficiary.getFormatYear();
        TimeZone expectedTimeZone = formatYear.getTimeZone();
        assertSame(expectedTimeZone, formatYear.getCalendar().getTimeZone());
    }

   
    @Test
    void testNewBeneficiary5() {
        // Arrange
        Timestamp DOB = mock(Timestamp.class);
        when(DOB.getTime()).thenReturn(10L);

        // Act
        Beneficiary actualBeneficiary = new Beneficiary(1L, "Beneficiary ID", "Jane", "Middle Name", "Doe", 1,
                "Gender Name", DOB, new BenDemographics());

        // Assert
        verify(DOB).getTime();
        SimpleDateFormat formatYear = actualBeneficiary.getFormatYear();
        TimeZone expectedTimeZone = formatYear.getTimeZone();
        assertSame(expectedTimeZone, formatYear.getCalendar().getTimeZone());
    }

    @Test
    void testNewBeneficiary6() {
        // Arrange
        Timestamp DOB = mock(Timestamp.class);
        when(DOB.getTime()).thenReturn(10L);
        BenDemographics demographics = new BenDemographics();

        // Act
        Beneficiary actualBeneficiary = new Beneficiary(1L, "Beneficiary ID", "Jane", "Middle Name", "Doe", 1,
                "Gender Name", DOB, demographics, new ArrayList<>());

        // Assert
        verify(DOB).getTime();
        SimpleDateFormat formatYear = actualBeneficiary.getFormatYear();
        TimeZone expectedTimeZone = formatYear.getTimeZone();
        assertSame(expectedTimeZone, formatYear.getCalendar().getTimeZone());
    }

    @Test
    void testNewBeneficiary7() {
        // Arrange
        Timestamp DOB = mock(Timestamp.class);
        when(DOB.getTime()).thenReturn(10L);
        BenDemographics demographics = new BenDemographics();

        ArrayList<BenPhoneMap> phoneMap = new ArrayList<>();
        phoneMap.add(new BenPhoneMap());

        // Act
        Beneficiary actualBeneficiary = new Beneficiary(1L, "Beneficiary ID", "Jane", "Middle Name", "Doe", 1,
                "Gender Name", DOB, demographics, phoneMap);

        // Assert
        verify(DOB).getTime();
        SimpleDateFormat formatYear = actualBeneficiary.getFormatYear();
        TimeZone expectedTimeZone = formatYear.getTimeZone();
        assertSame(expectedTimeZone, formatYear.getCalendar().getTimeZone());
    }

    @Test
    void testNewBeneficiary8() {
        // Arrange
        Timestamp DOB = mock(Timestamp.class);
        when(DOB.getTime()).thenReturn(10L);
        BenDemographics demographics = new BenDemographics();

        ArrayList<BenPhoneMap> phoneMap = new ArrayList<>();
        phoneMap.add(new BenPhoneMap());
        phoneMap.add(new BenPhoneMap());

        // Act
        Beneficiary actualBeneficiary = new Beneficiary(1L, "Beneficiary ID", "Jane", "Middle Name", "Doe", 1,
                "Gender Name", DOB, demographics, phoneMap);

        // Assert
        verify(DOB).getTime();
        SimpleDateFormat formatYear = actualBeneficiary.getFormatYear();
        TimeZone expectedTimeZone = formatYear.getTimeZone();
        assertSame(expectedTimeZone, formatYear.getCalendar().getTimeZone());
    }
}
