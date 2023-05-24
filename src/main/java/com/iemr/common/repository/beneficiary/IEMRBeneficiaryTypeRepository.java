package com.iemr.common.repository.beneficiary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.beneficiary.BeneficiaryType;

@Repository
@RestResource(exported = false)
public interface IEMRBeneficiaryTypeRepository extends CrudRepository<BeneficiaryType, Long>{

}
