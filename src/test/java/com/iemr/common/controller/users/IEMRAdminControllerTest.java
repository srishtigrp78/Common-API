package com.iemr.common.controller.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.data.users.M_Role;
import com.iemr.common.data.users.User;
import com.iemr.common.data.users.UserLangMapping;
import com.iemr.common.data.users.UserServiceRoleMapping;
import com.iemr.common.model.user.ChangePasswordModel;
import com.iemr.common.model.user.ForceLogoutRequestModel;
import com.iemr.common.model.user.LoginRequestModel;
import com.iemr.common.notification.exception.IEMRException;
import com.iemr.common.repository.users.IEMRUserLoginSecurityRepository;
import com.iemr.common.service.users.IEMRAdminUserService;
import com.iemr.common.service.users.IEMRAdminUserServiceImpl;
import com.iemr.common.utils.encryption.AESUtil;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;
import com.iemr.common.utils.redis.RedisSessionException;
import com.iemr.common.utils.sessionobject.SessionObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

@ExtendWith(MockitoExtension.class)
class IEMRAdminControllerTest {
	@InjectMocks
	private IEMRAdminController iemrAdminController;

	@Mock
	private InputMapper inputMapper;

	@Mock
	private IEMRAdminUserService iemrAdminUserService;

//	@Test
//	void testUserAuthenticateNew() {
//		fail("Not yet implemented");
//	}

//
//	@Test
//	void testUserAuthenticate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLogOutUserFromConcurrentSession() {
//		fail("Not yet implemented");
//	}

