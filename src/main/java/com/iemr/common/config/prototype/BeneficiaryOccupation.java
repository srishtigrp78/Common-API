package com.iemr.common.config.prototype;

import lombok.Data;

@Data
/**
 * @author VI314759
 *
 */
public class BeneficiaryOccupation
{
	private Long occupationID;
	private String occupationType;
	private Boolean deleted;
	private String createdby;
	private String modifiedby;
	private String key;
	private String operation;

	public BeneficiaryOccupation()
	{

	}
}
