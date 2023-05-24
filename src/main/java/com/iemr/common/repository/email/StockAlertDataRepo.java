package com.iemr.common.repository.email;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.email.StockAlertData;

@Repository
public interface StockAlertDataRepo extends CrudRepository<StockAlertData, Long> {

	@Query("Select v from StockAlertData v")
	List<StockAlertData> checkThresholdLimit();
}