	@Test
	void testLogOutUserFromConcurrentSession() {
		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();

		// Act and Assert
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"Invalid request object\",\"status\":\"User login failed\"}",
				iemrAdminController.logOutUserFromConcurrentSession(null, new MockHttpServletRequest()));
	}

	@Test
	void testLogOutUserFromConcurrentSession2() {

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();

		LoginRequestModel m_User = new LoginRequestModel("janedoe", "iloveyou");
		m_User.setUserName(null);

		// Act and Assert
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"Invalid request object\",\"status\":\"User login failed\"}",
				iemrAdminController.logOutUserFromConcurrentSession(m_User, new MockHttpServletRequest()));
	}

	@Test
	void testLogOutUserFromConcurrentSession3() {

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		iemrAdminController.logOutUserFromConcurrentSession(m_User, new MockHttpServletRequest());

		// Assert
		verify(m_User, atLeast(1)).getUserName();
	}

	@Test
	void testLogOutUserFromConcurrentSession4() {

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(new IEMRAdminUserServiceImpl());
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		iemrAdminController.logOutUserFromConcurrentSession(m_User, new MockHttpServletRequest());

		// Assert
		verify(m_User, atLeast(1)).getUserName();
	}

	@Test
	void testLogOutUserFromConcurrentSession5() {

		// Arrange
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(new ArrayList<>());

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"User not found, please contact administrator\",\"status\":\"User login"
						+ " failed\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession6() {

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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

		User user = new User();
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		iemrAdminController.logOutUserFromConcurrentSession(m_User, new MockHttpServletRequest());

		// Assert
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
	}

	@Test
	void testLogOutUserFromConcurrentSession7() {

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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

		User user = new User();
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		Designation designation2 = new Designation();
		designation2.setCreatedBy("Failed with generic error");
		designation2.setCreatedDate(mock(Timestamp.class));
		designation2.setDeleted(false);
		designation2.setDesignationDesc("FAILURE");
		designation2.setDesignationID(2);
		designation2.setDesignationName("FAILURE");
		designation2.setFeedbackDetails(new HashSet<>());
		designation2.setLastModDate(mock(Timestamp.class));
		designation2.setModifiedBy("Failed with generic error");
		designation2.setOutputMapper(new OutputMapper());
		designation2.setUsers(new HashSet<>());

		Gender m_gender2 = new Gender();
		m_gender2.setCreatedBy("Failed with generic error");
		m_gender2.setCreatedDate(mock(Timestamp.class));
		m_gender2.setDeleted(false);
		m_gender2.setGenderID(2);
		m_gender2.setGenderName("FAILURE");
		m_gender2.setI_beneficiary(new HashSet<>());
		m_gender2.setLastModDate(mock(Timestamp.class));
		m_gender2.setM_user(new HashSet<>());
		m_gender2.setModifiedBy("Failed with generic error");
		m_gender2.setOutputMapper(new OutputMapper());

		MaritalStatus m_maritalstatus2 = new MaritalStatus();
		m_maritalstatus2.setCreatedBy("Failed with generic error");
		m_maritalstatus2.setCreatedDate(mock(Timestamp.class));
		m_maritalstatus2.setDeleted(false);
		m_maritalstatus2.setI_beneficiary(new HashSet<>());
		m_maritalstatus2.setLastModDate(mock(Timestamp.class));
		m_maritalstatus2.setM_user(new HashSet<>());
		m_maritalstatus2.setMaritalStatusID(2);
		m_maritalstatus2.setModifiedBy("Failed with generic error");
		m_maritalstatus2.setOutputMapper(new OutputMapper());
		m_maritalstatus2.setStatus("FAILURE");
		m_maritalstatus2.setStatusDesc("FAILURE");

		Status m_status2 = new Status();
		m_status2.setCreatedBy("Failed with generic error");
		m_status2.setCreatedDate(mock(Timestamp.class));
		m_status2.setDeleted(false);
		m_status2.setI_Beneficiaries(new HashSet<>());
		m_status2.setLastModDate(mock(Timestamp.class));
		m_status2.setM_Users(new HashSet<>());
		m_status2.setModifiedBy("Failed with generic error");
		m_status2.setOutputMapper(new OutputMapper());
		m_status2.setProviderServiceMappings(new HashSet<>());
		m_status2.setServiceProviders(new HashSet<>());
		m_status2.setStatus("FAILURE");
		m_status2.setStatusDesc("FAILURE");
		m_status2.setStatusID(2);

		Title m_title2 = new Title();
		m_title2.setCreatedBy("Failed with generic error");
		m_title2.setCreatedDate(mock(Timestamp.class));
		m_title2.setDeleted(false);
		m_title2.setI_beneficiary(new HashSet<>());
		m_title2.setLastModDate(mock(Timestamp.class));
		m_title2.setM_user(new HashSet<>());
		m_title2.setModifiedBy("Failed with generic error");
		m_title2.setOutputMapper(new OutputMapper());
		m_title2.setTitleDesc("Mr");
		m_title2.setTitleID(2);
		m_title2.setTitleName("Mr");

		User user2 = new User();
		user2.setAadhaarNo("FAILURE");
		user2.setAgentID("FAILURE");
		user2.setAgentPassword("Failed with generic error");
		user2.setCreatedBy("Failed with generic error");
		user2.setCreatedDate(mock(Timestamp.class));
		user2.setDeleted(false);
		user2.setDesignation(designation2);
		user2.setDesignationID(2);
		user2.setEmailID("john.smith@example.org");
		user2.setEmergencyContactNo("FAILURE");
		user2.setEmergencyContactPerson("FAILURE");
		user2.setFailedAttempt(1);
		user2.setFeedbackDetails(new HashSet<>());
		user2.setFirstName("John");
		user2.setGenderID(2);
		user2.setIsSupervisor(false);
		user2.setLastModDate(mock(Timestamp.class));
		user2.setLastName("Smith");
		user2.setM_UserLangMappings(new HashSet<>());
		user2.setM_UserServiceRoleMapping(new ArrayList<>());
		user2.setM_gender(m_gender2);
		user2.setM_maritalstatus(m_maritalstatus2);
		user2.setM_status(m_status2);
		user2.setM_title(m_title2);
		user2.setMaritalStatusID(2);
		user2.setMiddleName("FAILURE");
		user2.setModifiedBy("Failed with generic error");
		user2.setNewPassword("Failed with generic error");
		user2.setOutPutMapper(new OutputMapper());
		user2.setOutboundCallRequests(new HashSet<>());
		user2.setPassword("Failed with generic error");
		user2.setQualificationID(2);
		user2.setRoleMappings(new HashSet<>());
		user2.setStatusID(2);
		user2.setTitleID(2);
		user2.setUserID(2L);
		user2.setUserName("Failed with generic error");
		user2.setdOB(mock(Timestamp.class));
		user2.setdOJ(mock(Timestamp.class));
		user2.setpAN("FAILURE");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user2);
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"More than 1 user found, please contact administrator\",\"status\":\"User"
						+ " login failed\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession8() {

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(new SessionObject());
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		iemrAdminController.logOutUserFromConcurrentSession(m_User, new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
	}

	@Test
	void testLogOutUserFromConcurrentSession9() throws RedisSessionException {

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("Session Object");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq("Session Object"));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession10() throws RedisSessionException {

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("Failed with generic error");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq("Failed with generic error"));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession11() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("FAILURE");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq("FAILURE"));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession12() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("{\"response\":\"$$STRING\"}");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq("{\"response\":\"$$STRING\"}"));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession13() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("$$STRING");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq("$$STRING"));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession14() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("foo");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq("foo"));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession15() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn(null);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).getSessionObject(eq("janedoe"));
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"Unable to fetch session from redis\",\"status\":\"User login failed\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession16() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("42");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq("42"));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession17() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn("janedoe");
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
		SessionObject sessionObject = mock(SessionObject.class);
		doNothing().when(sessionObject).deleteSessionObject(Mockito.<String>any());
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		String actualLogOutUserFromConcurrentSessionResult = iemrAdminController.logOutUserFromConcurrentSession(m_User,
				new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(sessionObject).deleteSessionObject(eq(""));
		verify(sessionObject, atLeast(1)).getSessionObject(Mockito.<String>any());
		assertEquals(
				"{\"data\":{\"response\":\"User successfully logged out\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
						+ "\":\"Success\"}",
				actualLogOutUserFromConcurrentSessionResult);
	}

	@Test
	void testLogOutUserFromConcurrentSession18() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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
		User user = mock(User.class);
		when(user.getUserName()).thenReturn(null);
		doNothing().when(user).setAadhaarNo(Mockito.<String>any());
		doNothing().when(user).setAgentID(Mockito.<String>any());
		doNothing().when(user).setAgentPassword(Mockito.<String>any());
		doNothing().when(user).setCreatedBy(Mockito.<String>any());
		doNothing().when(user).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(user).setDeleted(Mockito.<Boolean>any());
		doNothing().when(user).setDesignation(Mockito.<Designation>any());
		doNothing().when(user).setDesignationID(Mockito.<Integer>any());
		doNothing().when(user).setEmailID(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactNo(Mockito.<String>any());
		doNothing().when(user).setEmergencyContactPerson(Mockito.<String>any());
		doNothing().when(user).setFailedAttempt(Mockito.<Integer>any());
		doNothing().when(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		doNothing().when(user).setFirstName(Mockito.<String>any());
		doNothing().when(user).setGenderID(Mockito.<Integer>any());
		doNothing().when(user).setIsSupervisor(Mockito.<Boolean>any());
		doNothing().when(user).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(user).setLastName(Mockito.<String>any());
		doNothing().when(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		doNothing().when(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		doNothing().when(user).setM_gender(Mockito.<Gender>any());
		doNothing().when(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		doNothing().when(user).setM_status(Mockito.<Status>any());
		doNothing().when(user).setM_title(Mockito.<Title>any());
		doNothing().when(user).setMaritalStatusID(Mockito.<Integer>any());
		doNothing().when(user).setMiddleName(Mockito.<String>any());
		doNothing().when(user).setModifiedBy(Mockito.<String>any());
		doNothing().when(user).setNewPassword(Mockito.<String>any());
		doNothing().when(user).setOutPutMapper(Mockito.<OutputMapper>any());
		doNothing().when(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		doNothing().when(user).setPassword(Mockito.<String>any());
		doNothing().when(user).setQualificationID(Mockito.<Integer>any());
		doNothing().when(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		doNothing().when(user).setStatusID(Mockito.<Integer>any());
		doNothing().when(user).setTitleID(Mockito.<Integer>any());
		doNothing().when(user).setUserID(Mockito.<Long>any());
		doNothing().when(user).setUserName(Mockito.<String>any());
		doNothing().when(user).setdOB(Mockito.<Timestamp>any());
		doNothing().when(user).setdOJ(Mockito.<Timestamp>any());
		doNothing().when(user).setpAN(Mockito.<String>any());
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(mock(SessionObject.class));
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		LoginRequestModel m_User = mock(LoginRequestModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");

		// Act
		iemrAdminController.logOutUserFromConcurrentSession(m_User, new MockHttpServletRequest());

		// Assert
		verify(user).getUserName();
		verify(user).setAadhaarNo(eq("Failed with generic error"));
		verify(user).setAgentID(eq("Failed with generic error"));
		verify(user).setAgentPassword(eq("iloveyou"));
		verify(user).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(user).setCreatedDate(Mockito.<Timestamp>any());
		verify(user).setDeleted(Mockito.<Boolean>any());
		verify(user).setDesignation(Mockito.<Designation>any());
		verify(user).setDesignationID(Mockito.<Integer>any());
		verify(user).setEmailID(eq("jane.doe@example.org"));
		verify(user).setEmergencyContactNo(eq("Failed with generic error"));
		verify(user).setEmergencyContactPerson(eq("Failed with generic error"));
		verify(user).setFailedAttempt(Mockito.<Integer>any());
		verify(user).setFeedbackDetails(Mockito.<Set<FeedbackDetails>>any());
		verify(user).setFirstName(eq("Jane"));
		verify(user).setGenderID(Mockito.<Integer>any());
		verify(user).setIsSupervisor(Mockito.<Boolean>any());
		verify(user).setLastModDate(Mockito.<Timestamp>any());
		verify(user).setLastName(eq("Doe"));
		verify(user).setM_UserLangMappings(Mockito.<Set<UserLangMapping>>any());
		verify(user).setM_UserServiceRoleMapping(Mockito.<List<UserServiceRoleMapping>>any());
		verify(user).setM_gender(Mockito.<Gender>any());
		verify(user).setM_maritalstatus(Mockito.<MaritalStatus>any());
		verify(user).setM_status(Mockito.<Status>any());
		verify(user).setM_title(Mockito.<Title>any());
		verify(user).setMaritalStatusID(Mockito.<Integer>any());
		verify(user).setMiddleName(eq("Failed with generic error"));
		verify(user).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(user).setNewPassword(eq("iloveyou"));
		verify(user).setOutPutMapper(Mockito.<OutputMapper>any());
		verify(user).setOutboundCallRequests(Mockito.<Set<OutboundCallRequest>>any());
		verify(user).setPassword(eq("iloveyou"));
		verify(user).setQualificationID(Mockito.<Integer>any());
		verify(user).setRoleMappings(Mockito.<Set<UserServiceRoleMapping>>any());
		verify(user).setStatusID(Mockito.<Integer>any());
		verify(user).setTitleID(Mockito.<Integer>any());
		verify(user).setUserID(Mockito.<Long>any());
		verify(user).setUserName(eq("janedoe"));
		verify(user).setdOB(Mockito.<Timestamp>any());
		verify(user).setdOJ(Mockito.<Timestamp>any());
		verify(user).setpAN(eq("Failed with generic error"));
		verify(m_User, atLeast(1)).getUserName();
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
	}

//
//	@Test
//	void testSuperUserAuthenticate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetLoginResponse() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetLoginResponse() throws RedisSessionException {

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("Session Object");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"Session Object\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse2() throws RedisSessionException {

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("Failed with generic error");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"Failed with generic error\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse3() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("FAILURE");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse4() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("{\"response\":\"$$STRING\"}");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse5() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("$$STRING");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse6() throws RedisSessionException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("foo");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"foo\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse7() throws RedisSessionException {

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("42");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"42\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse8() throws RedisSessionException {

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any())).thenReturn("");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		String actualLoginResponse = iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
		assertEquals(
				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLoginResponse);
	}

	@Test
	void testGetLoginResponse9() throws RedisSessionException {

		// Arrange
		SessionObject sessionObject = mock(SessionObject.class);
		when(sessionObject.getSessionObject(Mockito.<String>any()))
				.thenThrow(new RedisSessionException("An error occurred"));

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setSessionObject(sessionObject);
		HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
		when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

		// Act
		iemrAdminController.getLoginResponse(request);

		// Assert
		verify(sessionObject).getSessionObject(eq("https://example.org/example"));
		verify(request).getHeader(eq("Authorization"));
	}

//
//	@Test
//	void testForgetPassword() {
//		fail("Not yet implemented");
//	}
//

	@Test
	void testForgetPassword() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		ChangePasswordModel m_User = mock(ChangePasswordModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");
		doNothing().when(m_User).setIsAdmin(Mockito.<Boolean>any());
		doNothing().when(m_User).setNewPassword(Mockito.<String>any());
		doNothing().when(m_User).setPassword(Mockito.<String>any());
		doNothing().when(m_User).setTransactionId(Mockito.<String>any());
		doNothing().when(m_User).setUserName(Mockito.<String>any());
		m_User.setIsAdmin(true);
		m_User.setNewPassword("iloveyou");
		m_User.setPassword("iloveyou");
		m_User.setTransactionId("42");
		m_User.setUserName("janedoe");

		// Act
		iemrAdminController.forgetPassword(m_User);

		// Assert
		verify(m_User).getUserName();
		verify(m_User).setIsAdmin(Mockito.<Boolean>any());
		verify(m_User).setNewPassword(eq("iloveyou"));
		verify(m_User).setPassword(eq("iloveyou"));
		verify(m_User).setTransactionId(eq("42"));
		verify(m_User).setUserName(eq("janedoe"));
	}

	/**
	 * Method under test:
	 * {@link IEMRAdminController#forgetPassword(ChangePasswordModel)}
	 */
	@Test
	void testForgetPassword2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(new IEMRAdminUserServiceImpl());
		ChangePasswordModel m_User = mock(ChangePasswordModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");
		doNothing().when(m_User).setIsAdmin(Mockito.<Boolean>any());
		doNothing().when(m_User).setNewPassword(Mockito.<String>any());
		doNothing().when(m_User).setPassword(Mockito.<String>any());
		doNothing().when(m_User).setTransactionId(Mockito.<String>any());
		doNothing().when(m_User).setUserName(Mockito.<String>any());
		m_User.setIsAdmin(true);
		m_User.setNewPassword("iloveyou");
		m_User.setPassword("iloveyou");
		m_User.setTransactionId("42");
		m_User.setUserName("janedoe");

		// Act
		iemrAdminController.forgetPassword(m_User);

		// Assert
		verify(m_User).getUserName();
		verify(m_User).setIsAdmin(Mockito.<Boolean>any());
		verify(m_User).setNewPassword(eq("iloveyou"));
		verify(m_User).setPassword(eq("iloveyou"));
		verify(m_User).setTransactionId(eq("42"));
		verify(m_User).setUserName(eq("janedoe"));
	}

	/**
	 * Method under test:
	 * {@link IEMRAdminController#forgetPassword(ChangePasswordModel)}
	 */
	@Test
	void testForgetPassword3() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(new ArrayList<>());

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		ChangePasswordModel m_User = mock(ChangePasswordModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");
		doNothing().when(m_User).setIsAdmin(Mockito.<Boolean>any());
		doNothing().when(m_User).setNewPassword(Mockito.<String>any());
		doNothing().when(m_User).setPassword(Mockito.<String>any());
		doNothing().when(m_User).setTransactionId(Mockito.<String>any());
		doNothing().when(m_User).setUserName(Mockito.<String>any());
		m_User.setIsAdmin(true);
		m_User.setNewPassword("iloveyou");
		m_User.setPassword("iloveyou");
		m_User.setTransactionId("42");
		m_User.setUserName("janedoe");

		// Act
		String actualForgetPasswordResult = iemrAdminController.forgetPassword(m_User);

		// Assert
		verify(m_User).getUserName();
		verify(m_User).setIsAdmin(Mockito.<Boolean>any());
		verify(m_User).setNewPassword(eq("iloveyou"));
		verify(m_User).setPassword(eq("iloveyou"));
		verify(m_User).setTransactionId(eq("42"));
		verify(m_User).setUserName(eq("janedoe"));
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"user not found, please contact administrator\",\"status\":\"User login"
						+ " failed\"}",
				actualForgetPasswordResult);
	}

	/**
	 * Method under test:
	 * {@link IEMRAdminController#forgetPassword(ChangePasswordModel)}
	 */
	@Test
	void testForgetPassword4() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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

		User user = new User();
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userSecurityQuestion(Mockito.<Long>any())).thenReturn(new ArrayList<>());
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		ChangePasswordModel m_User = mock(ChangePasswordModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");
		doNothing().when(m_User).setIsAdmin(Mockito.<Boolean>any());
		doNothing().when(m_User).setNewPassword(Mockito.<String>any());
		doNothing().when(m_User).setPassword(Mockito.<String>any());
		doNothing().when(m_User).setTransactionId(Mockito.<String>any());
		doNothing().when(m_User).setUserName(Mockito.<String>any());
		m_User.setIsAdmin(true);
		m_User.setNewPassword("iloveyou");
		m_User.setPassword("iloveyou");
		m_User.setTransactionId("42");
		m_User.setUserName("janedoe");

		// Act
		String actualForgetPasswordResult = iemrAdminController.forgetPassword(m_User);

		// Assert
		verify(m_User).getUserName();
		verify(m_User).setIsAdmin(Mockito.<Boolean>any());
		verify(m_User).setNewPassword(eq("iloveyou"));
		verify(m_User).setPassword(eq("iloveyou"));
		verify(m_User).setTransactionId(eq("42"));
		verify(m_User).setUserName(eq("janedoe"));
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		verify(iemrAdminUserService).userSecurityQuestion(Mockito.<Long>any());
		assertEquals(
				"{\"data\":{\"SecurityQuesAns\":[]},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualForgetPasswordResult);
	}

	/**
	 * Method under test:
	 * {@link IEMRAdminController#forgetPassword(ChangePasswordModel)}
	 */
//	@Test
//	void testForgetPassword5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		Designation designation = new Designation();
//		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		designation.setCreatedDate(mock(Timestamp.class));
//		designation.setDeleted(true);
//		designation.setDesignationDesc("Failed with generic error");
//		designation.setDesignationID(1);
//		designation.setDesignationName("Failed with generic error");
//		designation.setFeedbackDetails(new HashSet<>());
//		designation.setLastModDate(mock(Timestamp.class));
//		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		designation.setOutputMapper(new OutputMapper());
//		designation.setUsers(new HashSet<>());
//
//		Gender m_gender = new Gender();
//		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_gender.setCreatedDate(mock(Timestamp.class));
//		m_gender.setDeleted(true);
//		m_gender.setGenderID(1);
//		m_gender.setGenderName("Failed with generic error");
//		m_gender.setI_beneficiary(new HashSet<>());
//		m_gender.setLastModDate(mock(Timestamp.class));
//		m_gender.setM_user(new HashSet<>());
//		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_gender.setOutputMapper(new OutputMapper());
//
//		MaritalStatus m_maritalstatus = new MaritalStatus();
//		m_maritalstatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_maritalstatus.setCreatedDate(mock(Timestamp.class));
//		m_maritalstatus.setDeleted(true);
//		m_maritalstatus.setI_beneficiary(new HashSet<>());
//		m_maritalstatus.setLastModDate(mock(Timestamp.class));
//		m_maritalstatus.setM_user(new HashSet<>());
//		m_maritalstatus.setMaritalStatusID(1);
//		m_maritalstatus.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_maritalstatus.setOutputMapper(new OutputMapper());
//		m_maritalstatus.setStatus("Failed with generic error");
//		m_maritalstatus.setStatusDesc("Failed with generic error");
//
//		Status m_status = new Status();
//		m_status.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_status.setCreatedDate(mock(Timestamp.class));
//		m_status.setDeleted(true);
//		m_status.setI_Beneficiaries(new HashSet<>());
//		m_status.setLastModDate(mock(Timestamp.class));
//		m_status.setM_Users(new HashSet<>());
//		m_status.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_status.setOutputMapper(new OutputMapper());
//		m_status.setProviderServiceMappings(new HashSet<>());
//		m_status.setServiceProviders(new HashSet<>());
//		m_status.setStatus("Failed with generic error");
//		m_status.setStatusDesc("Failed with generic error");
//		m_status.setStatusID(1);
//
//		Title m_title = new Title();
//		m_title.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_title.setCreatedDate(mock(Timestamp.class));
//		m_title.setDeleted(true);
//		m_title.setI_beneficiary(new HashSet<>());
//		m_title.setLastModDate(mock(Timestamp.class));
//		m_title.setM_user(new HashSet<>());
//		m_title.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_title.setOutputMapper(new OutputMapper());
//		m_title.setTitleDesc("Dr");
//		m_title.setTitleID(1);
//		m_title.setTitleName("Dr");
//
//		User user = new User();
//		user.setAadhaarNo("Failed with generic error");
//		user.setAgentID("Failed with generic error");
//		user.setAgentPassword("iloveyou");
//		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		user.setCreatedDate(mock(Timestamp.class));
//		user.setDeleted(true);
//		user.setDesignation(designation);
//		user.setDesignationID(1);
//		user.setEmailID("jane.doe@example.org");
//		user.setEmergencyContactNo("Failed with generic error");
//		user.setEmergencyContactPerson("Failed with generic error");
//		user.setFailedAttempt(5000);
//		user.setFeedbackDetails(new HashSet<>());
//		user.setFirstName("Jane");
//		user.setGenderID(1);
//		user.setIsSupervisor(true);
//		user.setLastModDate(mock(Timestamp.class));
//		user.setLastName("Doe");
//		user.setM_UserLangMappings(new HashSet<>());
//		user.setM_UserServiceRoleMapping(new ArrayList<>());
//		user.setM_gender(m_gender);
//		user.setM_maritalstatus(m_maritalstatus);
//		user.setM_status(m_status);
//		user.setM_title(m_title);
//		user.setMaritalStatusID(1);
//		user.setMiddleName("Failed with generic error");
//		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		user.setNewPassword("iloveyou");
//		user.setOutPutMapper(new OutputMapper());
//		user.setOutboundCallRequests(new HashSet<>());
//		user.setPassword("iloveyou");
//		user.setQualificationID(1);
//		user.setRoleMappings(new HashSet<>());
//		user.setStatusID(1);
//		user.setTitleID(1);
//		user.setUserID(1L);
//		user.setUserName("janedoe");
//		user.setdOB(mock(Timestamp.class));
//		user.setdOJ(mock(Timestamp.class));
//		user.setpAN("Failed with generic error");
//
//		ArrayList<User> userList = new ArrayList<>();
//		userList.add(user);
//
//		LoginSecurityQuestions m_LoginSecurityQuestions = new LoginSecurityQuestions();
//		m_LoginSecurityQuestions.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_LoginSecurityQuestions.setCreatedDate(mock(Timestamp.class));
//		m_LoginSecurityQuestions.setDeleted(true);
//		m_LoginSecurityQuestions.setLastModDate(mock(Timestamp.class));
//		m_LoginSecurityQuestions.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_LoginSecurityQuestions.setOutputMapper(new OutputMapper());
//		m_LoginSecurityQuestions.setQuestion("Failed with generic error");
//		m_LoginSecurityQuestions.setQuestionID(1);
//
//		UserSecurityQMapping userSecurityQMapping = new UserSecurityQMapping();
//		userSecurityQMapping.setAnswers("Failed with generic error");
//		userSecurityQMapping.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		userSecurityQMapping.setCreatedDate(mock(Timestamp.class));
//		userSecurityQMapping.setDeleted(true);
//		userSecurityQMapping.setLastModDate(mock(Timestamp.class));
//		userSecurityQMapping.setM_LoginSecurityQuestions(m_LoginSecurityQuestions);
//		userSecurityQMapping.setMobileNumber("42");
//		userSecurityQMapping.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		userSecurityQMapping.setOutputMapper(new OutputMapper());
//		userSecurityQMapping.setQuestionID("Failed with generic error");
//		userSecurityQMapping.setUserID(1L);
//		userSecurityQMapping.setUserSecurityQAID(1L);
//
//		ArrayList<UserSecurityQMapping> userSecurityQMappingList = new ArrayList<>();
//		userSecurityQMappingList.add(userSecurityQMapping);
//		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
//		when(iemrAdminUserService.userSecurityQuestion(Mockito.<Long>any())).thenReturn(userSecurityQMappingList);
//		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
//
//		IEMRAdminController iemrAdminController = new IEMRAdminController();
//		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
//		ChangePasswordModel m_User = mock(ChangePasswordModel.class);
//		when(m_User.getUserName()).thenReturn("janedoe");
//		doNothing().when(m_User).setIsAdmin(Mockito.<Boolean>any());
//		doNothing().when(m_User).setNewPassword(Mockito.<String>any());
//		doNothing().when(m_User).setPassword(Mockito.<String>any());
//		doNothing().when(m_User).setTransactionId(Mockito.<String>any());
//		doNothing().when(m_User).setUserName(Mockito.<String>any());
//		m_User.setIsAdmin(true);
//		m_User.setNewPassword("iloveyou");
//		m_User.setPassword("iloveyou");
//		m_User.setTransactionId("42");
//		m_User.setUserName("janedoe");
//
//		// Act
//		String actualForgetPasswordResult = iemrAdminController.forgetPassword(m_User);
//
//		// Assert
//		verify(m_User).getUserName();
//		verify(m_User).setIsAdmin(Mockito.<Boolean>any());
//		verify(m_User).setNewPassword(eq("iloveyou"));
//		verify(m_User).setPassword(eq("iloveyou"));
//		verify(m_User).setTransactionId(eq("42"));
//		verify(m_User).setUserName(eq("janedoe"));
//		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
//		verify(iemrAdminUserService).userSecurityQuestion(Mockito.<Long>any());
//		assertEquals(
//				"{\"data\":{\"SecurityQuesAns\":[{\"questionId\":\"Failed with generic error\",\"question\":\"Failed with generic"
//						+ " error\"}]},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualForgetPasswordResult);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link IEMRAdminController#forgetPassword(ChangePasswordModel)}
//	 */
//	@Test
//	void testForgetPassword6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		Designation designation = new Designation();
//		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		designation.setCreatedDate(mock(Timestamp.class));
//		designation.setDeleted(true);
//		designation.setDesignationDesc("Failed with generic error");
//		designation.setDesignationID(1);
//		designation.setDesignationName("Failed with generic error");
//		designation.setFeedbackDetails(new HashSet<>());
//		designation.setLastModDate(mock(Timestamp.class));
//		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		designation.setOutputMapper(new OutputMapper());
//		designation.setUsers(new HashSet<>());
//
//		Gender m_gender = new Gender();
//		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_gender.setCreatedDate(mock(Timestamp.class));
//		m_gender.setDeleted(true);
//		m_gender.setGenderID(1);
//		m_gender.setGenderName("Failed with generic error");
//		m_gender.setI_beneficiary(new HashSet<>());
//		m_gender.setLastModDate(mock(Timestamp.class));
//		m_gender.setM_user(new HashSet<>());
//		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_gender.setOutputMapper(new OutputMapper());
//
//		MaritalStatus m_maritalstatus = new MaritalStatus();
//		m_maritalstatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_maritalstatus.setCreatedDate(mock(Timestamp.class));
//		m_maritalstatus.setDeleted(true);
//		m_maritalstatus.setI_beneficiary(new HashSet<>());
//		m_maritalstatus.setLastModDate(mock(Timestamp.class));
//		m_maritalstatus.setM_user(new HashSet<>());
//		m_maritalstatus.setMaritalStatusID(1);
//		m_maritalstatus.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_maritalstatus.setOutputMapper(new OutputMapper());
//		m_maritalstatus.setStatus("Failed with generic error");
//		m_maritalstatus.setStatusDesc("Failed with generic error");
//
//		Status m_status = new Status();
//		m_status.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_status.setCreatedDate(mock(Timestamp.class));
//		m_status.setDeleted(true);
//		m_status.setI_Beneficiaries(new HashSet<>());
//		m_status.setLastModDate(mock(Timestamp.class));
//		m_status.setM_Users(new HashSet<>());
//		m_status.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_status.setOutputMapper(new OutputMapper());
//		m_status.setProviderServiceMappings(new HashSet<>());
//		m_status.setServiceProviders(new HashSet<>());
//		m_status.setStatus("Failed with generic error");
//		m_status.setStatusDesc("Failed with generic error");
//		m_status.setStatusID(1);
//
//		Title m_title = new Title();
//		m_title.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_title.setCreatedDate(mock(Timestamp.class));
//		m_title.setDeleted(true);
//		m_title.setI_beneficiary(new HashSet<>());
//		m_title.setLastModDate(mock(Timestamp.class));
//		m_title.setM_user(new HashSet<>());
//		m_title.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_title.setOutputMapper(new OutputMapper());
//		m_title.setTitleDesc("Dr");
//		m_title.setTitleID(1);
//		m_title.setTitleName("Dr");
//
//		User user = new User();
//		user.setAadhaarNo("Failed with generic error");
//		user.setAgentID("Failed with generic error");
//		user.setAgentPassword("iloveyou");
//		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		user.setCreatedDate(mock(Timestamp.class));
//		user.setDeleted(true);
//		user.setDesignation(designation);
//		user.setDesignationID(1);
//		user.setEmailID("jane.doe@example.org");
//		user.setEmergencyContactNo("Failed with generic error");
//		user.setEmergencyContactPerson("Failed with generic error");
//		user.setFailedAttempt(5000);
//		user.setFeedbackDetails(new HashSet<>());
//		user.setFirstName("Jane");
//		user.setGenderID(1);
//		user.setIsSupervisor(true);
//		user.setLastModDate(mock(Timestamp.class));
//		user.setLastName("Doe");
//		user.setM_UserLangMappings(new HashSet<>());
//		user.setM_UserServiceRoleMapping(new ArrayList<>());
//		user.setM_gender(m_gender);
//		user.setM_maritalstatus(m_maritalstatus);
//		user.setM_status(m_status);
//		user.setM_title(m_title);
//		user.setMaritalStatusID(1);
//		user.setMiddleName("Failed with generic error");
//		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		user.setNewPassword("iloveyou");
//		user.setOutPutMapper(new OutputMapper());
//		user.setOutboundCallRequests(new HashSet<>());
//		user.setPassword("iloveyou");
//		user.setQualificationID(1);
//		user.setRoleMappings(new HashSet<>());
//		user.setStatusID(1);
//		user.setTitleID(1);
//		user.setUserID(1L);
//		user.setUserName("janedoe");
//		user.setdOB(mock(Timestamp.class));
//		user.setdOJ(mock(Timestamp.class));
//		user.setpAN("Failed with generic error");
//
//		ArrayList<User> userList = new ArrayList<>();
//		userList.add(user);
//
//		LoginSecurityQuestions m_LoginSecurityQuestions = new LoginSecurityQuestions();
//		m_LoginSecurityQuestions.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_LoginSecurityQuestions.setCreatedDate(mock(Timestamp.class));
//		m_LoginSecurityQuestions.setDeleted(true);
//		m_LoginSecurityQuestions.setLastModDate(mock(Timestamp.class));
//		m_LoginSecurityQuestions.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_LoginSecurityQuestions.setOutputMapper(new OutputMapper());
//		m_LoginSecurityQuestions.setQuestion("Failed with generic error");
//		m_LoginSecurityQuestions.setQuestionID(1);
//
//		UserSecurityQMapping userSecurityQMapping = new UserSecurityQMapping();
//		userSecurityQMapping.setAnswers("Failed with generic error");
//		userSecurityQMapping.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		userSecurityQMapping.setCreatedDate(mock(Timestamp.class));
//		userSecurityQMapping.setDeleted(true);
//		userSecurityQMapping.setLastModDate(mock(Timestamp.class));
//		userSecurityQMapping.setM_LoginSecurityQuestions(m_LoginSecurityQuestions);
//		userSecurityQMapping.setMobileNumber("42");
//		userSecurityQMapping.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		userSecurityQMapping.setOutputMapper(new OutputMapper());
//		userSecurityQMapping.setQuestionID("Failed with generic error");
//		userSecurityQMapping.setUserID(1L);
//		userSecurityQMapping.setUserSecurityQAID(1L);
//
//		LoginSecurityQuestions m_LoginSecurityQuestions2 = new LoginSecurityQuestions();
//		m_LoginSecurityQuestions2.setCreatedBy("Failed with generic error");
//		m_LoginSecurityQuestions2.setCreatedDate(mock(Timestamp.class));
//		m_LoginSecurityQuestions2.setDeleted(false);
//		m_LoginSecurityQuestions2.setLastModDate(mock(Timestamp.class));
//		m_LoginSecurityQuestions2.setModifiedBy("Failed with generic error");
//		m_LoginSecurityQuestions2.setOutputMapper(new OutputMapper());
//		m_LoginSecurityQuestions2.setQuestion("FAILURE");
//		m_LoginSecurityQuestions2.setQuestionID(2);
//
//		UserSecurityQMapping userSecurityQMapping2 = new UserSecurityQMapping();
//		userSecurityQMapping2.setAnswers("FAILURE");
//		userSecurityQMapping2.setCreatedBy("Failed with generic error");
//		userSecurityQMapping2.setCreatedDate(mock(Timestamp.class));
//		userSecurityQMapping2.setDeleted(false);
//		userSecurityQMapping2.setLastModDate(mock(Timestamp.class));
//		userSecurityQMapping2.setM_LoginSecurityQuestions(m_LoginSecurityQuestions2);
//		userSecurityQMapping2.setMobileNumber("Failed with generic error");
//		userSecurityQMapping2.setModifiedBy("Failed with generic error");
//		userSecurityQMapping2.setOutputMapper(new OutputMapper());
//		userSecurityQMapping2.setQuestionID("FAILURE");
//		userSecurityQMapping2.setUserID(2L);
//		userSecurityQMapping2.setUserSecurityQAID(2L);
//
//		ArrayList<UserSecurityQMapping> userSecurityQMappingList = new ArrayList<>();
//		userSecurityQMappingList.add(userSecurityQMapping2);
//		userSecurityQMappingList.add(userSecurityQMapping);
//		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
//		when(iemrAdminUserService.userSecurityQuestion(Mockito.<Long>any())).thenReturn(userSecurityQMappingList);
//		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
//
//		IEMRAdminController iemrAdminController = new IEMRAdminController();
//		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
//		ChangePasswordModel m_User = mock(ChangePasswordModel.class);
//		when(m_User.getUserName()).thenReturn("janedoe");
//		doNothing().when(m_User).setIsAdmin(Mockito.<Boolean>any());
//		doNothing().when(m_User).setNewPassword(Mockito.<String>any());
//		doNothing().when(m_User).setPassword(Mockito.<String>any());
//		doNothing().when(m_User).setTransactionId(Mockito.<String>any());
//		doNothing().when(m_User).setUserName(Mockito.<String>any());
//		m_User.setIsAdmin(true);
//		m_User.setNewPassword("iloveyou");
//		m_User.setPassword("iloveyou");
//		m_User.setTransactionId("42");
//		m_User.setUserName("janedoe");
//
//		// Act
//		String actualForgetPasswordResult = iemrAdminController.forgetPassword(m_User);
//
//		// Assert
//		verify(m_User).getUserName();
//		verify(m_User).setIsAdmin(Mockito.<Boolean>any());
//		verify(m_User).setNewPassword(eq("iloveyou"));
//		verify(m_User).setPassword(eq("iloveyou"));
//		verify(m_User).setTransactionId(eq("42"));
//		verify(m_User).setUserName(eq("janedoe"));
//		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
//		verify(iemrAdminUserService).userSecurityQuestion(Mockito.<Long>any());
//		assertEquals(
//				"{\"data\":{\"SecurityQuesAns\":[{\"questionId\":\"FAILURE\",\"question\":\"FAILURE\"},{\"questionId\":\"Failed with"
//						+ " generic error\",\"question\":\"Failed with generic error\"}]},\"statusCode\":200,\"errorMessage\":\"Success\","
//						+ "\"status\":\"Success\"}",
//				actualForgetPasswordResult);
//	}

	/**
	 * Method under test:
	 * {@link IEMRAdminController#forgetPassword(ChangePasswordModel)}
	 */
	@Test
	void testForgetPassword7() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		Designation designation = new Designation();
		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		designation.setCreatedDate(mock(Timestamp.class));
		designation.setDeleted(true);
		designation.setDesignationDesc("Failed with generic error");
		designation.setDesignationID(1);
		designation.setDesignationName("Failed with generic error");
		designation.setFeedbackDetails(new HashSet<>());
		designation.setLastModDate(mock(Timestamp.class));
		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		designation.setOutputMapper(new OutputMapper());
		designation.setUsers(new HashSet<>());

		Gender m_gender = new Gender();
		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_gender.setCreatedDate(mock(Timestamp.class));
		m_gender.setDeleted(true);
		m_gender.setGenderID(1);
		m_gender.setGenderName("Failed with generic error");
		m_gender.setI_beneficiary(new HashSet<>());
		m_gender.setLastModDate(mock(Timestamp.class));
		m_gender.setM_user(new HashSet<>());
		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_gender.setOutputMapper(new OutputMapper());

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
		m_maritalstatus.setStatus("Failed with generic error");
		m_maritalstatus.setStatusDesc("Failed with generic error");

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
		m_status.setStatus("Failed with generic error");
		m_status.setStatusDesc("Failed with generic error");
		m_status.setStatusID(1);

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

		User user = new User();
		user.setAadhaarNo("Failed with generic error");
		user.setAgentID("Failed with generic error");
		user.setAgentPassword("iloveyou");
		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		user.setCreatedDate(mock(Timestamp.class));
		user.setDeleted(true);
		user.setDesignation(designation);
		user.setDesignationID(1);
		user.setEmailID("jane.doe@example.org");
		user.setEmergencyContactNo("Failed with generic error");
		user.setEmergencyContactPerson("Failed with generic error");
		user.setFailedAttempt(5000);
		user.setFeedbackDetails(new HashSet<>());
		user.setFirstName("Jane");
		user.setGenderID(1);
		user.setIsSupervisor(true);
		user.setLastModDate(mock(Timestamp.class));
		user.setLastName("Doe");
		user.setM_UserLangMappings(new HashSet<>());
		user.setM_UserServiceRoleMapping(new ArrayList<>());
		user.setM_gender(m_gender);
		user.setM_maritalstatus(m_maritalstatus);
		user.setM_status(m_status);
		user.setM_title(m_title);
		user.setMaritalStatusID(1);
		user.setMiddleName("Failed with generic error");
		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		user.setNewPassword("iloveyou");
		user.setOutPutMapper(new OutputMapper());
		user.setOutboundCallRequests(new HashSet<>());
		user.setPassword("iloveyou");
		user.setQualificationID(1);
		user.setRoleMappings(new HashSet<>());
		user.setStatusID(1);
		user.setTitleID(1);
		user.setUserID(1L);
		user.setUserName("janedoe");
		user.setdOB(mock(Timestamp.class));
		user.setdOJ(mock(Timestamp.class));
		user.setpAN("Failed with generic error");

		Designation designation2 = new Designation();
		designation2.setCreatedBy("Failed with generic error");
		designation2.setCreatedDate(mock(Timestamp.class));
		designation2.setDeleted(false);
		designation2.setDesignationDesc("FAILURE");
		designation2.setDesignationID(2);
		designation2.setDesignationName("FAILURE");
		designation2.setFeedbackDetails(new HashSet<>());
		designation2.setLastModDate(mock(Timestamp.class));
		designation2.setModifiedBy("Failed with generic error");
		designation2.setOutputMapper(new OutputMapper());
		designation2.setUsers(new HashSet<>());

		Gender m_gender2 = new Gender();
		m_gender2.setCreatedBy("Failed with generic error");
		m_gender2.setCreatedDate(mock(Timestamp.class));
		m_gender2.setDeleted(false);
		m_gender2.setGenderID(2);
		m_gender2.setGenderName("FAILURE");
		m_gender2.setI_beneficiary(new HashSet<>());
		m_gender2.setLastModDate(mock(Timestamp.class));
		m_gender2.setM_user(new HashSet<>());
		m_gender2.setModifiedBy("Failed with generic error");
		m_gender2.setOutputMapper(new OutputMapper());

		MaritalStatus m_maritalstatus2 = new MaritalStatus();
		m_maritalstatus2.setCreatedBy("Failed with generic error");
		m_maritalstatus2.setCreatedDate(mock(Timestamp.class));
		m_maritalstatus2.setDeleted(false);
		m_maritalstatus2.setI_beneficiary(new HashSet<>());
		m_maritalstatus2.setLastModDate(mock(Timestamp.class));
		m_maritalstatus2.setM_user(new HashSet<>());
		m_maritalstatus2.setMaritalStatusID(2);
		m_maritalstatus2.setModifiedBy("Failed with generic error");
		m_maritalstatus2.setOutputMapper(new OutputMapper());
		m_maritalstatus2.setStatus("FAILURE");
		m_maritalstatus2.setStatusDesc("FAILURE");

		Status m_status2 = new Status();
		m_status2.setCreatedBy("Failed with generic error");
		m_status2.setCreatedDate(mock(Timestamp.class));
		m_status2.setDeleted(false);
		m_status2.setI_Beneficiaries(new HashSet<>());
		m_status2.setLastModDate(mock(Timestamp.class));
		m_status2.setM_Users(new HashSet<>());
		m_status2.setModifiedBy("Failed with generic error");
		m_status2.setOutputMapper(new OutputMapper());
		m_status2.setProviderServiceMappings(new HashSet<>());
		m_status2.setServiceProviders(new HashSet<>());
		m_status2.setStatus("FAILURE");
		m_status2.setStatusDesc("FAILURE");
		m_status2.setStatusID(2);

		Title m_title2 = new Title();
		m_title2.setCreatedBy("Failed with generic error");
		m_title2.setCreatedDate(mock(Timestamp.class));
		m_title2.setDeleted(false);
		m_title2.setI_beneficiary(new HashSet<>());
		m_title2.setLastModDate(mock(Timestamp.class));
		m_title2.setM_user(new HashSet<>());
		m_title2.setModifiedBy("Failed with generic error");
		m_title2.setOutputMapper(new OutputMapper());
		m_title2.setTitleDesc("Mr");
		m_title2.setTitleID(2);
		m_title2.setTitleName("Mr");

		User user2 = new User();
		user2.setAadhaarNo("FAILURE");
		user2.setAgentID("FAILURE");
		user2.setAgentPassword("Failed with generic error");
		user2.setCreatedBy("Failed with generic error");
		user2.setCreatedDate(mock(Timestamp.class));
		user2.setDeleted(false);
		user2.setDesignation(designation2);
		user2.setDesignationID(2);
		user2.setEmailID("john.smith@example.org");
		user2.setEmergencyContactNo("FAILURE");
		user2.setEmergencyContactPerson("FAILURE");
		user2.setFailedAttempt(1);
		user2.setFeedbackDetails(new HashSet<>());
		user2.setFirstName("John");
		user2.setGenderID(2);
		user2.setIsSupervisor(false);
		user2.setLastModDate(mock(Timestamp.class));
		user2.setLastName("Smith");
		user2.setM_UserLangMappings(new HashSet<>());
		user2.setM_UserServiceRoleMapping(new ArrayList<>());
		user2.setM_gender(m_gender2);
		user2.setM_maritalstatus(m_maritalstatus2);
		user2.setM_status(m_status2);
		user2.setM_title(m_title2);
		user2.setMaritalStatusID(2);
		user2.setMiddleName("FAILURE");
		user2.setModifiedBy("Failed with generic error");
		user2.setNewPassword("Failed with generic error");
		user2.setOutPutMapper(new OutputMapper());
		user2.setOutboundCallRequests(new HashSet<>());
		user2.setPassword("Failed with generic error");
		user2.setQualificationID(2);
		user2.setRoleMappings(new HashSet<>());
		user2.setStatusID(2);
		user2.setTitleID(2);
		user2.setUserID(2L);
		user2.setUserName("Failed with generic error");
		user2.setdOB(mock(Timestamp.class));
		user2.setdOJ(mock(Timestamp.class));
		user2.setpAN("FAILURE");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user2);
		userList.add(user);
		IEMRAdminUserService iemrAdminUserService = mock(IEMRAdminUserService.class);
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		ChangePasswordModel m_User = mock(ChangePasswordModel.class);
		when(m_User.getUserName()).thenReturn("janedoe");
		doNothing().when(m_User).setIsAdmin(Mockito.<Boolean>any());
		doNothing().when(m_User).setNewPassword(Mockito.<String>any());
		doNothing().when(m_User).setPassword(Mockito.<String>any());
		doNothing().when(m_User).setTransactionId(Mockito.<String>any());
		doNothing().when(m_User).setUserName(Mockito.<String>any());
		m_User.setIsAdmin(true);
		m_User.setNewPassword("iloveyou");
		m_User.setPassword("iloveyou");
		m_User.setTransactionId("42");
		m_User.setUserName("janedoe");

		// Act
		String actualForgetPasswordResult = iemrAdminController.forgetPassword(m_User);

		// Assert
		verify(m_User).getUserName();
		verify(m_User).setIsAdmin(Mockito.<Boolean>any());
		verify(m_User).setNewPassword(eq("iloveyou"));
		verify(m_User).setPassword(eq("iloveyou"));
		verify(m_User).setTransactionId(eq("42"));
		verify(m_User).setUserName(eq("janedoe"));
		verify(iemrAdminUserService).userExitsCheck(eq("janedoe"));
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"more than 1 user found, please contact administrator\",\"status\":\"User"
						+ " login failed\"}",
				actualForgetPasswordResult);
	}

