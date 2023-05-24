package com.iemr.common.repository.callhandling;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.users.ProviderServiceMapping;

@Repository
@RestResource(exported = false)
public interface DialPreferenceManualRepository extends CrudRepository<ProviderServiceMapping, Long>{

	@Transactional
	@Modifying
	@Query("update ProviderServiceMapping set isDialPreferenceManual = :isDialPreferenceManual, previewWindowTime = :previewWindowTime "
			+ " where providerServiceMapID = :providerServiceMapID")
	public int updateautoPreviewDialFlag(@Param("providerServiceMapID") Integer providerServiceMapID,
			 @Param("isDialPreferenceManual") Boolean isDialPreferenceManual, @Param("previewWindowTime") Integer previewWindowTime);

	
	@Query("SELECT m_ProviderServiceMapping.isDialPreferenceManual, m_ProviderServiceMapping.previewWindowTime "
			+ "FROM ProviderServiceMapping m_ProviderServiceMapping "
			+ "where m_ProviderServiceMapping.providerServiceMapID = :providerServiceMapID ")
	ArrayList<Objects[]> checkAutoPreviewDialing(
			@Param("providerServiceMapID") Integer providerServiceMapID);

}
