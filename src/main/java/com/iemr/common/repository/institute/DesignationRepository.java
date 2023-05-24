package com.iemr.common.repository.institute;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.institute.InstituteType;

@Repository
@RestResource(exported = false)
public interface DesignationRepository extends CrudRepository<Designation, Integer> {
	@Query("select new Designation(designation.designationID, designation.designationName) from Designation designation "
			+ "where designation.deleted = false order by designation.designationName asc")
	List<Designation> findAciveDesignations();

}
