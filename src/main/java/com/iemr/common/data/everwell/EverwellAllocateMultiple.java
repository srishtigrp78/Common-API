package com.iemr.common.data.everwell;
import java.math.BigInteger;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class EverwellAllocateMultiple{
	
	/**
	 * allocate no to each agent
	 */
	@SerializedName("allocateNo")
	@Expose
	private Integer allocateNo;
	
	/**
	 * list of selected users
	 */
	@SerializedName("agentId")
	@Expose
	List<Integer> agentId;
	
	/**
	 * All Outbound calls
	 */
	@SerializedName("outboundCallRequests")
	@Expose
	EverwellDetails[] outboundCallRequests;

}
