package com.iemr.common.dto.identity;

import java.io.Serializable;

import lombok.Data;

@Data
public class BenDetailForCallHistory implements Serializable {

	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private String spouseName;
	
	
}
