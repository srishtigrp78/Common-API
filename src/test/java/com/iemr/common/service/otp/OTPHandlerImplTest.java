package com.iemr.common.service.otp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.otp.OTPRequestParsor;
import com.iemr.common.service.users.IEMRAdminUserServiceImpl;
import com.iemr.common.utils.http.HttpUtils;

@ExtendWith(MockitoExtension.class)
class OTPHandlerImplTest {

	@InjectMocks
	OTPHandlerImpl otpHandler;

	@Mock
	HttpUtils httpUtils;

	@Mock
	private IEMRAdminUserServiceImpl iEMRAdminUserServiceImpl;

	@Mock
	private OTPRequestParsor requestParsor;

//	@Test
//	void testOTPHandlerImpl() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSendOTP() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testValidateOTP() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testResendOTP() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGenerateOTP() {
//		fail("Not yet implemented");
//	}

}