//	@Test
//	void testSetPassword() {
//		fail("Not yet implemented");
//	}
//

//	@Test
//	void testChangePassword() {
//		fail("Not yet implemented");
//	}

	@Test
	void testChangePassword() throws Exception {
		// Arrange
		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(new ArrayList<>());

		ChangePasswordModel changePasswordModel = new ChangePasswordModel();
		changePasswordModel.setIsAdmin(true);
		changePasswordModel.setNewPassword("iloveyou");
		changePasswordModel.setPassword("iloveyou");
		changePasswordModel.setTransactionId("42");
		changePasswordModel.setUserName("janedoe");

		changePasswordModel.toString();

		String content = (new ObjectMapper()).writeValueAsString(changePasswordModel);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/changePassword")
				.contentType(MediaType.APPLICATION_JSON).content(content);

		// Act and Assert
		MockMvcBuilders.standaloneSetup(iemrAdminController).build().perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.content().string(
						"{\"statusCode\":5002,\"errorMessage\":\"Change password failed with error as user is not available\",\"status\":\"User"
								+ " login failed\"}"));
	}

//	@Test
//	void testChangePassword2() throws Exception {
//		// Arrange
//		Designation designation = new Designation();
//		designation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		designation.setCreatedDate(mock(Timestamp.class));
//		designation.setDeleted(true);
//		designation.setDesignationDesc("Failed with generic error");
//		designation.setDesignationID(1);
//		designation.setDesignationName("Failed with generic error");
//		designation.setFeedbackDetails(new HashSet<>());
//		designation.setLastModDate(mock(Timestamp.class));
//		designation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		 designation.setOutputMapper(new OutputMapper());
//		designation.setUsers(new HashSet<>());
//
//		designation.toString();
//
//		Gender m_gender = new Gender();
//		m_gender.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_gender.setCreatedDate(mock(Timestamp.class));
//		m_gender.setDeleted(true);
//		m_gender.setGenderID(1);
//		m_gender.setGenderName("Failed with generic error");
//		m_gender.setI_beneficiary(new HashSet<>());
//		m_gender.setLastModDate(mock(Timestamp.class));
//		m_gender.setM_user(new HashSet<>());
//		m_gender.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//
//		m_gender.toString();
//		 m_gender.setOutputMapper(new OutputMapper());
//
//		MaritalStatus m_maritalstatus = new MaritalStatus();
//		m_maritalstatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_maritalstatus.setCreatedDate(mock(Timestamp.class));
//		m_maritalstatus.setDeleted(true);
//		m_maritalstatus.setI_beneficiary(new HashSet<>());
//		m_maritalstatus.setLastModDate(mock(Timestamp.class));
//		m_maritalstatus.setM_user(new HashSet<>());
//		m_maritalstatus.setMaritalStatusID(1);
//		m_maritalstatus.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		 m_maritalstatus.setOutputMapper(new OutputMapper());
//		m_maritalstatus.setStatus("Failed with generic error");
//		m_maritalstatus.setStatusDesc("Failed with generic error");
//
//		m_maritalstatus.toString();
//
//		Status m_status = new Status();
//		m_status.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_status.setCreatedDate(mock(Timestamp.class));
//		m_status.setDeleted(true);
//		m_status.setI_Beneficiaries(new HashSet<>());
//		m_status.setLastModDate(mock(Timestamp.class));
//		m_status.setM_Users(new HashSet<>());
//		m_status.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		 m_status.setOutputMapper(new OutputMapper());
//		m_status.setProviderServiceMappings(new HashSet<>());
//		m_status.setServiceProviders(new HashSet<>());
//		m_status.setStatus("Failed with generic error");
//		m_status.setStatusDesc("Failed with generic error");
//		m_status.setStatusID(1);
//
//		m_status.toString();
//
//		Title m_title = new Title();
//		m_title.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_title.setCreatedDate(mock(Timestamp.class));
//		m_title.setDeleted(true);
//		m_title.setI_beneficiary(new HashSet<>());
//		m_title.setLastModDate(mock(Timestamp.class));
//		m_title.setM_user(new HashSet<>());
//		m_title.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		 m_title.setOutputMapper(new OutputMapper());
//		m_title.setTitleDesc("Dr");
//		m_title.setTitleID(1);
//		m_title.setTitleName("Dr");
//
//		m_title.toString();
//
//		User user = new User();
//		user.setAadhaarNo("Failed with generic error");
//		user.setAgentID("Failed with generic error");
//		user.setAgentPassword("iloveyou");
//		user.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		user.setCreatedDate(mock(Timestamp.class));
//		user.setDeleted(true);
//		user.setDesignation(designation);
//		user.setDesignationID(1);
//		user.setEmailID("jane.doe@example.org");
//		user.setEmergencyContactNo("Failed with generic error");
//		user.setEmergencyContactPerson("Failed with generic error");
//		user.setFailedAttempt(5000);
//		user.setFeedbackDetails(new HashSet<>());
//		user.setFirstName("Jane");
//		user.setGenderID(1);
//		user.setIsSupervisor(true);
//		user.setLastModDate(mock(Timestamp.class));
//		user.setLastName("Doe");
//		user.setM_UserLangMappings(new HashSet<>());
//		user.setM_UserServiceRoleMapping(new ArrayList<>());
//		user.setM_gender(m_gender);
//		user.setM_maritalstatus(m_maritalstatus);
//		user.setM_status(m_status);
//		user.setM_title(m_title);
//		user.setMaritalStatusID(1);
//		user.setMiddleName("Failed with generic error");
//		user.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		user.setNewPassword("iloveyou");
//		user.setOutPutMapper(new OutputMapper());
//		user.setOutboundCallRequests(new HashSet<>());
//		user.setPassword("iloveyou");
//		user.setQualificationID(1);
//		user.setRoleMappings(new HashSet<>());
//		user.setStatusID(1);
//		user.setTitleID(1);
//		user.setUserID(1L);
//		user.setUserName("janedoe");
//		user.setdOB(mock(Timestamp.class));
//		user.setdOJ(mock(Timestamp.class));
//		user.setpAN("Failed with generic error");
//
//		user.toString();
//
//		ArrayList<User> userList = new ArrayList<>();
//		userList.add(user);
//		when(iemrAdminUserService.userExitsCheck(Mockito.<String>any())).thenReturn(userList);
//
//		ChangePasswordModel changePasswordModel = new ChangePasswordModel();
//		changePasswordModel.setIsAdmin(true);
//		changePasswordModel.setNewPassword("iloveyou");
//		changePasswordModel.setPassword("iloveyou");
//		changePasswordModel.setTransactionId("42");
//		changePasswordModel.setUserName("janedoe");
//
//		changePasswordModel.toString();
//
//		String content = (new ObjectMapper()).writeValueAsString(changePasswordModel);
//		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/changePassword")
//				.contentType(MediaType.APPLICATION_JSON).content(content);
//
//		// Act and Assert
//		MockMvcBuilders.standaloneSetup(iemrAdminController).build().perform(requestBuilder)
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//				.andExpect(MockMvcResultMatchers.content().string(
//						"{\"statusCode\":5002,\"errorMessage\":\"For input string: \\\"iloveyou\\\"\",\"status\":\"User login failed\"}"));
//	}
//
//	@Test
//	void testSaveUserSecurityQuesAns() {
//		fail("Not yet implemented");
//	}

	void testSaveUserSecurityQuesAns() {
		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(new IEMRAdminUserServiceImpl());

		// Act and Assert
		assertEquals(
				"{\"statusCode\":5002,\"errorMessage\":\"Invalid user, please contact administrator\",\"status\":\"User login"
						+ " failed\"}",
				iemrAdminController.saveUserSecurityQuesAns(new ArrayList<>()));
	}

