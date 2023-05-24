package com.iemr.common.data.otp;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class OTPRequestParsor {

	private String mobNo;
	private int otp;
}
