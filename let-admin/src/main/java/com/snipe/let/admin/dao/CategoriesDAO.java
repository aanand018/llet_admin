package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.CategoriesDomain;

public interface CategoriesDAO {

	public String addCategories(CategoriesDomain ctegoriesDomain) throws Exception;

	public List<CategoriesDomain> getCategories() throws Exception;

	public CategoriesDomain getCategoriesById(long categoriesId) throws Exception;

	public String updateCategories(CategoriesDomain categoriesDomain) throws Exception;

	public String deleteCategories(long categoriesId) throws Exception;
	
	public List<CategoriesDomain> getCategoriesByTypeId(long categoriesTypeId) throws Exception;

}
