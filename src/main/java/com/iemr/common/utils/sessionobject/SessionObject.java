package com.iemr.common.utils.sessionobject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.redis.RedisSessionException;
import com.iemr.common.utils.redis.RedisStorage;

@Component
public class SessionObject {

	Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

	private RedisStorage objectStore;

	@Autowired
	public void setObjectStore(RedisStorage objectStore) {

		this.objectStore = objectStore;
	}

	public SessionObject() {

		extendExpirationTime = ConfigProperties.getExtendExpiryTime();
		sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
	}

	private boolean extendExpirationTime;// =
											// configProperties.getExtendExpiryTime();
	private int sessionExpiryTime;// = configProperties.getSessionExpiryTime();

	public String getSessionObject(String key) throws RedisSessionException {
		Boolean extendExpirationTime = ConfigProperties.getExtendExpiryTime();
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
		return objectStore.getObject(key, extendExpirationTime, sessionExpiryTime);
	}

	public String setSessionObject(String key, String value) throws RedisSessionException {
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
		return objectStore.setObject(key, value, sessionExpiryTime);
	}

	public String updateSessionObject(String key, String value) throws RedisSessionException {
		Boolean extendExpirationTime = ConfigProperties.getExtendExpiryTime();
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
		updateConcurrentSessionObject(key, value, extendExpirationTime, sessionExpiryTime);
		return objectStore.updateObject(key, value, extendExpirationTime, sessionExpiryTime);

	}

	private void updateConcurrentSessionObject(String key, String value, Boolean extendExpirationTime,
			Integer sessionExpiryTime) {
		try {
			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(value);
			jsnOBJ = jsnElmnt.getAsJsonObject();
			logger.info("updating key:" + jsnOBJ.get("userName"));
			if (jsnOBJ.has("userName") && jsnOBJ.get("userName") != null) {
				objectStore.updateObject(jsnOBJ.get("userName").getAsString().trim().toLowerCase(), key,
						extendExpirationTime, sessionExpiryTime);
			}
		} catch (Exception e) {

		}
	}

	public void deleteSessionObject(String key) {
		try {
			logger.info("Deleting key " + key);
			objectStore.deleteObject(key);
			logger.info("Deleted key " + key);
		} catch (Exception e) {
			logger.error("deleteSessionObject failed with error " + e.getMessage(), e);
		}
	}

	public String setSessionObjectForChangePassword(String key, String value) throws RedisSessionException {
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTimeForChangePassword();
		return objectStore.setObject(key, value, sessionExpiryTime);
	}

	public String getSessionObjectForChangePassword(String key) throws RedisSessionException {
		Boolean extendExpirationTime = ConfigProperties.getExtendExpiryTimeForChangePassword();
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTimeForChangePassword();
		// RedisStorage objectStore = new RedisStorage();
		return objectStore.getObject(key, extendExpirationTime, sessionExpiryTime);
	}
}
