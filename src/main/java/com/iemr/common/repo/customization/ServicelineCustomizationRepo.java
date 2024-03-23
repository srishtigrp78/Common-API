package com.iemr.common.repo.customization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.common.data.customization.ServicelineCustomization;

public interface ServicelineCustomizationRepo extends CrudRepository<ServicelineCustomization, Integer> {

}
