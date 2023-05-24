package com.iemr.common.repository.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.UserSecurityQMapping;

@Repository
@RestResource(exported = false)
public interface IEMRUserSecurityQuesAnsRepository extends CrudRepository<UserSecurityQMapping, Long> {

}
