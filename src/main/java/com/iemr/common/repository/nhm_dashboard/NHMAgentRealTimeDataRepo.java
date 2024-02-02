package com.iemr.common.repository.nhm_dashboard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.nhm_dashboard.AgentRealTimeData;
@Repository
@RestResource(exported = false)
public interface NHMAgentRealTimeDataRepo extends CrudRepository<AgentRealTimeData, Long>{

}