//
//	@Test
//	void testGetSecurityts() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetSecurityts() {

		// Arrange
		IEMRUserLoginSecurityRepository iEMRUserLoginSecurityRepository = mock(IEMRUserLoginSecurityRepository.class);
		when(iEMRUserLoginSecurityRepository.getAllLoginSecurityQuestions()).thenReturn(new ArrayList<>());

		IEMRAdminUserServiceImpl iemrAdminUserService = new IEMRAdminUserServiceImpl();
		iemrAdminUserService.setIEMRUserLoginSecurityRepository(iEMRUserLoginSecurityRepository);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualSecurityts = iemrAdminController.getSecurityts();

		// Assert
		verify(iEMRUserLoginSecurityRepository).getAllLoginSecurityQuestions();
		assertEquals("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualSecurityts);
	}

	@Test
	void testGetSecurityts2() {

		// Arrange
		ArrayList<Object[]> objectArrayList = new ArrayList<>();
		objectArrayList.add(new Object[] { "42" });
		IEMRUserLoginSecurityRepository iEMRUserLoginSecurityRepository = mock(IEMRUserLoginSecurityRepository.class);
		when(iEMRUserLoginSecurityRepository.getAllLoginSecurityQuestions()).thenReturn(objectArrayList);

		IEMRAdminUserServiceImpl iemrAdminUserService = new IEMRAdminUserServiceImpl();
		iemrAdminUserService.setIEMRUserLoginSecurityRepository(iEMRUserLoginSecurityRepository);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		iemrAdminController.getSecurityts();

		// Assert
		verify(iEMRUserLoginSecurityRepository).getAllLoginSecurityQuestions();
	}
