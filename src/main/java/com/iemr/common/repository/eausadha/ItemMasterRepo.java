package com.iemr.common.repository.eausadha;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.eausadha.ItemMaster;

@Repository
public interface ItemMasterRepo extends CrudRepository<ItemMaster, Integer> {
	

	List<ItemMaster> findByItemCode(String drugId);


}
