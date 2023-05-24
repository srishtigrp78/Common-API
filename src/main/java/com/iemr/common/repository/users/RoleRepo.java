package com.iemr.common.repository.users;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.M_Role;


@Repository
@RestResource(exported = false)
public interface RoleRepo extends CrudRepository<M_Role, Integer>
{
	
}