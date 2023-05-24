package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.userbeneficiary.StateModel;
import com.iemr.common.repository.location.LocationStateRepository;

public abstract class StateMapperDecorator implements StateMapper
{
	@Autowired
	LocationStateRepository locationStateRepo;
	
	public StateModel StateToModelByID(Integer stateID){
		StateModel state = new StateModel();
		state = StateToModel(locationStateRepo.findByStateID(stateID));
		return state;
	}
}
