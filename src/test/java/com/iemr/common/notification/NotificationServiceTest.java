package com.iemr.common.notification;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.notification.EmergencyContacts;
import com.iemr.common.data.notification.NotificationType;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.repository.notification.EmergencyContactsRepository;
import com.iemr.common.service.notification.NotificationServiceImpl;
import com.iemr.common.utils.mapper.InputMapper;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DataJpaTest
public class NotificationServiceTest
{
	@InjectMocks
	private NotificationServiceImpl serviceSpy;
	@Spy
	private EmergencyContactsRepository emergencyContactsRepository;

	@Before
	public void initialize()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createEmergencyContactsSuccess01()
	{
		try
		{
			EmergencyContacts[] emergencyContactsSuccess01 = InputMapper.gson().fromJson(
					ConstantEmergencyContacts.createEmergencyContactsSuccessRequest1, EmergencyContacts[].class);
			ProviderServiceMapping providerServiceMap = InputMapper.gson()
					.fromJson(ConstantEmergencyContacts.providerServiceMapString1, ProviderServiceMapping.class);
			NotificationType notificationType = InputMapper.gson()
					.fromJson(ConstantEmergencyContacts.notificationTypeString1, NotificationType.class);
			SimpleDateFormat format = new SimpleDateFormat(ConstantEmergencyContacts.dateTimeFormat);
			Timestamp time = new Timestamp(format.parse(ConstantEmergencyContacts.creationDateTime).getTime());
			Object[] emergencyContactsResult = { 2, 2, null, "1234567890", "test contacts API", 1224,
					providerServiceMap, 18, notificationType, null, false, time, null };
			Set<Object[]> resultSet = new HashSet<Object[]>();
			resultSet.add(emergencyContactsResult);
			EmergencyContacts insertedContacts = EmergencyContacts.initializeEmergencyContacts(
					(Integer) emergencyContactsResult[0], (Integer) emergencyContactsResult[1],
					(String) emergencyContactsResult[2], (String) emergencyContactsResult[3],
					(String) emergencyContactsResult[4], (Integer) emergencyContactsResult[5],
					(ProviderServiceMapping) emergencyContactsResult[6], (Integer) emergencyContactsResult[7],
					(NotificationType) emergencyContactsResult[8], (String) emergencyContactsResult[9],
					(Boolean) emergencyContactsResult[10], (Timestamp) emergencyContactsResult[11],
					(Designation) emergencyContactsResult[12]);
			doReturn(insertedContacts).when(emergencyContactsRepository).save(emergencyContactsSuccess01[0]);
			String response = serviceSpy
					.createEmergencyContacts(ConstantEmergencyContacts.createEmergencyContactsSuccessRequest1)
					.toString();
			assertTrue("createEmergencyContacts success 1 ",
					response.equals(ConstantEmergencyContacts.createEmergencyContactsSuccessResonse1));
			assertNotNull("createEmergencyContacts success 1 ", response);
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("createEmergencyContacts success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsFailure1()
	{
		// try
		// {
		// doReturn(ConstantAgentStatus.urlFailureResponse1).when(serviceSpy)
		// .callUrl(ConstantAgentStatus.urlFailureRequest1);
		// String response = serviceSpy.getAgentCallStats(ConstantEmergencyContacts.failureRequest1)
		// .toString();
		// assertTrue("getAgentCallStats failure 1 ", response.equals(ConstantAgentStatus.failureResponse1));
		// } catch (Exception e)
		// {
		// e.printStackTrace();
		// fail("getAgentCallStats failure 1 failed with " + e.getMessage(), e);
		// }
	}

}
