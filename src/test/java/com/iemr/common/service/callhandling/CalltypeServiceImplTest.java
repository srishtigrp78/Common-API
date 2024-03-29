package com.iemr.common.service.callhandling;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.iemr.common.utils.exception.IEMRException;
import org.json.JSONException;

import java.util.List;

import com.iemr.common.data.callhandling.CallType;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.HashSet;

import org.mockito.MockedStatic;
import com.iemr.common.repository.callhandling.IEMRCalltypeRepositoryImplCustom;
import com.iemr.common.utils.mapper.InputMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Disabled;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class CalltypeServiceImplTest {

    private final IEMRCalltypeRepositoryImplCustom iEMRCalltypeRepositoryImplCustomMock = mock(IEMRCalltypeRepositoryImplCustom.class, "iEMRCalltypeRepositoryImplCustom");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private CalltypeServiceImpl target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //Sapient generated method id: ${fc5e8a75-8e60-3d38-bcb4-165bf779237d}, hash: 2BEC5AB3FCAB3C3DA9968DD75ADEB73E
    @Test()
    void getAllCalltypesWhenObjectIsNotNullAndObjectLengthGreaterThanOrEqualsTo8() throws IEMRException {
        /* Branches:* (provider.getIsInbound() != null) : true* (provider.getIsOutbound() != null) : true* (for-each(callTypesArray)) : true* (object != null) : true* (object.length >= 8) : true*/
        //Arrange Statement(s)
        InputMapper inputMapperMock = mock(InputMapper.class);
        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
            CallType callType = new CallType();
            callType.setIsInbound(false);
            callType.setIsOutbound(false);
            callType.setProviderServiceMapID(0);
            doReturn(callType).when(inputMapperMock).fromJson("request1", CallType.class);
            target = new CalltypeServiceImpl();
            autoCloseableMocks = MockitoAnnotations.openMocks(this);
            Object[] objectArray = new Object[]{"A", 1, "B", "C", false, false, false, false};
            Set<Object[]> objectSet = new HashSet<>();
            objectSet.add(objectArray);
            doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0, false, false);
            //Act Statement(s)
            List<CallType> result = target.getAllCalltypes("request1");
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result.size(), equalTo(1));
                assertThat(result.get(0), is(instanceOf(CallType.class)));
                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
                verify(inputMapperMock).fromJson("request1", CallType.class);
                verify(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0, false, false);
            });
        }
    }

    //Sapient generated method id: ${08821189-c83b-31ec-87ca-2985774b93aa}, hash: 26BE8F1C8C3A672081A02DB3E2C8DF1E
    @Test()
    void getAllCalltypesWhenCallTypesArrayIsNotEmptyAndObjectIsNotNullAndObjectLengthGreaterThanOrEqualsTo8() throws IEMRException {
        /* Branches:* (provider.getIsInbound() != null) : true* (provider.getIsOutbound() != null) : false* (for-each(callTypesArray)) : true* (object != null) : true* (object.length >= 8) : true*/
        //Arrange Statement(s)
        InputMapper inputMapperMock = mock(InputMapper.class);
        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
            CallType callType = new CallType();
            callType.setIsOutbound((Boolean) null);
            callType.setProviderServiceMapID(0);
            doReturn(callType).when(inputMapperMock).fromJson("request1", CallType.class);
            target = new CalltypeServiceImpl();
            autoCloseableMocks = MockitoAnnotations.openMocks(this);
            Object[] objectArray = new Object[]{"A", 1, "B", "C", false, false, false, false};
            Set<Object[]> objectSet = new HashSet<>();
            objectSet.add(objectArray);
            doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0);
            //Act Statement(s)
            List<CallType> result = target.getAllCalltypes("request1");
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result.size(), equalTo(1));
                assertThat(result.get(0), is(instanceOf(CallType.class)));
                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
                verify(inputMapperMock).fromJson("request1", CallType.class);
                verify(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0);
            });
        }
    }

    //Sapient generated method id: ${1b937fa4-a26b-38ae-9e06-03ad3618927b}, hash: 546A704062B08651472414749DBA4E00
    @Disabled()
    @Test()
    void getAllCalltypesV1WhenCallGroupIsNull() throws JSONException, IEMRException {
        /* Branches:* (provider.getIsInbound() != null) : true* (provider.getIsOutbound() != null) : true* (for-each(callTypesArray)) : true* (object != null) : true* (object.length >= 8) : true* (callGrpIndex < callGroupTypes.length()) : false* (callGroup == null) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: object of type JSONArray, callGroup, callGroupTypes*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
        //Arrange Statement(s)
        InputMapper inputMapperMock = mock(InputMapper.class);
        CallType callTypeMock = mock(CallType.class);
        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
            doReturn(callTypeMock).when(inputMapperMock).fromJson("request1", CallType.class);
            doReturn(false).when(callTypeMock).getIsInbound();
            doReturn(false).when(callTypeMock).getIsOutbound();
            doReturn(0).when(callTypeMock).getProviderServiceMapID();
            target = new CalltypeServiceImpl();
            autoCloseableMocks = MockitoAnnotations.openMocks(this);
            Object[] objectArray = new Object[]{"B", 0, "C", "A", false, false, false, false};
            Set<Object[]> objectSet = new HashSet<>();
            objectSet.add(objectArray);
            doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0, false, false);
            //Act Statement(s)
            String result = target.getAllCalltypesV1("request1");
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo("[]"));
                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
                verify(inputMapperMock).fromJson("request1", CallType.class);
                verify(callTypeMock, times(2)).getIsInbound();
                verify(callTypeMock, times(2)).getIsOutbound();
                verify(callTypeMock).getProviderServiceMapID();
                verify(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0, false, false);
            });
        }
    }

    //Sapient generated method id: ${66b0f28a-a80c-3a82-aa18-6acb0bc67187}, hash: FF0A56944CD5EDC66DF9A355C7C7A7D3
    @Disabled()
    @Test()
    void getAllCalltypesV1WhenObjectLengthGreaterThanOrEqualsTo8AndCallGrpIndexNotLessThanCallGroupTypesLengthAndCallGroupIsNull() throws JSONException, IEMRException {
        /* Branches:* (provider.getIsInbound() != null) : true* (provider.getIsOutbound() != null) : false* (provider.getIsInbound() != null) : true* (for-each(callTypesArray)) : true* (object != null) : true* (object.length >= 8) : true* (callGrpIndex < callGroupTypes.length()) : false* (callGroup == null) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: object of type JSONArray, callGroup, callGroupTypes*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
        //Arrange Statement(s)
        InputMapper inputMapperMock = mock(InputMapper.class);
        CallType callTypeMock = mock(CallType.class);
        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
            doReturn(callTypeMock).when(inputMapperMock).fromJson("request1", CallType.class);
            doReturn(false).when(callTypeMock).getIsInbound();
            doReturn(null).when(callTypeMock).getIsOutbound();
            doReturn(0).when(callTypeMock).getProviderServiceMapID();
            target = new CalltypeServiceImpl();
            autoCloseableMocks = MockitoAnnotations.openMocks(this);
            Object[] objectArray = new Object[]{"B", 0, "C", "A", false, false, false, false};
            Set<Object[]> objectSet = new HashSet<>();
            objectSet.add(objectArray);
            doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getInboundCallTypes(0, false);
            //Act Statement(s)
            String result = target.getAllCalltypesV1("request1");
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo("[]"));
                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
                verify(inputMapperMock).fromJson("request1", CallType.class);
                verify(callTypeMock, times(3)).getIsInbound();
                verify(callTypeMock).getIsOutbound();
                verify(callTypeMock).getProviderServiceMapID();
                verify(iEMRCalltypeRepositoryImplCustomMock).getInboundCallTypes(0, false);
            });
        }
    }

    //Sapient generated method id: ${fa228c62-cb2a-3bd7-973d-429dc549107c}, hash: 8CE03D004F10C69E612389613A1EAD3C
    @Disabled()
    @Test()
    void getAllCalltypesV1WhenCallGrpIndexNotLessThanCallGroupTypesLengthAndCallGroupIsNull3() throws JSONException, IEMRException {
        /* Branches:* (provider.getIsInbound() != null) : true* (provider.getIsOutbound() != null) : false* (provider.getIsInbound() != null) : false* (provider.getIsOutbound() != null) : true* (for-each(callTypesArray)) : true* (object != null) : true* (object.length >= 8) : true* (callGrpIndex < callGroupTypes.length()) : false* (callGroup == null) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: object of type JSONArray, callGroup, callGroupTypes*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
        //Arrange Statement(s)
        InputMapper inputMapperMock = mock(InputMapper.class);
        CallType callTypeMock = mock(CallType.class);
        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
            Boolean booleanVar = null;
            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
            doReturn(callTypeMock).when(inputMapperMock).fromJson("request1", CallType.class);
            doReturn(false, booleanVar).when(callTypeMock).getIsInbound();
            doReturn(null, false, false).when(callTypeMock).getIsOutbound();
            doReturn(0).when(callTypeMock).getProviderServiceMapID();
            target = new CalltypeServiceImpl();
            autoCloseableMocks = MockitoAnnotations.openMocks(this);
            Object[] objectArray = new Object[]{"B", 0, "C", "A", false, false, false, false};
            Set<Object[]> objectSet = new HashSet<>();
            objectSet.add(objectArray);
            doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getOutboundCallTypes(0, false);
            //Act Statement(s)
            String result = target.getAllCalltypesV1("request1");
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo("[]"));
                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
                verify(inputMapperMock).fromJson("request1", CallType.class);
                verify(callTypeMock, times(2)).getIsInbound();
                verify(callTypeMock, times(3)).getIsOutbound();
                verify(callTypeMock).getProviderServiceMapID();
                verify(iEMRCalltypeRepositoryImplCustomMock).getOutboundCallTypes(0, false);
            });
        }
    }

    //Sapient generated method id: ${db2dfcc0-9d46-377f-8b3a-f001a270e0bb}, hash: 0486932B8E4ED4EFBC51B089BBB85E2D
    @Disabled()
    @Test()
    void getAllCalltypesV1WhenCallGrpIndexNotLessThanCallGroupTypesLengthAndCallGroupIsNull4() throws JSONException, IEMRException {
        /* Branches:* (provider.getIsInbound() != null) : true* (provider.getIsOutbound() != null) : false* (provider.getIsInbound() != null) : false* (provider.getIsOutbound() != null) : false* (for-each(callTypesArray)) : true* (object != null) : true* (object.length >= 8) : true* (callGrpIndex < callGroupTypes.length()) : false* (callGroup == null) : true** TODO: Help needed! This method is not unit testable!*  Following variables could not be isolated/mocked: object of type JSONArray, callGroup, callGroupTypes*  Suggestions:*  You can pass them as constructor arguments or create a setter for them (avoid new operator)*  or adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
        //Arrange Statement(s)
        InputMapper inputMapperMock = mock(InputMapper.class);
        CallType callTypeMock = mock(CallType.class);
        try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
            Boolean booleanVar = null;
            inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
            doReturn(callTypeMock).when(inputMapperMock).fromJson("request1", CallType.class);
            doReturn(null).when(callTypeMock).getIsOutbound();
            doReturn(false, booleanVar).when(callTypeMock).getIsInbound();
            doReturn(0).when(callTypeMock).getProviderServiceMapID();
            target = new CalltypeServiceImpl();
            autoCloseableMocks = MockitoAnnotations.openMocks(this);
            Object[] objectArray = new Object[]{"B", 0, "C", "A", false, false, false, false};
            Set<Object[]> objectSet = new HashSet<>();
            objectSet.add(objectArray);
            doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0);
            //Act Statement(s)
            String result = target.getAllCalltypesV1("request1");
            //Assert statement(s)
            assertAll("result", () -> {
                assertThat(result, equalTo("[]"));
                inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
                verify(inputMapperMock).fromJson("request1", CallType.class);
                verify(callTypeMock, times(2)).getIsInbound();
                verify(callTypeMock, times(2)).getIsOutbound();
                verify(callTypeMock).getProviderServiceMapID();
                verify(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0);
            });
        }
    }
}
