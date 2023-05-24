package com.iemr.common.service.services;

import java.util.List;

import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.data.category.SubCategoryDetails;
import com.iemr.common.data.service.SubService;
import com.iemr.common.utils.exception.IEMRException;

public interface CommonService
{
	public Iterable<CategoryDetails> getCategories();

	public Iterable<CategoryDetails> getCategories(String request) throws IEMRException;

	public Iterable<SubCategoryDetails> getSubCategories(String request) throws IEMRException;

	public Iterable<SubService> getActiveServiceTypes(String request) throws IEMRException;
	
//	public List<SubCategoryDetails> getSubCategoriesOfProvider(Integer providerServiceMapID);

	public List<SubCategoryDetails> getSubCategoryFiles(String request) throws IEMRException;
	
	public List<SubCategoryDetails> getSubCategoryFilesWithURL(String request) throws IEMRException;

}
