//package com.iemr.common.controller.beneficiary;
//
//import org.junit.jupiter.api.Timeout;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import com.iemr.common.service.beneficiary.RegisterBenificiaryService;
//import com.iemr.common.service.userbeneficiarydata.TitleService;
//import com.iemr.common.service.beneficiary.BenRelationshipTypeService;
//import com.iemr.common.data.location.States;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import jakarta.servlet.http.HttpServletRequest;
//import com.iemr.common.data.beneficiary.GovtIdentityType;
//import com.google.gson.Gson;
//import com.iemr.common.service.beneficiary.SexualOrientationService;
//import com.iemr.common.service.userbeneficiarydata.LanguageService;
//import com.iemr.common.data.userbeneficiarydata.Language;
//import com.iemr.common.service.beneficiary.BeneficiaryOccupationService;
//
//import java.util.ArrayList;
//
//import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
//import com.iemr.common.service.beneficiary.IEMRSearchUserService;
//import com.iemr.common.data.userbeneficiarydata.Gender;
//import com.iemr.common.model.beneficiary.BeneficiaryModel;
//import com.iemr.common.service.userbeneficiarydata.StatusService;
//import com.iemr.common.data.beneficiary.BeneficiaryEducation;
//import com.iemr.common.service.userbeneficiarydata.CommunityService;
//import com.iemr.common.data.directory.Directory;
//import com.iemr.common.service.beneficiary.GovtIdentityTypeService;
//import com.iemr.common.service.userbeneficiarydata.GenderService;
//import com.iemr.common.data.beneficiary.BenPhoneMap;
//import com.iemr.common.service.reports.CallReportsService;
//import com.iemr.common.service.location.LocationService;
//import com.iemr.common.service.directory.DirectoryService;
//import com.iemr.common.service.userbeneficiarydata.EducationService;
//import com.iemr.common.data.userbeneficiarydata.Status;
//import com.iemr.common.data.userbeneficiarydata.Community;
//import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
//import org.mockito.MockedStatic;
//import com.iemr.common.data.beneficiary.SexualOrientation;
//import com.iemr.common.data.userbeneficiarydata.Title;
//import com.iemr.common.data.beneficiary.BenRelationshipType;
//import com.iemr.common.service.userbeneficiarydata.MaritalStatusService;
//import com.iemr.common.utils.mapper.InputMapper;
//import com.iemr.common.utils.mapper.OutputMapper;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.atLeast;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.mockStatic;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.times;
//
//import org.junit.jupiter.api.Disabled;
//
//@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
//@ExtendWith(MockitoExtension.class)
//class BeneficiaryRegistrationControllerTest2 {
//
//    private final RegisterBenificiaryService registerBenificiaryServiceMock = mock(RegisterBenificiaryService.class, "registerBenificiaryService");
//
//    private final CallReportsService callReportsServiceMock = mock(CallReportsService.class, "callReportsService");
//
//    private final IEMRSearchUserService iemrSearchUserServiceMock = mock(IEMRSearchUserService.class, "iemrSearchUserService");
//
//    private final StatusService statusServiceMock = mock(StatusService.class, "statusService");
//
//    private final TitleService titleServiceMock = mock(TitleService.class, "titleService");
//
//    private final EducationService educationServiceMock = mock(EducationService.class, "educationService");
//
//    private final LocationService locationServiceMock = mock(LocationService.class, "locationService");
//
//    private final GenderService genderServiceMock = mock(GenderService.class, "genderService");
//
//    private final MaritalStatusService maritalStatusServiceMock = mock(MaritalStatusService.class, "maritalStatusService");
//
//    private final CommunityService communityServiceMock = mock(CommunityService.class, "communityService");
//
//    private final LanguageService languageServiceMock = mock(LanguageService.class, "languageService");
//
//    private final DirectoryService directoryServiceMock = mock(DirectoryService.class, "directoryService");
//
//    private final SexualOrientationService sexualOrientationServiceMock = mock(SexualOrientationService.class, "sexualOrientationService");
//
//    private final BenRelationshipTypeService benRelationshipTypeServiceMock = mock(BenRelationshipTypeService.class, "benRelationshipTypeService");
//
//    private final BeneficiaryOccupationService beneficiaryOccupationServiceMock = mock(BeneficiaryOccupationService.class, "beneficiaryOccupationService");
//
//    private final GovtIdentityTypeService govtIdentityTypeServiceMock = mock(GovtIdentityTypeService.class, "govtIdentityTypeService");
//
//    private AutoCloseable autoCloseableMocks;
//
//    @InjectMocks()
//    private BeneficiaryRegistrationController target;
//
//    @AfterEach()
//    public void afterTest() throws Exception {
//        if (autoCloseableMocks != null)
//            autoCloseableMocks.close();
//    }
//
//    //Sapient generated method id: ${3282fabd-3fc6-35d6-942c-db6e3d7e4aac}, hash: 4D036BC547EB8A9E3BBFB6ADB5495542
//    @Test()
//    void createBeneficiaryTest() throws Exception {
//        //Arrange Statement(s)
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "createBeneficiary_beneficiaryModel1");
//        HttpServletRequest httpServletRequestMock = mock(HttpServletRequest.class);
//        doReturn("A").when(registerBenificiaryServiceMock).save(beneficiaryModelMock, httpServletRequestMock);
//        //Act Statement(s)
//        String result = target.createBeneficiary(beneficiaryModelMock, httpServletRequestMock);
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(registerBenificiaryServiceMock).save(beneficiaryModelMock, httpServletRequestMock);
//        });
//    }
//
//    //Sapient generated method id: ${92f6f076-aaf4-34a0-b664-474ea716acb5}, hash: 87F72C61ABF42DE625014A7F42BFE0B4
//    @Test()
//    void createBeneficiaryWhenCaughtException() throws Exception {
//        /* Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "createBeneficiary_beneficiaryModel1");
//        HttpServletRequest httpServletRequestMock = mock(HttpServletRequest.class);
//        doReturn("A").when(registerBenificiaryServiceMock).save(beneficiaryModelMock, httpServletRequestMock);
//        //Act Statement(s)
//        String result = target.createBeneficiary(beneficiaryModelMock, httpServletRequestMock);
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(registerBenificiaryServiceMock).save(beneficiaryModelMock, httpServletRequestMock);
//        });
//    }
//
//    //Sapient generated method id: ${81584395-2708-321d-bde3-65cb59b07751}, hash: 55B7EFF7E612EADE5C1476A5ECF27161
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenIBeneficiaryIsNull() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : true* (iBeneficiary != null) : false*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn("return_of_getBeneficiaryID1").when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn(null).when(iemrSearchUserServiceMock).userExitsCheckWithId("return_of_getBeneficiaryID1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock, times(2)).getBeneficiaryID();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId("return_of_getBeneficiaryID1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${afd761b4-f8fd-389d-8f0b-71667269b029}, hash: B7B824E452CCCDF91BB44B9CFD3D3273
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenIBeneficiaryIsNullAndCaughtException() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : true* (iBeneficiary != null) : false* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("E", BeneficiaryModel.class);
//            doReturn("return_of_getBeneficiaryID1").when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn(null).when(iemrSearchUserServiceMock).userExitsCheckWithId("return_of_getBeneficiaryID1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("E", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("E", BeneficiaryModel.class);
//                verify(beneficiaryModelMock, times(2)).getBeneficiaryID();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId("return_of_getBeneficiaryID1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${62b931d9-0166-3210-8857-f19e966e9d06}, hash: 4BB80625C2E4F7E18EBD4A3DFC2A57B3
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetBeneficiaryRegIDIsNotNullAndIBeneficiaryIsNotNull() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : true* (iBeneficiary != null) : true*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(0L).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock, times(2)).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${610355f2-a555-3c51-8a43-58166e07f63c}, hash: 761513383F5F4E61638EE601B47F0B4F
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenIBeneficiaryIsNotNullAndCaughtException() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : true* (iBeneficiary != null) : true* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(0L).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock, times(2)).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${3b75e648-3bef-3a14-a436-6e041b4048d2}, hash: 899DE3BA90644C55D43CD17A09170A52
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetHealthIDIsNotNullAndIBeneficiaryIsNotNull() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : true* (iBeneficiary != null) : true*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn("return_of_getHealthID1").when(beneficiaryModelMock).getHealthID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithHealthId_ABHAId("return_of_getHealthID1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock, times(2)).getHealthID();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithHealthId_ABHAId("return_of_getHealthID1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${7c6a9a36-30e8-3a39-b4dc-90f466f5d5ff}, hash: FF8ECB91B52DE156BC63111975FBFF5B
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetHealthIDIsNotNullAndIBeneficiaryIsNotNullAndCaughtException() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : true* (iBeneficiary != null) : true* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn("return_of_getHealthID1").when(beneficiaryModelMock).getHealthID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithHealthId_ABHAId("return_of_getHealthID1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock, times(2)).getHealthID();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithHealthId_ABHAId("return_of_getHealthID1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${60848e0b-a509-37eb-a7c1-c8a65fe9b9ed}, hash: 80C76130E9AC4B8409EA0CE064256931
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetHealthIDNumberIsNotNullAndIBeneficiaryIsNotNull() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : false* (benificiaryDetails.getHealthIDNumber() != null) : true* (iBeneficiary != null) : true*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(null).when(beneficiaryModelMock).getHealthID();
//            doReturn("return_of_getHealthIDNumber1").when(beneficiaryModelMock).getHealthIDNumber();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithHealthIdNo_ABHAIdNo("return_of_getHealthIDNumber1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getHealthID();
//                verify(beneficiaryModelMock, times(2)).getHealthIDNumber();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithHealthIdNo_ABHAIdNo("return_of_getHealthIDNumber1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${b5cc2bdd-791a-33ee-aad6-c4fe4fd4b6f7}, hash: DA60022F13CC4236B4BE5EB709328BF8
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetHealthIDNumberIsNotNullAndIBeneficiaryIsNotNullAndCaughtException() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : false* (benificiaryDetails.getHealthIDNumber() != null) : true* (iBeneficiary != null) : true* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(null).when(beneficiaryModelMock).getHealthID();
//            doReturn("return_of_getHealthIDNumber1").when(beneficiaryModelMock).getHealthIDNumber();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithHealthIdNo_ABHAIdNo("return_of_getHealthIDNumber1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getHealthID();
//                verify(beneficiaryModelMock, times(2)).getHealthIDNumber();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithHealthIdNo_ABHAIdNo("return_of_getHealthIDNumber1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${185f2afa-9aee-31cf-b41d-8b632f882e11}, hash: A845D8D8DA853E1FDA14E85A58E673A0
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetFamilyIdIsNotNullAndIBeneficiaryIsNotNull() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : false* (benificiaryDetails.getHealthIDNumber() != null) : false* (benificiaryDetails.getFamilyId() != null) : true* (iBeneficiary != null) : true*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(null).when(beneficiaryModelMock).getHealthID();
//            doReturn(null).when(beneficiaryModelMock).getHealthIDNumber();
//            doReturn("return_of_getFamilyId1").when(beneficiaryModelMock).getFamilyId();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithFamilyId("return_of_getFamilyId1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getHealthID();
//                verify(beneficiaryModelMock).getHealthIDNumber();
//                verify(beneficiaryModelMock, times(2)).getFamilyId();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithFamilyId("return_of_getFamilyId1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${81076683-9991-3cf8-82ca-9da1f97e57d8}, hash: 8E07DEC8B228E4AC7C122EAB813C6E46
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetFamilyIdIsNotNullAndIBeneficiaryIsNotNullAndCaughtException() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : false* (benificiaryDetails.getHealthIDNumber() != null) : false* (benificiaryDetails.getFamilyId() != null) : true* (iBeneficiary != null) : true* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(null).when(beneficiaryModelMock).getHealthID();
//            doReturn(null).when(beneficiaryModelMock).getHealthIDNumber();
//            doReturn("return_of_getFamilyId1").when(beneficiaryModelMock).getFamilyId();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithFamilyId("return_of_getFamilyId1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getHealthID();
//                verify(beneficiaryModelMock).getHealthIDNumber();
//                verify(beneficiaryModelMock, times(2)).getFamilyId();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithFamilyId("return_of_getFamilyId1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${f21cf8e4-32c9-318a-881c-42d0b5cc88e7}, hash: 2C8580FDDEA9BF51A49DEF7B3A8518EA
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetIdentityIsNotNullAndIBeneficiaryIsNotNull() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : false* (benificiaryDetails.getHealthIDNumber() != null) : false* (benificiaryDetails.getFamilyId() != null) : false* (benificiaryDetails.getIdentity() != null) : true* (iBeneficiary != null) : true*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(null).when(beneficiaryModelMock).getHealthID();
//            doReturn(null).when(beneficiaryModelMock).getHealthIDNumber();
//            doReturn(null).when(beneficiaryModelMock).getFamilyId();
//            doReturn("return_of_getIdentity1").when(beneficiaryModelMock).getIdentity();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithGovIdentity("return_of_getIdentity1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getHealthID();
//                verify(beneficiaryModelMock).getHealthIDNumber();
//                verify(beneficiaryModelMock).getFamilyId();
//                verify(beneficiaryModelMock, times(2)).getIdentity();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithGovIdentity("return_of_getIdentity1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${da5104f6-e951-3538-a7cd-ec3ad3ac3d40}, hash: 2112C400843665505A045CB336F601D0
//    @Disabled()
//    @Test()
//    void searchUserByIDWhenBenificiaryDetailsGetIdentityIsNotNullAndIBeneficiaryIsNotNullAndCaughtException() throws Exception {
//        /* Branches:* (benificiaryDetails.getBeneficiaryID() != null) : false* (benificiaryDetails.getBeneficiaryRegID() != null) : false* (benificiaryDetails.getHealthID() != null) : false* (benificiaryDetails.getHealthIDNumber() != null) : false* (benificiaryDetails.getFamilyId() != null) : false* (benificiaryDetails.getIdentity() != null) : true* (iBeneficiary != null) : true* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchUserByID_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class);
//             MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryID();
//            doReturn(null).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(null).when(beneficiaryModelMock).getHealthID();
//            doReturn(null).when(beneficiaryModelMock).getHealthIDNumber();
//            doReturn(null).when(beneficiaryModelMock).getFamilyId();
//            doReturn("return_of_getIdentity1").when(beneficiaryModelMock).getIdentity();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithGovIdentity("return_of_getIdentity1", "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.searchUserByID("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryID();
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getHealthID();
//                verify(beneficiaryModelMock).getHealthIDNumber();
//                verify(beneficiaryModelMock).getFamilyId();
//                verify(beneficiaryModelMock, times(2)).getIdentity();
//                verify(beneficiaryModelMock).getIs1097();
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).userExitsCheckWithGovIdentity("return_of_getIdentity1", "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${702af48d-9d50-34ef-a910-6381723f4644}, hash: 73C9F9ADE5F84908D40972C1FE95CA10
//    @Disabled()
//    @Test()
//    void searchUserByPhoneWhenRequestObjHasRowsPerPage() throws Exception {
//        /* Branches:* (requestObj.has("pageNo")) : true* (requestObj.has("rowsPerPage")) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: requestObj*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        BenPhoneMap benPhoneMapMock = mock(BenPhoneMap.class, "searchUserByPhone_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn("B").when(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 1, 1, "return_of_getHeader1");
//            //Act Statement(s)
//            String result = target.searchUserByPhone("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 1, 1, "return_of_getHeader1");
//            });
//        }
//    }
//
//    //Sapient generated method id: ${e2b14e76-382f-3908-8cd9-b96ed5b1ffbc}, hash: 992FE03B22C538C579499DCA0B3D1D73
//    @Disabled()
//    @Test()
//    void searchUserByPhoneWhenRequestObjNotHasPageNoAndRequestObjNotHasRowsPerPage() throws Exception {
//        /* Branches:* (requestObj.has("pageNo")) : false* (requestObj.has("rowsPerPage")) : false** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: requestObj*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        BenPhoneMap benPhoneMapMock = mock(BenPhoneMap.class, "searchUserByPhone_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn("B").when(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            //Act Statement(s)
//            String result = target.searchUserByPhone("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            });
//        }
//    }
//
//    //Sapient generated method id: ${9c0f62ec-0aba-34f8-bc97-e67779e3de3e}, hash: B6F32A4FD841CC2A749BF373E1F688AA
//    @Disabled()
//    @Test()
//    void searchUserByPhoneWhenCaughtJSONException() throws Exception {
//        /* Branches:* (requestObj.has("pageNo")) : true* (requestObj.has("rowsPerPage")) : true* (catch-exception (JSONException)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response, requestObj*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        BenPhoneMap benPhoneMapMock = mock(BenPhoneMap.class, "searchUserByPhone_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn("B").when(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 1, 1, "return_of_getHeader1");
//            //Act Statement(s)
//            String result = target.searchUserByPhone("D", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 1, 1, "return_of_getHeader1");
//            });
//        }
//    }
//
//    //Sapient generated method id: ${0fb91528-c274-3139-a8d2-92c69f7b7c05}, hash: 9B3FBAC9C4581584AE2CA675DE8EB91A
//    @Disabled()
//    @Test()
//    void searchUserByPhoneWhenRequestObjNotHasPageNoAndRequestObjNotHasRowsPerPageAndCaughtException() throws Exception {
//        /* Branches:* (requestObj.has("pageNo")) : false* (requestObj.has("rowsPerPage")) : false* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response, requestObj*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        BenPhoneMap benPhoneMapMock = mock(BenPhoneMap.class, "searchUserByPhone_object1");
//        try (MockedStatic<OutputMapper> outputMapper = mockStatic(OutputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            Gson gson = new Gson();
//            outputMapper.when(() -> OutputMapper.gsonWithoutExposeRestriction()).thenReturn(gson);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn("B").when(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            //Act Statement(s)
//            String result = target.searchUserByPhone("D", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                outputMapper.verify(() -> OutputMapper.gsonWithoutExposeRestriction(), atLeast(1));
//                verify(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            });
//        }
//    }
//
//    //Sapient generated method id: ${63a21d0a-0cda-3c63-b7e3-7c0d16411680}, hash: 903D4FF828E9C57B4C64A1D6F30B2F34
//    @Test()
//    void searchBeneficiaryTest() throws Exception {
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchBeneficiary_beneficiaryModel1");
//        doReturn("A").when(iemrSearchUserServiceMock).findBeneficiary(beneficiaryModelMock, "return_of_getHeader1");
//        //Act Statement(s)
//        String result = target.searchBeneficiary(beneficiaryModelMock, httpRequestMock);
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(httpRequestMock).getHeader("authorization");
//            verify(iemrSearchUserServiceMock).findBeneficiary(beneficiaryModelMock, "return_of_getHeader1");
//        });
//    }
//
//    //Sapient generated method id: ${6c630a30-a768-33f6-8919-0b287fab1f22}, hash: DDB53C8C92FFEF423AE9E5E5736A4CA6
//    @Test()
//    void searchBeneficiaryWhenCaughtNumberFormatException() throws Exception {
//        /* Branches:* (catch-exception (NumberFormatException)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: output*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchBeneficiary_beneficiaryModel1");
//        doReturn("A").when(iemrSearchUserServiceMock).findBeneficiary(beneficiaryModelMock, "return_of_getHeader1");
//        //Act Statement(s)
//        String result = target.searchBeneficiary(beneficiaryModelMock, httpRequestMock);
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(httpRequestMock).getHeader("authorization");
//            verify(iemrSearchUserServiceMock).findBeneficiary(beneficiaryModelMock, "return_of_getHeader1");
//        });
//    }
//
//    //Sapient generated method id: ${81c1b129-da3b-36b2-aed1-4619392e97d0}, hash: 1B57F8ED93F881A6507AE76DC0D9F60B
//    @Test()
//    void searchBeneficiaryWhenCaughtException() throws Exception {
//        /* Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: output*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class, "searchBeneficiary_beneficiaryModel1");
//        doReturn("A").when(iemrSearchUserServiceMock).findBeneficiary(beneficiaryModelMock, "return_of_getHeader1");
//        //Act Statement(s)
//        String result = target.searchBeneficiary(beneficiaryModelMock, httpRequestMock);
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(httpRequestMock).getHeader("authorization");
//            verify(iemrSearchUserServiceMock).findBeneficiary(beneficiaryModelMock, "return_of_getHeader1");
//        });
//    }
//
//    //Sapient generated method id: ${eb3b2319-a71a-33c2-bed9-78ac422a0341}, hash: 17F2B9A007C912004EAA4604554EEC95
//    @Disabled()
//    @Test()
//    void getRegistrationDataTest() throws Exception {
//        //Arrange Statement(s)
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        List<Status> statusList = new ArrayList<>();
//        doReturn(statusList).when(statusServiceMock).getActiveStatus();
//        List<Title> titleList = new ArrayList<>();
//        doReturn(titleList).when(titleServiceMock).getActiveTitles();
//        List<BeneficiaryEducation> beneficiaryEducationList = new ArrayList<>();
//        doReturn(beneficiaryEducationList).when(educationServiceMock).getActiveEducations();
//        List<States> statesList = new ArrayList<>();
//        doReturn(statesList).when(locationServiceMock).getStates(1);
//        List<Gender> genderList = new ArrayList<>();
//        doReturn(genderList).when(genderServiceMock).getActiveGenders();
//        List<MaritalStatus> maritalStatusList = new ArrayList<>();
//        doReturn(maritalStatusList).when(maritalStatusServiceMock).getActiveMaritalStatus();
//        List<Community> communityList = new ArrayList<>();
//        doReturn(communityList).when(communityServiceMock).getActiveCommunities();
//        List<Language> languageList = new ArrayList<>();
//        doReturn(languageList).when(languageServiceMock).getActiveLanguages();
//        List<Directory> directoryList = new ArrayList<>();
//        doReturn(directoryList).when(directoryServiceMock).getDirectories();
//        List<SexualOrientation> sexualOrientationList = new ArrayList<>();
//        doReturn(sexualOrientationList).when(sexualOrientationServiceMock).getSexualOrientations();
//        List<BenRelationshipType> benRelationshipTypeList = new ArrayList<>();
//        doReturn(benRelationshipTypeList).when(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//        List<BeneficiaryOccupation> beneficiaryOccupationList = new ArrayList<>();
//        doReturn(beneficiaryOccupationList).when(beneficiaryOccupationServiceMock).getActiveOccupations();
//        List<GovtIdentityType> govtIdentityTypeList = new ArrayList<>();
//        doReturn(govtIdentityTypeList).when(govtIdentityTypeServiceMock).getActiveIDTypes();
//        //Act Statement(s)
//        String result = target.getRegistrationData();
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(statusServiceMock).getActiveStatus();
//            verify(titleServiceMock).getActiveTitles();
//            verify(educationServiceMock).getActiveEducations();
//            verify(locationServiceMock).getStates(1);
//            verify(genderServiceMock).getActiveGenders();
//            verify(maritalStatusServiceMock).getActiveMaritalStatus();
//            verify(communityServiceMock).getActiveCommunities();
//            verify(languageServiceMock).getActiveLanguages();
//            verify(directoryServiceMock).getDirectories();
//            verify(sexualOrientationServiceMock).getSexualOrientations();
//            verify(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//            verify(beneficiaryOccupationServiceMock).getActiveOccupations();
//            verify(govtIdentityTypeServiceMock).getActiveIDTypes();
//        });
//    }
//
//    //Sapient generated method id: ${0881735f-d673-3197-8bf3-8b0488d88480}, hash: 43DE1F0325B030BC04B91817E67EACF3
//    @Disabled()
//    @Test()
//    void getRegistrationDataWhenCaughtException() throws Exception {
//        /* Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        List<Status> statusList = new ArrayList<>();
//        doReturn(statusList).when(statusServiceMock).getActiveStatus();
//        List<Title> titleList = new ArrayList<>();
//        doReturn(titleList).when(titleServiceMock).getActiveTitles();
//        List<BeneficiaryEducation> beneficiaryEducationList = new ArrayList<>();
//        doReturn(beneficiaryEducationList).when(educationServiceMock).getActiveEducations();
//        List<States> statesList = new ArrayList<>();
//        doReturn(statesList).when(locationServiceMock).getStates(1);
//        List<Gender> genderList = new ArrayList<>();
//        doReturn(genderList).when(genderServiceMock).getActiveGenders();
//        List<MaritalStatus> maritalStatusList = new ArrayList<>();
//        doReturn(maritalStatusList).when(maritalStatusServiceMock).getActiveMaritalStatus();
//        List<Community> communityList = new ArrayList<>();
//        doReturn(communityList).when(communityServiceMock).getActiveCommunities();
//        List<Language> languageList = new ArrayList<>();
//        doReturn(languageList).when(languageServiceMock).getActiveLanguages();
//        List<Directory> directoryList = new ArrayList<>();
//        doReturn(directoryList).when(directoryServiceMock).getDirectories();
//        List<SexualOrientation> sexualOrientationList = new ArrayList<>();
//        doReturn(sexualOrientationList).when(sexualOrientationServiceMock).getSexualOrientations();
//        List<BenRelationshipType> benRelationshipTypeList = new ArrayList<>();
//        doReturn(benRelationshipTypeList).when(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//        List<BeneficiaryOccupation> beneficiaryOccupationList = new ArrayList<>();
//        doReturn(beneficiaryOccupationList).when(beneficiaryOccupationServiceMock).getActiveOccupations();
//        List<GovtIdentityType> govtIdentityTypeList = new ArrayList<>();
//        doReturn(govtIdentityTypeList).when(govtIdentityTypeServiceMock).getActiveIDTypes();
//        //Act Statement(s)
//        String result = target.getRegistrationData();
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(statusServiceMock).getActiveStatus();
//            verify(titleServiceMock).getActiveTitles();
//            verify(educationServiceMock).getActiveEducations();
//            verify(locationServiceMock).getStates(1);
//            verify(genderServiceMock).getActiveGenders();
//            verify(maritalStatusServiceMock).getActiveMaritalStatus();
//            verify(communityServiceMock).getActiveCommunities();
//            verify(languageServiceMock).getActiveLanguages();
//            verify(directoryServiceMock).getDirectories();
//            verify(sexualOrientationServiceMock).getSexualOrientations();
//            verify(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//            verify(beneficiaryOccupationServiceMock).getActiveOccupations();
//            verify(govtIdentityTypeServiceMock).getActiveIDTypes();
//        });
//    }
//
//    //Sapient generated method id: ${f3a58c6a-9f7b-3b07-b6b4-70d51980511a}, hash: F12A78DFDAA332174CEE15CF96740129
//    @Disabled()
//    @Test()
//    void getRegistrationDataV1Test() throws Exception {
//        //Arrange Statement(s)
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        Directory directoryMock = mock(Directory.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(directoryMock).when(inputMapperMock).fromJson("request1", Directory.class);
//            doReturn(0).when(directoryMock).getProviderServiceMapID();
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<Status> statusList = new ArrayList<>();
//            doReturn(statusList).when(statusServiceMock).getActiveStatus();
//            List<Title> titleList = new ArrayList<>();
//            doReturn(titleList).when(titleServiceMock).getActiveTitles();
//            List<BeneficiaryEducation> beneficiaryEducationList = new ArrayList<>();
//            doReturn(beneficiaryEducationList).when(educationServiceMock).getActiveEducations();
//            List<States> statesList = new ArrayList<>();
//            doReturn(statesList).when(locationServiceMock).getStates(1);
//            List<Gender> genderList = new ArrayList<>();
//            doReturn(genderList).when(genderServiceMock).getActiveGenders();
//            List<MaritalStatus> maritalStatusList = new ArrayList<>();
//            doReturn(maritalStatusList).when(maritalStatusServiceMock).getActiveMaritalStatus();
//            List<Community> communityList = new ArrayList<>();
//            doReturn(communityList).when(communityServiceMock).getActiveCommunities();
//            List<Language> languageList = new ArrayList<>();
//            doReturn(languageList).when(languageServiceMock).getActiveLanguages();
//            List<Directory> directoryList = new ArrayList<>();
//            doReturn(directoryList).when(directoryServiceMock).getDirectories(0);
//            List<SexualOrientation> sexualOrientationList = new ArrayList<>();
//            doReturn(sexualOrientationList).when(sexualOrientationServiceMock).getSexualOrientations();
//            List<BenRelationshipType> benRelationshipTypeList = new ArrayList<>();
//            doReturn(benRelationshipTypeList).when(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//            List<BeneficiaryOccupation> beneficiaryOccupationList = new ArrayList<>();
//            doReturn(beneficiaryOccupationList).when(beneficiaryOccupationServiceMock).getActiveOccupations();
//            List<GovtIdentityType> govtIdentityTypeList = new ArrayList<>();
//            doReturn(govtIdentityTypeList).when(govtIdentityTypeServiceMock).getActiveIDTypes();
//            //Act Statement(s)
//            String result = target.getRegistrationDataV1("request1");
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("request1", Directory.class);
//                verify(directoryMock).getProviderServiceMapID();
//                verify(statusServiceMock).getActiveStatus();
//                verify(titleServiceMock).getActiveTitles();
//                verify(educationServiceMock).getActiveEducations();
//                verify(locationServiceMock).getStates(1);
//                verify(genderServiceMock).getActiveGenders();
//                verify(maritalStatusServiceMock).getActiveMaritalStatus();
//                verify(communityServiceMock).getActiveCommunities();
//                verify(languageServiceMock).getActiveLanguages();
//                verify(directoryServiceMock).getDirectories(0);
//                verify(sexualOrientationServiceMock).getSexualOrientations();
//                verify(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//                verify(beneficiaryOccupationServiceMock).getActiveOccupations();
//                verify(govtIdentityTypeServiceMock).getActiveIDTypes();
//            });
//        }
//    }
//
//    //Sapient generated method id: ${5a95be1f-ded8-38b5-86f6-5288c389512e}, hash: B216BD03D2A9DC9D61F4484C47B03864
//    @Disabled()
//    @Test()
//    void getRegistrationDataV1WhenCaughtException() throws Exception {
//        /* Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        Directory directoryMock = mock(Directory.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(directoryMock).when(inputMapperMock).fromJson("request1", Directory.class);
//            doReturn(0).when(directoryMock).getProviderServiceMapID();
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            List<Status> statusList = new ArrayList<>();
//            doReturn(statusList).when(statusServiceMock).getActiveStatus();
//            List<Title> titleList = new ArrayList<>();
//            doReturn(titleList).when(titleServiceMock).getActiveTitles();
//            List<BeneficiaryEducation> beneficiaryEducationList = new ArrayList<>();
//            doReturn(beneficiaryEducationList).when(educationServiceMock).getActiveEducations();
//            List<States> statesList = new ArrayList<>();
//            doReturn(statesList).when(locationServiceMock).getStates(1);
//            List<Gender> genderList = new ArrayList<>();
//            doReturn(genderList).when(genderServiceMock).getActiveGenders();
//            List<MaritalStatus> maritalStatusList = new ArrayList<>();
//            doReturn(maritalStatusList).when(maritalStatusServiceMock).getActiveMaritalStatus();
//            List<Community> communityList = new ArrayList<>();
//            doReturn(communityList).when(communityServiceMock).getActiveCommunities();
//            List<Language> languageList = new ArrayList<>();
//            doReturn(languageList).when(languageServiceMock).getActiveLanguages();
//            List<Directory> directoryList = new ArrayList<>();
//            doReturn(directoryList).when(directoryServiceMock).getDirectories(0);
//            List<SexualOrientation> sexualOrientationList = new ArrayList<>();
//            doReturn(sexualOrientationList).when(sexualOrientationServiceMock).getSexualOrientations();
//            List<BenRelationshipType> benRelationshipTypeList = new ArrayList<>();
//            doReturn(benRelationshipTypeList).when(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//            List<BeneficiaryOccupation> beneficiaryOccupationList = new ArrayList<>();
//            doReturn(beneficiaryOccupationList).when(beneficiaryOccupationServiceMock).getActiveOccupations();
//            List<GovtIdentityType> govtIdentityTypeList = new ArrayList<>();
//            doReturn(govtIdentityTypeList).when(govtIdentityTypeServiceMock).getActiveIDTypes();
//            //Act Statement(s)
//            String result = target.getRegistrationDataV1("request1");
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("request1", Directory.class);
//                verify(directoryMock).getProviderServiceMapID();
//                verify(statusServiceMock).getActiveStatus();
//                verify(titleServiceMock).getActiveTitles();
//                verify(educationServiceMock).getActiveEducations();
//                verify(locationServiceMock).getStates(1);
//                verify(genderServiceMock).getActiveGenders();
//                verify(maritalStatusServiceMock).getActiveMaritalStatus();
//                verify(communityServiceMock).getActiveCommunities();
//                verify(languageServiceMock).getActiveLanguages();
//                verify(directoryServiceMock).getDirectories(0);
//                verify(sexualOrientationServiceMock).getSexualOrientations();
//                verify(benRelationshipTypeServiceMock).getActiveRelationshipTypes();
//                verify(beneficiaryOccupationServiceMock).getActiveOccupations();
//                verify(govtIdentityTypeServiceMock).getActiveIDTypes();
//            });
//        }
//    }
//
//    //Sapient generated method id: ${226f92e7-2879-3099-981f-7342bbf545da}, hash: 1FEAE70D072AFB436C0B6AA0573BA84D
//    @Disabled()
//    @Test()
//    void updateBenefciaryWhenUpdateCountGreaterThan0() throws Exception {
//        /* Branches:* (updateCount > 0) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: updatedUserData, object of type JSONObject, responseObj, object of type Gson*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//            doReturn(0L).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn(1).when(registerBenificiaryServiceMock).updateBenificiary(beneficiaryModelMock, "return_of_getHeader1");
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.updateBenefciary("benificiaryRequest1", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getIs1097();
//                verify(registerBenificiaryServiceMock).updateBenificiary(beneficiaryModelMock, "return_of_getHeader1");
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${3fb89571-83fa-321b-80b4-3a6830a8fd23}, hash: 725A5421D1099B07D4FFD86F1298CBC1
//    @Disabled()
//    @Test()
//    void updateBenefciaryWhenCaughtJSONException() throws Exception {
//        /* Branches:* (updateCount > 0) : true* (catch-exception (JSONException)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: updatedUserData, response, object of type JSONObject, responseObj, object of type Gson*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//            doReturn(0L).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn(1).when(registerBenificiaryServiceMock).updateBenificiary(beneficiaryModelMock, "return_of_getHeader1");
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.updateBenefciary("benificiaryRequest1", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getIs1097();
//                verify(registerBenificiaryServiceMock).updateBenificiary(beneficiaryModelMock, "return_of_getHeader1");
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${0f6b61f2-0fc9-3a05-8865-e2a3cb41ab36}, hash: 0B62704100A3A95FFF5FF9CDE78A9BDF
//    @Disabled()
//    @Test()
//    void updateBenefciaryWhenCaughtException() throws Exception {
//        /* Branches:* (updateCount > 0) : true* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: updatedUserData, response, object of type JSONObject, responseObj, object of type Gson*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//            doReturn(0L).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn(1).when(registerBenificiaryServiceMock).updateBenificiary(beneficiaryModelMock, "return_of_getHeader1");
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.updateBenefciary("benificiaryRequest1", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getIs1097();
//                verify(registerBenificiaryServiceMock).updateBenificiary(beneficiaryModelMock, "return_of_getHeader1");
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${147d22bb-a4b6-3c05-b8e1-621d624e7f49}, hash: FF7E88074A92814A174DB21204A0AC7B
//    @Test()
//    void getBeneficiariesByPhoneTest() throws Exception {
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BenPhoneMap benPhoneMapMock = mock(BenPhoneMap.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(benPhoneMapMock).when(inputMapperMock).fromJson("A", BenPhoneMap.class);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn("B").when(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            //Act Statement(s)
//            String result = target.getBeneficiariesByPhone("A", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("A", BenPhoneMap.class);
//                verify(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            });
//        }
//    }
//
//    //Sapient generated method id: ${ba67a61b-00c1-3a15-ac3d-70eb9999a650}, hash: 6F0AB8485E03808B3ACB5EB830AD980F
//    @Test()
//    void getBeneficiariesByPhoneWhenCaughtException() throws Exception {
//        /* Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BenPhoneMap benPhoneMapMock = mock(BenPhoneMap.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(benPhoneMapMock).when(inputMapperMock).fromJson("D", BenPhoneMap.class);
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn("B").when(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            //Act Statement(s)
//            String result = target.getBeneficiariesByPhone("D", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("D", BenPhoneMap.class);
//                verify(iemrSearchUserServiceMock).findByBeneficiaryPhoneNo(benPhoneMapMock, 0, 1000, "return_of_getHeader1");
//            });
//        }
//    }
//
//    //Sapient generated method id: ${3cb9b57d-6d85-3b62-ab80-ae6e41cd3a78}, hash: 50DFDFB00D06350B6224850CC5C23BFD
//    @Disabled()
//    @Test()
//    void updateBenefciaryCommunityorEducationWhenUpdateCountGreaterThan0() throws Exception {
//        /* Branches:* (updateCount > 0) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: updatedUserData, object of type JSONObject, responseObj, object of type Gson*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//            doReturn(0L).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn(1).when(registerBenificiaryServiceMock).updateCommunityorEducation(beneficiaryModelMock, "return_of_getHeader1");
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.updateBenefciaryCommunityorEducation("benificiaryRequest1", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getIs1097();
//                verify(registerBenificiaryServiceMock).updateCommunityorEducation(beneficiaryModelMock, "return_of_getHeader1");
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${cad22c2f-4386-3c20-9442-e6f37977d009}, hash: 302C1EB7E6B566EA510EEEC65A6A194C
//    @Disabled()
//    @Test()
//    void updateBenefciaryCommunityorEducationWhenCaughtException() throws Exception {
//        /* Branches:* (updateCount > 0) : true* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: updatedUserData, response, object of type JSONObject, responseObj, object of type Gson*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
//        InputMapper inputMapperMock = mock(InputMapper.class);
//        BeneficiaryModel beneficiaryModelMock = mock(BeneficiaryModel.class);
//        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
//            doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("authorization");
//            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
//            doReturn(beneficiaryModelMock).when(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//            doReturn(0L).when(beneficiaryModelMock).getBeneficiaryRegID();
//            doReturn(false).when(beneficiaryModelMock).getIs1097();
//            target = new BeneficiaryRegistrationController();
//            autoCloseableMocks = MockitoAnnotations.openMocks(this);
//            doReturn(1).when(registerBenificiaryServiceMock).updateCommunityorEducation(beneficiaryModelMock, "return_of_getHeader1");
//            List<BeneficiaryModel> beneficiaryModelList = new ArrayList<>();
//            doReturn(beneficiaryModelList).when(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            //Act Statement(s)
//            String result = target.updateBenefciaryCommunityorEducation("benificiaryRequest1", httpRequestMock);
//            //Assert statement(s)
//            assertAll("result", () -> {
//                assertThat(result, equalTo("{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//                verify(httpRequestMock).getHeader("authorization");
//                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
//                verify(inputMapperMock).fromJson("benificiaryRequest1", BeneficiaryModel.class);
//                verify(beneficiaryModelMock).getBeneficiaryRegID();
//                verify(beneficiaryModelMock).getIs1097();
//                verify(registerBenificiaryServiceMock).updateCommunityorEducation(beneficiaryModelMock, "return_of_getHeader1");
//                verify(iemrSearchUserServiceMock).userExitsCheckWithId(0L, "return_of_getHeader1", false);
//            });
//        }
//    }
//
//    //Sapient generated method id: ${8955c6eb-3af1-36ef-8931-b87bc0e487da}, hash: 0D8A3F8FBEC921D9BC07FB311CD4AA64
//    @Test()
//    void getBeneficiaryIDsTest() throws Exception {
//        //Arrange Statement(s)
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        HttpServletRequest httpServletRequestMock = mock(HttpServletRequest.class);
//        doReturn("B").when(registerBenificiaryServiceMock).generateBeneficiaryIDs("", httpServletRequestMock);
//        //Act Statement(s)
//        String result = target.getBeneficiaryIDs("", httpServletRequestMock);
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(registerBenificiaryServiceMock).generateBeneficiaryIDs("", httpServletRequestMock);
//        });
//    }
//
//    //Sapient generated method id: ${be60c1d3-11bc-307c-9acd-cae8885524e8}, hash: 21E2427BFB0D6FCC7738B20531A2E5B9
//    @Test()
//    void getBeneficiaryIDsWhenCaughtException() throws Exception {
//        /* Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: response*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
//        //Arrange Statement(s)
//        target = new BeneficiaryRegistrationController();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        HttpServletRequest httpServletRequestMock = mock(HttpServletRequest.class);
//        doReturn("B").when(registerBenificiaryServiceMock).generateBeneficiaryIDs("", httpServletRequestMock);
//        //Act Statement(s)
//        String result = target.getBeneficiaryIDs("", httpServletRequestMock);
//        //Assert statement(s)
//        assertAll("result", () -> {
//            assertThat(result, equalTo("{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
//            verify(registerBenificiaryServiceMock).generateBeneficiaryIDs("", httpServletRequestMock);
//        });
//    }
//}
