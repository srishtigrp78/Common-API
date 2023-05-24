package com.iemr.common.repository.uptsu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.uptsu.FacilityMaster;

@Repository
public interface FacilityMasterRepo extends CrudRepository<FacilityMaster, Integer> {
	
	List<FacilityMaster> findByProviderServiceMapIDAndBlockNameAndDeleted(Integer psmId, String blockName, Boolean deleted);

}
