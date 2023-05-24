package com.iemr.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.model.beneficiary.BenRelationshipTypeModel;
import com.iemr.common.repository.beneficiary.BeneficiaryRelationshipTypeRepository;

public abstract class RelationshipMapperDecorator implements RelationshipMapper

{
	@Autowired
	BeneficiaryRelationshipTypeRepository relationshipRepository;

	public BenRelationshipTypeModel createRelationshipTypesByID(Integer relationship)
	{
		BenRelationshipTypeModel benRelationshipTypeModel = new BenRelationshipTypeModel();
		if (relationship != null)
		{
			benRelationshipTypeModel = createRelationshipTypes(relationshipRepository.findByID(relationship));
		}

		return benRelationshipTypeModel;
	}
}
