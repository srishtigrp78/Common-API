package com.iemr.common.service.category;

import java.util.List;

import com.iemr.common.data.category.CategoryDetails;

public interface CategoryService
{

	public abstract List<CategoryDetails> getAllCategories();

	List<CategoryDetails> getAllCategories(String request) throws Exception;

}
