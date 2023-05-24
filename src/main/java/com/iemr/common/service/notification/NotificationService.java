package com.iemr.common.service.notification;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONException;

import com.iemr.common.utils.exception.IEMRException;

public interface NotificationService {
	String getNotification(String request) throws IEMRException;

	String getSupervisorNotification(String request) throws IEMRException;

	String createNotification(String request) throws NoSuchAlgorithmException, IOException, IEMRException, Exception;

	String updateNotification(String request)
			throws JSONException, NoSuchAlgorithmException, IOException, IEMRException, Exception;

	String getNotificationType(String request) throws IEMRException;

	String createNotificationType(String request) throws IEMRException;

	String updateNotificationType(String request) throws JSONException, IEMRException;

	String getEmergencyContacts(String request) throws IEMRException;

	String getSupervisorEmergencyContacts(String request) throws IEMRException;

	String createEmergencyContacts(String request)
			throws NoSuchAlgorithmException, IOException, IEMRException, Exception;

	String updateEmergencyContacts(String request)
			throws JSONException, NoSuchAlgorithmException, IOException, IEMRException, Exception;
}
