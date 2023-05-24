package com.iemr.common.service.otp;

import org.json.JSONObject;

import com.iemr.common.data.otp.OTPRequestParsor;

/**
 * 
 * @author NE298657
 *
 */

public interface OTPHandler {

	public String sendOTP(OTPRequestParsor obj) throws Exception;

	public JSONObject validateOTP(OTPRequestParsor obj) throws Exception;

	public String resendOTP(OTPRequestParsor obj) throws Exception;
}
