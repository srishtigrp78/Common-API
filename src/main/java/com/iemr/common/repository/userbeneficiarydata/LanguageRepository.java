package com.iemr.common.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.userbeneficiarydata.Language;

@Repository
@RestResource(exported = false)
public abstract interface LanguageRepository extends CrudRepository<Language, Integer>
{
	@Query("select languageID, languageName from Language where deleted = false order by languageName asc")
	public abstract Set<Objects[]> findAciveLanguages();

	public Language findLanguageByLanguageID(Integer languageID);
}
