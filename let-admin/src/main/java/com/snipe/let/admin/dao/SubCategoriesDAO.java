package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.SubCategoriesDomain;

public interface SubCategoriesDAO {

	public SubCategoriesDomain addSubCategories(SubCategoriesDomain subCategoriesDomain) throws Exception;

	public List<SubCategoriesDomain> getSubCategories() throws Exception;

	public SubCategoriesDomain getSubCategoriesById(long SubCategoriesId) throws Exception;

	public String updateSubCategories(SubCategoriesDomain subCategoriesDomain) throws Exception;

	public String deleteSubCategories(long subCategoriesId) throws Exception;
	
	public List<SubCategoriesDomain> getSubCategoriesByCatId(long categoriesId) throws Exception;

	public List<SubCategoriesDomain> getSubCategoriesByCatTypeId(long categoriesTypeId) throws Exception;

}
