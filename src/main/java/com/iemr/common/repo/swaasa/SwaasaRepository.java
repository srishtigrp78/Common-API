package com.iemr.common.repo.swaasa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.swaasa.Swaasa;

@Repository
@RestResource(exported = false)
public interface SwaasaRepository extends CrudRepository<Swaasa, Long> {
	public List<Swaasa> findByAssessmentId(String assessmentId);

	public List<Swaasa> findByPatientId(Long patientId);
}