//
//	@Test
//	void testGetRolesByProviderID() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetRolesByProviderID() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("Roles By Provider ID");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Roles By Provider ID\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID2() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("Failed with generic error");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Failed with generic error\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID3() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("FAILURE");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID4() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any()))
				.thenReturn("{\"response\":\"$$STRING\"}");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID5() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("$$STRING");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID6() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("foo");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"foo\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID7() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID8() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("42");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"42\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualRolesByProviderID);
	}

	@Test
	void testGetRolesByProviderID9() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("\"");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
	}

	@Test
	void testGetRolesByProviderID10() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getRolesByProviderID(Mockito.<String>any())).thenReturn("'");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualRolesByProviderID = iemrAdminController.getRolesByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getRolesByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\\u0027\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualRolesByProviderID);
	}

//
//	@Test
//	void testGetRoleScreenMappingByProviderID() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetUsersByProviderID() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetUsersByProviderID() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("Users By Provider ID");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Users By Provider ID\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID2() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("Failed with generic error");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Failed with generic error\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID3() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("FAILURE");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID4() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any()))
				.thenReturn("{\"response\":\"$$STRING\"}");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID5() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("$$STRING");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID6() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("foo");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"foo\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID7() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID8() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("42");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"42\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualUsersByProviderID);
	}

	@Test
	void testGetUsersByProviderID9() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("\"");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
	}

	@Test
	void testGetUsersByProviderID10() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getUsersByProviderID(Mockito.<String>any())).thenReturn("'");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualUsersByProviderID = iemrAdminController.getUsersByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getUsersByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\\u0027\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualUsersByProviderID);
	}

