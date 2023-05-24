package com.iemr.common.repository.lonic;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import com.iemr.common.data.lonic.LonicDescription;


@Repository
@RestResource(exported = false)
public interface LonicRepository extends JpaRepository<LonicDescription, Long> {
	
	@Query("SELECT DISTINCT s FROM LonicDescription s WHERE "
			+ "(s.component LIKE %:term% OR "
			+ "s.system LIKE %:term% OR "
			+ "s.loinc_Num LIKE %:term% OR "
			+ "s.class1 LIKE %:term% OR "
			+ "s.long_common_name LIKE %:term%) "
			+ "AND s.status = 'ACTIVE'")
	public Page<LonicDescription> findLonicRecordList(@Param("term") String term, Pageable pageable);

}
