package com.iemr.common.utils.config;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigProperties.class)
public class ConfigPropertiesTest {

	private String redisUrl = "localhost";
	private int redisPort = 6379;
	private int sessionExpiryTime = 180;
	private boolean extendExpiryTime = true;
	// @Autowired
	private ConfigProperties props = new ConfigProperties();

	@BeforeClass
	public static void setProperties() {
	}

	@Test
	public void testGetRedisUrl() {
		try {
			assertEquals(redisUrl, props.getRedisUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRedisPort() {
		try {
			assertEquals(redisPort, props.getRedisPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetExtendExpiryTime() {
		try {
			assertEquals(extendExpiryTime, props.getExtendExpiryTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetSessionExpiryTime() {
		try {
			assertEquals(sessionExpiryTime, props.getSessionExpiryTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
