package com.iemr.common.dto.identity;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;

@Data
public class BenDetailForOutboundDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigInteger benRegId;
    private BigInteger beneficiaryDetailsId;
    private String benId;
    private String firstName;
    private String middleName; 
    private String lastName;
}
