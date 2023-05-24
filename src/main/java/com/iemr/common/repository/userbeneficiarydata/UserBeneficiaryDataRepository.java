package com.iemr.common.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.Gender;

@Repository
@RestResource(exported = false)
public interface UserBeneficiaryDataRepository extends CrudRepository<Gender, Long> {
	@Query("select genderID, genderName from Gender where deleted = false")
	Set<Objects[]> findActiveGenders();
}
