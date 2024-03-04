package com.iemr.common.repository.covid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.covid.CovidDoseType;
@Repository
public interface CovidDoseTypeRepo extends CrudRepository<CovidDoseType, Integer>{

}
