package com.iemr.common.dto.identity;

import lombok.Data;

@Data
public class Phone {
	private String phoneNum;
	private String phoneType;
	private Boolean isPreferredCallIncoming;
	private Boolean isPreferredCallOutgoing;
	private Boolean isPreferredForSMSSend;
	private Boolean isPreferredForSMSRecv;
	private Boolean isSmartPhone;
	private Boolean isSelfNumber;
	private String belongsToBenRegId;
	private String belongsToName;
}

