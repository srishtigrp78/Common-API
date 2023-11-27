package com.iemr.common.repository.eausadha;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.eausadha.ItemStockEntry;

@Repository
@RestResource(exported = false)
public interface ItemStockEntryRepo extends CrudRepository<ItemStockEntry, Integer> {
	
	ItemStockEntry findByItemIDAndBatchNo(Integer itemId, String batchNo);

}
