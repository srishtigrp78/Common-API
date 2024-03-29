//package com.iemr.common.controller.beneficiary;
//
//import com.iemr.common.data.beneficiary.*;
//import com.iemr.common.data.directory.Directory;
//import com.iemr.common.data.location.States;
//import com.iemr.common.data.userbeneficiarydata.*;
//import com.iemr.common.data.users.User;
//import com.iemr.common.model.beneficiary.BeneficiaryModel;
//import com.iemr.common.service.beneficiary.*;
//import com.iemr.common.service.directory.DirectoryService;
//import com.iemr.common.service.location.LocationService;
//import com.iemr.common.service.reports.CallReportsService;
//import com.iemr.common.service.userbeneficiarydata.*;
//import com.iemr.common.utils.exception.IEMRException;
//import jakarta.servlet.http.HttpServletRequest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.mock.web.MockHttpServletRequest;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class BeneficiaryRegistrationControllerTest3 {
//
//    @Mock
//    private RegisterBenificiaryService mockRegisterBenificiaryService;
//    @Mock
//    private IEMRBeneficiaryTypeService mockIemrBeneficiaryTypeService;
//    @Mock
//    private IEMRSearchUserService mockIemrSearchUserService;
//    @Mock
//    private EducationService mockEducationService;
//    @Mock
//    private TitleService mockTitleService;
//    @Mock
//    private StatusService mockStatusService;
//    @Mock
//    private LocationService mockLocationService;
//    @Mock
//    private GenderService mockGenderService;
//    @Mock
//    private MaritalStatusService mockMaritalStatusService;
//    @Mock
//    private CommunityService mockCommunityService;
//    @Mock
//    private DirectoryService mockDirectoryService;
//    @Mock
//    private SexualOrientationService mockSexualOrientationService;
//    @Mock
//    private LanguageService mockLanguageService;
//    @Mock
//    private BenRelationshipTypeService mockBenRelationshipTypeService;
//    @Mock
//    private BeneficiaryOccupationService mockBeneficiaryOccupationService;
//    @Mock
//    private GovtIdentityTypeService mockGovtIdentityTypeService;
//    @Mock
//    private CallReportsService mockCallReportsService;
//
//    @InjectMocks
//    private BeneficiaryRegistrationController beneficiaryRegistrationControllerUnderTest;
//
//    @BeforeEach
//    void setUp() {
//        beneficiaryRegistrationControllerUnderTest.setRegisterBenificiaryService(mockRegisterBenificiaryService);
//        beneficiaryRegistrationControllerUnderTest.setIEMRBeneficiaryTypeService(mockIemrBeneficiaryTypeService);
//        beneficiaryRegistrationControllerUnderTest.setIEMRSearchUserService(mockIemrSearchUserService);
//        beneficiaryRegistrationControllerUnderTest.setEducationService(mockEducationService);
//        beneficiaryRegistrationControllerUnderTest.setTitleService(mockTitleService);
//        beneficiaryRegistrationControllerUnderTest.setStatusService(mockStatusService);
//        beneficiaryRegistrationControllerUnderTest.setLocationService(mockLocationService);
//        beneficiaryRegistrationControllerUnderTest.setGenderService(mockGenderService);
//        beneficiaryRegistrationControllerUnderTest.setMaritalStatusService(mockMaritalStatusService);
//        beneficiaryRegistrationControllerUnderTest.setCommunityService(mockCommunityService);
//        beneficiaryRegistrationControllerUnderTest.setDirectoryService(mockDirectoryService);
//        beneficiaryRegistrationControllerUnderTest.setSexualOrientationService(mockSexualOrientationService);
//        beneficiaryRegistrationControllerUnderTest.setLanguageService(mockLanguageService);
//        beneficiaryRegistrationControllerUnderTest.setBenRelationshipTypeService(mockBenRelationshipTypeService);
//        beneficiaryRegistrationControllerUnderTest.setBeneficiaryOccupationService(mockBeneficiaryOccupationService);
//        beneficiaryRegistrationControllerUnderTest.setGovtIdentityTypeService(mockGovtIdentityTypeService);
//    }
//
//    @Test
//    void testCreateBeneficiary() throws Exception {
//        // Setup
//        final BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
//        beneficiaryModel.setBeneficiaryRegID(0L);
//        beneficiaryModel.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel.setIs1097(false);
//        beneficiaryModel.setHealthID("HealthID");
//        beneficiaryModel.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel.setFamilyId("familyId");
//        beneficiaryModel.setIdentity("identity");
//
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.save(...).
//        final BeneficiaryModel beneficiaryModel1 = new BeneficiaryModel();
//        beneficiaryModel1.setBeneficiaryRegID(0L);
//        beneficiaryModel1.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel1.setIs1097(false);
//        beneficiaryModel1.setHealthID("HealthID");
//        beneficiaryModel1.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel1.setFamilyId("familyId");
//        beneficiaryModel1.setIdentity("identity");
//        when(mockRegisterBenificiaryService.save(eq(beneficiaryModel1), any(HttpServletRequest.class)))
//                .thenReturn("result");
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.createBeneficiary(beneficiaryModel,
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testCreateBeneficiary_RegisterBenificiaryServiceThrowsException() throws Exception {
//        // Setup
//        final BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
//        beneficiaryModel.setBeneficiaryRegID(0L);
//        beneficiaryModel.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel.setIs1097(false);
//        beneficiaryModel.setHealthID("HealthID");
//        beneficiaryModel.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel.setFamilyId("familyId");
//        beneficiaryModel.setIdentity("identity");
//
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.save(...).
//        final BeneficiaryModel beneficiaryModel1 = new BeneficiaryModel();
//        beneficiaryModel1.setBeneficiaryRegID(0L);
//        beneficiaryModel1.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel1.setIs1097(false);
//        beneficiaryModel1.setHealthID("HealthID");
//        beneficiaryModel1.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel1.setFamilyId("familyId");
//        beneficiaryModel1.setIdentity("identity");
//        when(mockRegisterBenificiaryService.save(eq(beneficiaryModel1), any(HttpServletRequest.class)))
//                .thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.createBeneficiary(beneficiaryModel,
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure IEMRSearchUserService.userExitsCheckWithId(...).
//        final BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
//        beneficiaryModel.setBeneficiaryRegID(0L);
//        beneficiaryModel.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel.setIs1097(false);
//        beneficiaryModel.setHealthID("HealthID");
//        beneficiaryModel.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel.setFamilyId("familyId");
//        beneficiaryModel.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels = List.of(beneficiaryModel);
//        when(mockIemrSearchUserService.userExitsCheckWithId("beneficiaryID", "auth", false))
//                .thenReturn(beneficiaryModels);
//
//        // Configure IEMRSearchUserService.userExitsCheckWithId(...).
//        final BeneficiaryModel beneficiaryModel1 = new BeneficiaryModel();
//        beneficiaryModel1.setBeneficiaryRegID(0L);
//        beneficiaryModel1.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel1.setIs1097(false);
//        beneficiaryModel1.setHealthID("HealthID");
//        beneficiaryModel1.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel1.setFamilyId("familyId");
//        beneficiaryModel1.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels1 = List.of(beneficiaryModel1);
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenReturn(beneficiaryModels1);
//
//        // Configure IEMRSearchUserService.userExitsCheckWithHealthId_ABHAId(...).
//        final BeneficiaryModel beneficiaryModel2 = new BeneficiaryModel();
//        beneficiaryModel2.setBeneficiaryRegID(0L);
//        beneficiaryModel2.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel2.setIs1097(false);
//        beneficiaryModel2.setHealthID("HealthID");
//        beneficiaryModel2.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel2.setFamilyId("familyId");
//        beneficiaryModel2.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels2 = List.of(beneficiaryModel2);
//        when(mockIemrSearchUserService.userExitsCheckWithHealthId_ABHAId("HealthID", "auth", false))
//                .thenReturn(beneficiaryModels2);
//
//        // Configure IEMRSearchUserService.userExitsCheckWithHealthIdNo_ABHAIdNo(...).
//        final BeneficiaryModel beneficiaryModel3 = new BeneficiaryModel();
//        beneficiaryModel3.setBeneficiaryRegID(0L);
//        beneficiaryModel3.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel3.setIs1097(false);
//        beneficiaryModel3.setHealthID("HealthID");
//        beneficiaryModel3.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel3.setFamilyId("familyId");
//        beneficiaryModel3.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels3 = List.of(beneficiaryModel3);
//        when(mockIemrSearchUserService.userExitsCheckWithHealthIdNo_ABHAIdNo("HealthIDNumber", "auth",
//                false)).thenReturn(beneficiaryModels3);
//
//        // Configure IEMRSearchUserService.userExitsCheckWithFamilyId(...).
//        final BeneficiaryModel beneficiaryModel4 = new BeneficiaryModel();
//        beneficiaryModel4.setBeneficiaryRegID(0L);
//        beneficiaryModel4.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel4.setIs1097(false);
//        beneficiaryModel4.setHealthID("HealthID");
//        beneficiaryModel4.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel4.setFamilyId("familyId");
//        beneficiaryModel4.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels4 = List.of(beneficiaryModel4);
//        when(mockIemrSearchUserService.userExitsCheckWithFamilyId("familyId", "auth", false))
//                .thenReturn(beneficiaryModels4);
//
//        // Configure IEMRSearchUserService.userExitsCheckWithGovIdentity(...).
//        final BeneficiaryModel beneficiaryModel5 = new BeneficiaryModel();
//        beneficiaryModel5.setBeneficiaryRegID(0L);
//        beneficiaryModel5.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel5.setIs1097(false);
//        beneficiaryModel5.setHealthID("HealthID");
//        beneficiaryModel5.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel5.setFamilyId("familyId");
//        beneficiaryModel5.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels5 = List.of(beneficiaryModel5);
//        when(mockIemrSearchUserService.userExitsCheckWithGovIdentity("identity", "auth", false))
//                .thenReturn(beneficiaryModels5);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithId1ReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithId("beneficiaryID", "auth", false))
//                .thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithId1ThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithId("beneficiaryID", "auth", false)).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithId2ReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithId2ThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithHealthId_ABHAIdReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithHealthId_ABHAId("HealthID", "auth", false))
//                .thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithHealthId_ABHAIdThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithHealthId_ABHAId("HealthID", "auth", false))
//                .thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithHealthIdNo_ABHAIdNoReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithHealthIdNo_ABHAIdNo("HealthIDNumber", "auth",
//                false)).thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithHealthIdNo_ABHAIdNoThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithHealthIdNo_ABHAIdNo("HealthIDNumber", "auth",
//                false)).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithFamilyIdReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithFamilyId("familyId", "auth", false))
//                .thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithFamilyIdThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithFamilyId("familyId", "auth", false))
//                .thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithGovIdentityReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithGovIdentity("identity", "auth", false))
//                .thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByID_IEMRSearchUserServiceUserExitsCheckWithGovIdentityThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockIemrSearchUserService.userExitsCheckWithGovIdentity("identity", "auth", false))
//                .thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByID("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByPhone() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure IEMRSearchUserService.findByBeneficiaryPhoneNo(...).
//        final BenPhoneMap benPhoneMap = new BenPhoneMap();
//        benPhoneMap.setBenificiaryRegID(0L);
//        benPhoneMap.setParentBenRegID(0L);
//        benPhoneMap.setDeleted(false);
//        benPhoneMap.setNuisanceCallCount(0);
//        benPhoneMap.setBenPhMapID(0L);
//        when(mockIemrSearchUserService.findByBeneficiaryPhoneNo(benPhoneMap, 0, 0, "auth")).thenReturn("result");
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByPhone("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchUserByPhone_IEMRSearchUserServiceThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure IEMRSearchUserService.findByBeneficiaryPhoneNo(...).
//        final BenPhoneMap benPhoneMap = new BenPhoneMap();
//        benPhoneMap.setBenificiaryRegID(0L);
//        benPhoneMap.setParentBenRegID(0L);
//        benPhoneMap.setDeleted(false);
//        benPhoneMap.setNuisanceCallCount(0);
//        benPhoneMap.setBenPhMapID(0L);
//        when(mockIemrSearchUserService.findByBeneficiaryPhoneNo(benPhoneMap, 0, 0, "auth")).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchUserByPhone("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchBeneficiary() throws Exception {
//        // Setup
//        final BeneficiaryModel request = new BeneficiaryModel();
//        request.setBeneficiaryRegID(0L);
//        request.setBeneficiaryID("beneficiaryID");
//        request.setIs1097(false);
//        request.setHealthID("HealthID");
//        request.setHealthIDNumber("HealthIDNumber");
//        request.setFamilyId("familyId");
//        request.setIdentity("identity");
//
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure IEMRSearchUserService.findBeneficiary(...).
//        final BeneficiaryModel request1 = new BeneficiaryModel();
//        request1.setBeneficiaryRegID(0L);
//        request1.setBeneficiaryID("beneficiaryID");
//        request1.setIs1097(false);
//        request1.setHealthID("HealthID");
//        request1.setHealthIDNumber("HealthIDNumber");
//        request1.setFamilyId("familyId");
//        request1.setIdentity("identity");
//        when(mockIemrSearchUserService.findBeneficiary(request1, "auth")).thenReturn("result");
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchBeneficiary(request, httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testSearchBeneficiary_IEMRSearchUserServiceThrowsException() throws Exception {
//        // Setup
//        final BeneficiaryModel request = new BeneficiaryModel();
//        request.setBeneficiaryRegID(0L);
//        request.setBeneficiaryID("beneficiaryID");
//        request.setIs1097(false);
//        request.setHealthID("HealthID");
//        request.setHealthIDNumber("HealthIDNumber");
//        request.setFamilyId("familyId");
//        request.setIdentity("identity");
//
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure IEMRSearchUserService.findBeneficiary(...).
//        final BeneficiaryModel request1 = new BeneficiaryModel();
//        request1.setBeneficiaryRegID(0L);
//        request1.setBeneficiaryID("beneficiaryID");
//        request1.setIs1097(false);
//        request1.setHealthID("HealthID");
//        request1.setHealthIDNumber("HealthIDNumber");
//        request1.setFamilyId("familyId");
//        request1.setIdentity("identity");
//        when(mockIemrSearchUserService.findBeneficiary(request1, "auth")).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.searchBeneficiary(request, httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_StatusServiceReturnsNoItems() {
//        // Setup
//        when(mockStatusService.getActiveStatus()).thenReturn(Collections.emptyList());
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_TitleServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        when(mockTitleService.getActiveTitles()).thenReturn(Collections.emptyList());
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_EducationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        when(mockEducationService.getActiveEducations()).thenReturn(Collections.emptyList());
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_LocationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        when(mockLocationService.getStates(1)).thenReturn(Collections.emptyList());
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_GenderServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        when(mockGenderService.getActiveGenders()).thenReturn(Collections.emptyList());
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary1));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_MaritalStatusServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(Collections.emptyList());
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary1));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_CommunityServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        when(mockCommunityService.getActiveCommunities()).thenReturn(Collections.emptyList());
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_LanguageServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        when(mockLanguageService.getActiveLanguages()).thenReturn(Collections.emptyList());
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_DirectoryServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        when(mockDirectoryService.getDirectories()).thenReturn(Collections.emptyList());
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_SexualOrientationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(Collections.emptyList());
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_BenRelationshipTypeServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(Collections.emptyList());
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_BeneficiaryOccupationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(Collections.emptyList());
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationData_GovtIdentityTypeServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories()).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationData();
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_StatusServiceReturnsNoItems() {
//        // Setup
//        when(mockStatusService.getActiveStatus()).thenReturn(Collections.emptyList());
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_TitleServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        when(mockTitleService.getActiveTitles()).thenReturn(Collections.emptyList());
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_EducationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        when(mockEducationService.getActiveEducations()).thenReturn(Collections.emptyList());
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_LocationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        when(mockLocationService.getStates(1)).thenReturn(Collections.emptyList());
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_GenderServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        when(mockGenderService.getActiveGenders()).thenReturn(Collections.emptyList());
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary1));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_MaritalStatusServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(Collections.emptyList());
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary1));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_CommunityServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        when(mockCommunityService.getActiveCommunities()).thenReturn(Collections.emptyList());
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_LanguageServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        when(mockLanguageService.getActiveLanguages()).thenReturn(Collections.emptyList());
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_DirectoryServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        when(mockDirectoryService.getDirectories(0)).thenReturn(Collections.emptyList());
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_SexualOrientationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(Collections.emptyList());
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_BenRelationshipTypeServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(Collections.emptyList());
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_BeneficiaryOccupationServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(Collections.emptyList());
//
//        // Configure GovtIdentityTypeService.getActiveIDTypes(...).
//        final GovtIdentityType govtIdentityType = new GovtIdentityType();
//        govtIdentityType.setGovtIdentityTypeID(0);
//        final Beneficiary beneficiary2 = new Beneficiary();
//        beneficiary2.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics2 = new BenDemographics();
//        i_bendemographics2.setBenDemographicsID(0L);
//        beneficiary2.setI_bendemographics(i_bendemographics2);
//        govtIdentityType.setI_Beneficiaries(List.of(beneficiary2));
//        final List<GovtIdentityType> govtIdentityTypes = List.of(govtIdentityType);
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(govtIdentityTypes);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetRegistrationDataV1_GovtIdentityTypeServiceReturnsNoItems() {
//        // Setup
//        // Configure StatusService.getActiveStatus(...).
//        final Status status = new Status();
//        status.setStatusID(0);
//        status.setStatus("status");
//        status.setStatusDesc("statusDesc");
//        status.setDeleted(false);
//        status.setCreatedBy("createdBy");
//        final List<Status> statuses = List.of(status);
//        when(mockStatusService.getActiveStatus()).thenReturn(statuses);
//
//        // Configure TitleService.getActiveTitles(...).
//        final Title title = new Title();
//        title.setTitleID(0);
//        final User user = new User();
//        user.setUserID(0L);
//        user.setTitleID(0);
//        user.setFirstName("firstName");
//        title.setM_user(Set.of(user));
//        final List<Title> titles = List.of(title);
//        when(mockTitleService.getActiveTitles()).thenReturn(titles);
//
//        // Configure EducationService.getActiveEducations(...).
//        final List<BeneficiaryEducation> beneficiaryEducations = List.of(new BeneficiaryEducation(0L, "educationType"));
//        when(mockEducationService.getActiveEducations()).thenReturn(beneficiaryEducations);
//
//        // Configure LocationService.getStates(...).
//        final States states1 = new States();
//        states1.setStateID(0);
//        states1.setStateCode("stateCode");
//        states1.setCountryID(0);
//        states1.setDeleted(false);
//        states1.setCreatedBy("createdBy");
//        final List<States> states = List.of(states1);
//        when(mockLocationService.getStates(1)).thenReturn(states);
//
//        // Configure GenderService.getActiveGenders(...).
//        final Gender gender = new Gender();
//        gender.setGenderID(0);
//        final Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics = new BenDemographics();
//        i_bendemographics.setBenDemographicsID(0L);
//        beneficiary.setI_bendemographics(i_bendemographics);
//        gender.setI_beneficiary(Set.of(beneficiary));
//        final List<Gender> genders = List.of(gender);
//        when(mockGenderService.getActiveGenders()).thenReturn(genders);
//
//        // Configure MaritalStatusService.getActiveMaritalStatus(...).
//        final MaritalStatus maritalStatus = new MaritalStatus();
//        maritalStatus.setMaritalStatusID(0);
//        final Beneficiary beneficiary1 = new Beneficiary();
//        beneficiary1.setBeneficiaryRegID(0L);
//        final BenDemographics i_bendemographics1 = new BenDemographics();
//        i_bendemographics1.setBenDemographicsID(0L);
//        beneficiary1.setI_bendemographics(i_bendemographics1);
//        maritalStatus.setI_beneficiary(Set.of(beneficiary1));
//        final List<MaritalStatus> maritalStatuses = List.of(maritalStatus);
//        when(mockMaritalStatusService.getActiveMaritalStatus()).thenReturn(maritalStatuses);
//
//        // Configure CommunityService.getActiveCommunities(...).
//        final Community community = new Community();
//        community.setCommunityID(0);
//        final BenDemographics benDemographics = new BenDemographics();
//        benDemographics.setBenDemographicsID(0L);
//        benDemographics.setBeneficiaryRegID(0L);
//        final Beneficiary i_beneficiary = new Beneficiary();
//        benDemographics.setI_beneficiary(i_beneficiary);
//        community.setI_bendemographics(Set.of(benDemographics));
//        final List<Community> communities = List.of(community);
//        when(mockCommunityService.getActiveCommunities()).thenReturn(communities);
//
//        // Configure LanguageService.getActiveLanguages(...).
//        final List<Language> languages = List.of(
//                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
//        when(mockLanguageService.getActiveLanguages()).thenReturn(languages);
//
//        // Configure DirectoryService.getDirectories(...).
//        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
//        when(mockDirectoryService.getDirectories(0)).thenReturn(directories);
//
//        // Configure SexualOrientationService.getSexualOrientations(...).
//        final List<SexualOrientation> sexualOrientations = List.of(
//                new SexualOrientation((short) 0, "sexualOrientation"));
//        when(mockSexualOrientationService.getSexualOrientations()).thenReturn(sexualOrientations);
//
//        // Configure BenRelationshipTypeService.getActiveRelationshipTypes(...).
//        final List<BenRelationshipType> benRelationshipTypes = List.of(
//                new BenRelationshipType(0, "benRelationshipType", false));
//        when(mockBenRelationshipTypeService.getActiveRelationshipTypes()).thenReturn(benRelationshipTypes);
//
//        // Configure BeneficiaryOccupationService.getActiveOccupations(...).
//        final BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
//        beneficiaryOccupation.setOccupationType("occupationType");
//        beneficiaryOccupation.setDeleted(false);
//        beneficiaryOccupation.setCreatedBy("createdBy");
//        beneficiaryOccupation.setModifiedBy("modifiedBy");
//        beneficiaryOccupation.setOccupationID(0L);
//        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(beneficiaryOccupation);
//        when(mockBeneficiaryOccupationService.getActiveOccupations()).thenReturn(beneficiaryOccupations);
//
//        when(mockGovtIdentityTypeService.getActiveIDTypes()).thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getRegistrationDataV1("request");
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciary() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateBenificiary(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateBenificiary(m_user, "auth")).thenReturn(0);
//
//        // Configure IEMRSearchUserService.userExitsCheckWithId(...).
//        final BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
//        beneficiaryModel.setBeneficiaryRegID(0L);
//        beneficiaryModel.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel.setIs1097(false);
//        beneficiaryModel.setHealthID("HealthID");
//        beneficiaryModel.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel.setFamilyId("familyId");
//        beneficiaryModel.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels = List.of(beneficiaryModel);
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenReturn(beneficiaryModels);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciary("benificiaryRequest",
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciary_RegisterBenificiaryServiceThrowsIEMRException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateBenificiary(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateBenificiary(m_user, "auth")).thenThrow(IEMRException.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciary("benificiaryRequest",
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciary_IEMRSearchUserServiceReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateBenificiary(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateBenificiary(m_user, "auth")).thenReturn(0);
//
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciary("benificiaryRequest",
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciary_IEMRSearchUserServiceThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateBenificiary(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateBenificiary(m_user, "auth")).thenReturn(0);
//
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciary("benificiaryRequest",
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetBeneficiariesByPhone() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure IEMRSearchUserService.findByBeneficiaryPhoneNo(...).
//        final BenPhoneMap benPhoneMap = new BenPhoneMap();
//        benPhoneMap.setBenificiaryRegID(0L);
//        benPhoneMap.setParentBenRegID(0L);
//        benPhoneMap.setDeleted(false);
//        benPhoneMap.setNuisanceCallCount(0);
//        benPhoneMap.setBenPhMapID(0L);
//        when(mockIemrSearchUserService.findByBeneficiaryPhoneNo(benPhoneMap, 0, 0, "auth")).thenReturn("result");
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getBeneficiariesByPhone("request",
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetBeneficiariesByPhone_IEMRSearchUserServiceThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure IEMRSearchUserService.findByBeneficiaryPhoneNo(...).
//        final BenPhoneMap benPhoneMap = new BenPhoneMap();
//        benPhoneMap.setBenificiaryRegID(0L);
//        benPhoneMap.setParentBenRegID(0L);
//        benPhoneMap.setDeleted(false);
//        benPhoneMap.setNuisanceCallCount(0);
//        benPhoneMap.setBenPhMapID(0L);
//        when(mockIemrSearchUserService.findByBeneficiaryPhoneNo(benPhoneMap, 0, 0, "auth")).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getBeneficiariesByPhone("request",
//                httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciaryCommunityorEducation() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateCommunityorEducation(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateCommunityorEducation(m_user, "auth")).thenReturn(0);
//
//        // Configure IEMRSearchUserService.userExitsCheckWithId(...).
//        final BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
//        beneficiaryModel.setBeneficiaryRegID(0L);
//        beneficiaryModel.setBeneficiaryID("beneficiaryID");
//        beneficiaryModel.setIs1097(false);
//        beneficiaryModel.setHealthID("HealthID");
//        beneficiaryModel.setHealthIDNumber("HealthIDNumber");
//        beneficiaryModel.setFamilyId("familyId");
//        beneficiaryModel.setIdentity("identity");
//        final List<BeneficiaryModel> beneficiaryModels = List.of(beneficiaryModel);
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenReturn(beneficiaryModels);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciaryCommunityorEducation(
//                "benificiaryRequest", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciaryCommunityorEducation_RegisterBenificiaryServiceThrowsIEMRException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateCommunityorEducation(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateCommunityorEducation(m_user, "auth")).thenThrow(IEMRException.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciaryCommunityorEducation(
//                "benificiaryRequest", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciaryCommunityorEducation_IEMRSearchUserServiceReturnsNoItems() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateCommunityorEducation(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateCommunityorEducation(m_user, "auth")).thenReturn(0);
//
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenReturn(Collections.emptyList());
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciaryCommunityorEducation(
//                "benificiaryRequest", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testUpdateBenefciaryCommunityorEducation_IEMRSearchUserServiceThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//
//        // Configure RegisterBenificiaryService.updateCommunityorEducation(...).
//        final BeneficiaryModel m_user = new BeneficiaryModel();
//        m_user.setBeneficiaryRegID(0L);
//        m_user.setBeneficiaryID("beneficiaryID");
//        m_user.setIs1097(false);
//        m_user.setHealthID("HealthID");
//        m_user.setHealthIDNumber("HealthIDNumber");
//        m_user.setFamilyId("familyId");
//        m_user.setIdentity("identity");
//        when(mockRegisterBenificiaryService.updateCommunityorEducation(m_user, "auth")).thenReturn(0);
//
//        when(mockIemrSearchUserService.userExitsCheckWithId(0L, "auth", false)).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.updateBenefciaryCommunityorEducation(
//                "benificiaryRequest", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetBeneficiaryIDs() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockRegisterBenificiaryService.generateBeneficiaryIDs(eq("request"),
//                any(HttpServletRequest.class))).thenReturn("result");
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getBeneficiaryIDs("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//
//    @Test
//    void testGetBeneficiaryIDs_RegisterBenificiaryServiceThrowsException() throws Exception {
//        // Setup
//        final MockHttpServletRequest httpRequest = new MockHttpServletRequest();
//        when(mockRegisterBenificiaryService.generateBeneficiaryIDs(eq("request"),
//                any(HttpServletRequest.class))).thenThrow(Exception.class);
//
//        // Run the test
//        final String result = beneficiaryRegistrationControllerUnderTest.getBeneficiaryIDs("request", httpRequest);
//
//        // Verify the results
//        assertEquals("result", result);
//    }
//}
