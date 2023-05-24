package com.iemr.common.dto.identity;

import java.math.BigInteger;

import lombok.Data;

@Data
public class BeneficiaryCreateResp {

	private BigInteger benId;
	private BigInteger benRegId;
}