//
//	@Test
//	void testGetUserServicePointVanDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetUserServicePointVanDetails() {
		// Arrange, Act and Assert
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getUserServicePointVanDetails("Coming Request"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getUserServicePointVanDetails("﻿"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getUserServicePointVanDetails("foo"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getUserServicePointVanDetails("42"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController())
						.getUserServicePointVanDetails("com.iemr.common.data.users.UserSecurityQMapping"));
	}

	@Test
	void testGetUserServicePointVanDetails2() {

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setAesUtil(mock(AESUtil.class));

		// Act and Assert
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				iemrAdminController.getUserServicePointVanDetails("Coming Request"));
	}

//
//	@Test
//	void testGetServicepointVillages() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetServicepointVillages() {

		// Arrange, Act and Assert
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getServicepointVillages("Coming Request"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getServicepointVillages("﻿"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getServicepointVillages("foo"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getServicepointVillages("42"));
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				(new IEMRAdminController()).getServicepointVillages("com.iemr.common.data.users.UserSecurityQMapping"));
	}

	@Test
	void testGetServicepointVillages2() {

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setAesUtil(mock(AESUtil.class));

		// Act and Assert
		assertEquals(
				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
				iemrAdminController.getServicepointVillages("Coming Request"));
	}
//
//	@Test
//	void testGetLocationsByProviderID() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetLocationsByProviderID() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any()))
				.thenReturn("Locations By Provider ID");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Locations By Provider ID\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID2() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any()))
				.thenReturn("Failed with generic error");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Failed with generic error\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID3() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any())).thenReturn("FAILURE");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID4() throws Exception {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any()))
				.thenReturn("{\"response\":\"$$STRING\"}");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID5() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any())).thenReturn("$$STRING");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID6() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any())).thenReturn("foo");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"foo\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID7() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any())).thenReturn("");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID8() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any())).thenReturn("42");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"42\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID9() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any())).thenReturn("\"");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
	}

	@Test
	void testGetLocationsByProviderID10() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any())).thenReturn("'");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\\u0027\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualLocationsByProviderID);
	}

	@Test
	void testGetLocationsByProviderID11() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getLocationsByProviderID(Mockito.<String>any()))
				.thenThrow(new IEMRException("An error occurred"));

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualLocationsByProviderID = iemrAdminController.getLocationsByProviderID("Request");

		// Assert
		verify(iemrAdminUserService).getLocationsByProviderID(eq("Request"));
		assertEquals("{\"statusCode\":5002,\"errorMessage\":\"An error occurred\",\"status\":\"User login failed\"}",
				actualLocationsByProviderID);
	}
