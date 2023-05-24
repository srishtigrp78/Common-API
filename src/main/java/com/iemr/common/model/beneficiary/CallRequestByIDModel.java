package com.iemr.common.model.beneficiary;

import lombok.Data;

@Data
public class CallRequestByIDModel
{
	private String callID;
	private Boolean is1097 = false;
}
