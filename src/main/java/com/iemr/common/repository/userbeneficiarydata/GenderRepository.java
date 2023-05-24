package com.iemr.common.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.Gender;

@Repository
@RestResource(exported = false)
public abstract interface GenderRepository extends CrudRepository<Gender, Long> {
	@Query("select genderID, genderName from Gender where deleted = false order by genderName asc")
	public abstract Set<Objects[]> findAciveGenders();
	
	@Query("select gender from Gender gender where gender.deleted = false and gender.genderID = :genderID")
	public Gender findGendersByID(@Param("genderID") Integer genderID);
}
