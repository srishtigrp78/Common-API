package com.iemr.common.notification;

import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.controller.notification.NotificationController;
import com.iemr.common.cti.Constants;
import com.iemr.common.service.notification.NotificationService;
import com.iemr.common.service.notification.NotificationServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotificationControllerTest
{
	@InjectMocks
	private NotificationController controllerSpy = spy(NotificationController.class);
	private NotificationService ctiServiceSpy = spy(new NotificationServiceImpl());

	MockHttpServletRequest request = new MockHttpServletRequest();
	MockHttpServletRequest requestNoIP = new MockHttpServletRequest();

	@Before
	public void initailize()
	{
		request.setRemoteAddr(Constants.REQUESTOR_IP);
		requestNoIP.setRemoteAddr("");
	}	
}
