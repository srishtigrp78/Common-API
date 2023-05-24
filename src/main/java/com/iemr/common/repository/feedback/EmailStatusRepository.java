package com.iemr.common.repository.feedback;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.EmailStatus;

@Repository
@RestResource(exported = false)
public interface EmailStatusRepository extends CrudRepository<EmailStatus, Long>
{

	@Query("select emailStatusID, emailStatus, emailStatusDesc from EmailStatus where deleted=false "
			+ "order by emailStatus asc")
	public ArrayList<Objects[]> findAllEmailStatus();

	@Query("select emailStatusID from EmailStatus where deleted=false and emailStatus='New' "
			+ "order by emailStatus asc")
	public Integer findNewEmailStatusID();
}