//
//	@Test
//	void testUserLogout() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testForceLogout() {
//		fail("Not yet implemented");
//	}

	@Test
	void testForceLogout() {

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		ForceLogoutRequestModel request = mock(ForceLogoutRequestModel.class);
		doNothing().when(request).setPassword(Mockito.<String>any());
		doNothing().when(request).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(request).setUserName(Mockito.<String>any());
		request.setPassword("iloveyou");
		request.setProviderServiceMapID(1);
		request.setUserName("janedoe");

		// Act
		iemrAdminController.forceLogout(request);

		// Assert
		verify(request).setPassword(eq("iloveyou"));
		verify(request).setProviderServiceMapID(Mockito.<Integer>any());
		verify(request).setUserName(eq("janedoe"));
	}

	@Test
	void testForceLogout2() {

		// Arrange
		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(new IEMRAdminUserServiceImpl());
		ForceLogoutRequestModel request = mock(ForceLogoutRequestModel.class);
		when(request.getUserName()).thenReturn("janedoe");
		doNothing().when(request).setPassword(Mockito.<String>any());
		doNothing().when(request).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(request).setUserName(Mockito.<String>any());
		request.setPassword("iloveyou");
		request.setProviderServiceMapID(1);
		request.setUserName("janedoe");

		// Act
		iemrAdminController.forceLogout(request);

		// Assert
		verify(request).getUserName();
		verify(request).setPassword(eq("iloveyou"));
		verify(request).setProviderServiceMapID(Mockito.<Integer>any());
		verify(request).setUserName(eq("janedoe"));
	}

	@Test
	void testForceLogout3() throws Exception {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		doNothing().when(iemrAdminUserService).forceLogout(Mockito.<ForceLogoutRequestModel>any());

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		ForceLogoutRequestModel request = mock(ForceLogoutRequestModel.class);
		doNothing().when(request).setPassword(Mockito.<String>any());
		doNothing().when(request).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(request).setUserName(Mockito.<String>any());
		request.setPassword("iloveyou");
		request.setProviderServiceMapID(1);
		request.setUserName("janedoe");

		// Act
		String actualForceLogoutResult = iemrAdminController.forceLogout(request);

		// Assert
		verify(request).setPassword(eq("iloveyou"));
		verify(request).setProviderServiceMapID(Mockito.<Integer>any());
		verify(request).setUserName(eq("janedoe"));
		verify(iemrAdminUserService).forceLogout(Mockito.<ForceLogoutRequestModel>any());
		assertEquals(
				"{\"data\":{\"response\":\"Success\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualForceLogoutResult);
	}

	@Test
	void testForceLogout4() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		doThrow(new Exception("Failed with generic error")).when(iemrAdminUserService)
				.forceLogout(Mockito.<ForceLogoutRequestModel>any());

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		ForceLogoutRequestModel request = mock(ForceLogoutRequestModel.class);
		doNothing().when(request).setPassword(Mockito.<String>any());
		doNothing().when(request).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(request).setUserName(Mockito.<String>any());
		request.setPassword("iloveyou");
		request.setProviderServiceMapID(1);
		request.setUserName("janedoe");

		// Act
		iemrAdminController.forceLogout(request);

		// Assert
		verify(request).setPassword(eq("iloveyou"));
		verify(request).setProviderServiceMapID(Mockito.<Integer>any());
		verify(request).setUserName(eq("janedoe"));
		verify(iemrAdminUserService).forceLogout(Mockito.<ForceLogoutRequestModel>any());
	}

	@Test
	void testForceLogout5() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		doThrow(new Exception("")).when(iemrAdminUserService).forceLogout(Mockito.<ForceLogoutRequestModel>any());

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		ForceLogoutRequestModel request = mock(ForceLogoutRequestModel.class);
		doNothing().when(request).setPassword(Mockito.<String>any());
		doNothing().when(request).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(request).setUserName(Mockito.<String>any());
		request.setPassword("iloveyou");
		request.setProviderServiceMapID(1);
		request.setUserName("janedoe");

		// Act
		iemrAdminController.forceLogout(request);

		// Assert
		verify(request).setPassword(eq("iloveyou"));
		verify(request).setProviderServiceMapID(Mockito.<Integer>any());
		verify(request).setUserName(eq("janedoe"));
		verify(iemrAdminUserService).forceLogout(Mockito.<ForceLogoutRequestModel>any());
	}

	@Test
	void testForceLogout6() throws Exception {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		doThrow(new IEMRException("An error occurred")).when(iemrAdminUserService)
				.forceLogout(Mockito.<ForceLogoutRequestModel>any());

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
		ForceLogoutRequestModel request = mock(ForceLogoutRequestModel.class);
		doNothing().when(request).setPassword(Mockito.<String>any());
		doNothing().when(request).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(request).setUserName(Mockito.<String>any());
		request.setPassword("iloveyou");
		request.setProviderServiceMapID(1);
		request.setUserName("janedoe");

		// Act
		String actualForceLogoutResult = iemrAdminController.forceLogout(request);

		// Assert
		verify(request).setPassword(eq("iloveyou"));
		verify(request).setProviderServiceMapID(Mockito.<Integer>any());
		verify(request).setUserName(eq("janedoe"));
		verify(iemrAdminUserService).forceLogout(Mockito.<ForceLogoutRequestModel>any());
		assertEquals("{\"statusCode\":5002,\"errorMessage\":\"An error occurred\",\"status\":\"User login failed\"}",
				actualForceLogoutResult);
	}

