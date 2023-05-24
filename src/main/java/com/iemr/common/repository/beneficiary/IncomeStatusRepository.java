package com.iemr.common.repository.beneficiary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.beneficiary.BeneficiaryIncomeStatus;

@Repository
@RestResource(exported = false)
public interface IncomeStatusRepository extends CrudRepository<BeneficiaryIncomeStatus, Integer>
{
}
