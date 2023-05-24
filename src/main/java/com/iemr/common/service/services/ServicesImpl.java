package com.iemr.common.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.users.ServiceMaster;
import com.iemr.common.repository.services.ServiesRepository;

@Service
public class ServicesImpl implements Services {

	private ServiesRepository serviesRepository;
	@Autowired
	public void setServiesRepository(ServiesRepository serviesRepository) {
		this.serviesRepository = serviesRepository;
	}

	@Override
	public List<ServiceMaster> servicesList() {
		List<ServiceMaster> servicesList = new ArrayList<ServiceMaster>();
		Set<Objects[]> servicesResult = serviesRepository.getActiveServicesList();
		for (Object[] object : servicesResult) {
			if (object != null && object.length >= 4) {
				servicesList.add(new ServiceMaster((Integer) object[0], (String) object[1], (String) object[2],
						(Boolean) object[3]));
			}
		}
		return servicesList;
	}

}
