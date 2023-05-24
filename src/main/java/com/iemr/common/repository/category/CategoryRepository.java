package com.iemr.common.repository.category;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.category.CategoryDetails;

@Repository
@RestResource(exported = false)
public interface CategoryRepository extends CrudRepository<CategoryDetails, Integer>
{

	// @Query("select categoryID, categoryName from CategoryDetails where deleted=false " + "order by categoryName asc")
	// public ArrayList<Objects[]> findBy();
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false order by categoryName asc")
	public ArrayList<CategoryDetails> findBy();

	// @Query("select categoryID, categoryName from CategoryDetails "
	// + "where deleted=false and subServiceID=:subServiceID "
	// + "order by categoryName asc")
	// public ArrayList<Objects[]> getAllCategories(@Param("subServiceID") Integer subServiceID);
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID);

	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID and isWellBeing = :isWellBeing "
			+ "order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID,
			@Param("isWellBeing") Boolean isWellBeing);
	
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and feedbackNatureID=:feedbackNatureID and providerServiceMapID = :providerServiceMapID "
			+ "order by categoryName asc")
	public ArrayList<CategoryDetails> getCategoriesByNatureID(@Param("feedbackNatureID") Integer feedbackNatureID,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	// @Query("select categoryID, categoryName from CategoryDetails "
	// + "where deleted=false and subServiceID=:subServiceID " + "and providerServiceMapID=:providerServiceMapID "
	// + "order by categoryName asc")
	// public ArrayList<Objects[]> getAllCategories(@Param("subServiceID") Integer subServiceID,
	// @Param("providerServiceMapID") Integer providerServiceMapID);
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID and providerServiceMapID=:providerServiceMapID "
			+ "order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID and providerServiceMapID=:providerServiceMapID "
			+ "and isWellBeing = :isWellBeing order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID,
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("isWellBeing") Boolean isWellBeing);
}
