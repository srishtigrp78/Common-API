package com.iemr.common.service.category;

import java.util.List;

import com.iemr.common.data.category.SubCategoryDetails;

public interface SubCategoryService
{

	public abstract List<SubCategoryDetails> getSubCategories(Integer id);

}