//
//	@Test
//	void testUserForceLogout() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAgentByRoleID() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetAgentByRoleID() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("Agent By Role ID");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Agent By Role ID\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID2() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("Failed with generic error");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"Failed with generic error\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
						+ "\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID3() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("FAILURE");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID4() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("{\"response\":\"$$STRING\"}");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID5() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("$$STRING");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID6() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("foo");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"foo\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID7() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID8() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("42");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"42\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID9() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("\"");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
	}

	@Test
	void testGetAgentByRoleID10() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("'");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Request");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Request"));
		assertEquals(
				"{\"data\":{\"response\":\"\\u0027\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

	@Test
	void testGetAgentByRoleID12() throws IEMRException, com.iemr.common.utils.exception.IEMRException {

		// Arrange
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getAgentByRoleID(Mockito.<String>any())).thenReturn("");

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		String actualAgentByRoleID = iemrAdminController.getAgentByRoleID("Failed with generic error");

		// Assert
		verify(iemrAdminUserService).getAgentByRoleID(eq("Failed with generic error"));
		assertEquals(
				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
				actualAgentByRoleID);
	}

//
//	@Test
//	void testUserAuthenticateByEncryption() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetrolewrapuptime() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetrolewrapuptime() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		M_Role m_Role = new M_Role();
//		m_Role.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		m_Role.setCreatedDate(mock(Timestamp.class));
//		m_Role.setDeleted(true);
//		m_Role.setIsWrapUpTime(true);
//		m_Role.setLastModDate(mock(Timestamp.class));
//		m_Role.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
//		m_Role.setRoleDesc("Role Desc");
//		m_Role.setRoleID(1);
//		m_Role.setRoleName("Role Name");
//		m_Role.setWrapUpTime(1);
//		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
//		when(iemrAdminUserService.getrolewrapuptime(Mockito.<Integer>any())).thenReturn(m_Role);
//
//		IEMRAdminController iemrAdminController = new IEMRAdminController();
//		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);
//
//		// Act
//		String actualGetrolewrapuptimeResult = iemrAdminController.getrolewrapuptime(1);
//
//		// Assert
//		verify(iemrAdminUserService).getrolewrapuptime(Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"RoleID\":1,\"RoleName\":\"Role Name\",\"RoleDesc\":\"Role Desc\",\"Deleted\":true,\"isWrapUpTime\":true"
//						+ ",\"WrapUpTime\":1},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualGetrolewrapuptimeResult);
//	}
//
//	/**
//	 * Method under test: {@link IEMRAdminController#getrolewrapuptime(Integer)}
//	 */
	@Test
	void testGetrolewrapuptime2() {

		// Arrange
		M_Role m_Role = mock(M_Role.class);
		doNothing().when(m_Role).setCreatedBy(Mockito.<String>any());
		doNothing().when(m_Role).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(m_Role).setDeleted(anyBoolean());
		doNothing().when(m_Role).setIsWrapUpTime(Mockito.<Boolean>any());
		doNothing().when(m_Role).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(m_Role).setModifiedBy(Mockito.<String>any());
		doNothing().when(m_Role).setRoleDesc(Mockito.<String>any());
		doNothing().when(m_Role).setRoleID(anyInt());
		doNothing().when(m_Role).setRoleName(Mockito.<String>any());
		doNothing().when(m_Role).setWrapUpTime(Mockito.<Integer>any());
		m_Role.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_Role.setCreatedDate(mock(Timestamp.class));
		m_Role.setDeleted(true);
		m_Role.setIsWrapUpTime(true);
		m_Role.setLastModDate(mock(Timestamp.class));
		m_Role.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_Role.setRoleDesc("Role Desc");
		m_Role.setRoleID(1);
		m_Role.setRoleName("Role Name");
		m_Role.setWrapUpTime(1);
		IEMRAdminUserServiceImpl iemrAdminUserService = mock(IEMRAdminUserServiceImpl.class);
		when(iemrAdminUserService.getrolewrapuptime(Mockito.<Integer>any())).thenReturn(m_Role);

		IEMRAdminController iemrAdminController = new IEMRAdminController();
		iemrAdminController.setIemrAdminUserService(iemrAdminUserService);

		// Act
		iemrAdminController.getrolewrapuptime(1);

		// Assert
		verify(m_Role).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(m_Role).setCreatedDate(Mockito.<Timestamp>any());
		verify(m_Role).setDeleted(eq(true));
		verify(m_Role).setIsWrapUpTime(Mockito.<Boolean>any());
		verify(m_Role).setLastModDate(Mockito.<Timestamp>any());
		verify(m_Role).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(m_Role).setRoleDesc(eq("Role Desc"));
		verify(m_Role).setRoleID(eq(1));
		verify(m_Role).setRoleName(eq("Role Name"));
		verify(m_Role).setWrapUpTime(Mockito.<Integer>any());
		verify(iemrAdminUserService).getrolewrapuptime(Mockito.<Integer>any());
	}
//
//	@Test
//	void testValidateSecurityQuestionAndAnswer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUserAuthenticateBhavya() {
//		fail("Not yet implemented");
//	}

}
